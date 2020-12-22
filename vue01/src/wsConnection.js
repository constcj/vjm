//这里需要引入vuex
import store from './store';
import router from './router'

let wsConnection = {
    $ws: null,
    lockReturn: false,
    timeout: 60 * 1000 * 5,
    timeoutObj: null,
    timeoutNum: null,
    serverTimeoutObj: null,
    //初始化webSocket长连接
    initWebSocket: function () {
        let wsurl = "ws://zwwwwww.applinzi.com/websocket/" + sessionStorage.getItem("id")
        //let corpId = localStorage.getItem('corpId');
        // let name = localStorage.getItem('username');
        this.$ws = new WebSocket(wsurl);//写入地址 这里的地址可以在initWebSocket方法加入参数
        this.$ws.onopen = this.wsOpen;
        this.$ws.onclose = this.wsClose;
        this.$ws.onmessage = this.wsMsg;
        this.$ws.onerror = this.wsError;
    },
    //打开websocket
    wsOpen: function (e) {
        //开始websocket心跳
        wsConnection.startWsHeartbeat();
        console.log('ws success')
    },
    wsClose: function () {
        console.log(new Date().getTime());
        console.log('ws close')
    },
    wsMsg: function (e) {
console.log(e);

        if (e.data === "新增项目") {
            store.dispatch("creatNewProject");
        } else if (e.data === "更新项目及项目数据") {
            store.dispatch("creatNewProject");
            store.dispatch("setProjectdb");        
         } else if (e.data === "错误数据") {
            store.dispatch("setProjectdbwrong");
        } else if (e.data === "退出") {
            sessionStorage.clear();
            router.push({ path: "/" });
        }

        //每次接收到服务端消息后 重置websocket心跳
        wsConnection.resetHeartbeat();
        //服务端发送来的消息存到vuex
        //store.commit('web_socket_msg', msg)
    },
    wsError: function (err) {
        console.log(new Date().getTime());
        console.log(err, 'ws error');
        wsConnection.reconnect()
    },
    //重启websocket
    reconnect: function () {
        let _this = this;
        if (_this.lockReturn) {
            return;
        }
        _this.lockReturn = true;
        _this.timeoutNum && clearTimeout(_this.timeoutNum);
        _this.timeoutNum = setTimeout(function () {
            _this.initWebSocket();
            _this.lockReturn = false;
        }, 3000);
        console.log(_this.timeoutNum);
    },
    startWsHeartbeat: function () {
        let _this = this;
        _this.timeoutObj && clearTimeout(_this.timeoutObj);
        _this.serverTimeoutObj && clearTimeout(_this.serverTimeoutObj);

        console.log(_this.serverTimeoutObj);

        _this.timeoutObj = setInterval(function () {
            //判断websocket当前状态
            if (_this.$ws.readyState != 1) {
                _this.reconnect()
            }
        }, _this.timeout);
        console.log(_this.timeoutObj);

    },
    //重置websocket心跳
    resetHeartbeat: function () {
        let _this = this;
        clearTimeout(_this.timeoutObj);
        
        console.log(_this.serverTimeoutObj);

        clearTimeout(_this.serverTimeoutObj);
        _this.startWsHeartbeat()
    }
};

//抛出websocket对象
export default wsConnection