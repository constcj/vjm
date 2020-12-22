<template>
  <div>
    <el-header class="header">
      <el-avatar icon="el-icon-user-solid" :size="40" class="el-avatar"></el-avatar>
      <el-button type="text" class="el-dropdown" @click="outsub">退出</el-button>
    </el-header>
    <el-row>
      <el-menu mode="horizontal" :router="true">
        <el-submenu index="1" class="el-menu1">
          <template slot="title">
            项目
            <el-badge :is-dot="Unprocessedtransactions" class="item1"></el-badge>
          </template>
          <el-menu-item index="1-1" align="center" route="/Manage">项目列表</el-menu-item>
          <el-menu-item
            index="1-2"
            align="center"
            v-if="this.$store.getters.getdisplaybool['creatproject']==='1'"
            route="/creatproject"
          >新建项目</el-menu-item>
          <el-menu-item
            index="1-3"
            align="center"
            v-if="this.$store.getters.getdisplaybool['creatprojectlist']==='1'"
            route="/creatprojectlist"
          >新建项目列表</el-menu-item>
          <el-menu-item
            index="1-4"
            align="center"
            v-if="this.$store.getters.getdisplaybool['receiveconfirmation']==='1'"
            route="/receiveconfirmation"
          >已分配项目列表</el-menu-item>
          <el-menu-item
            index="1-5"
            align="center"
            v-if="this.$store.getters.getdisplaybool['allocationitem']==='1'"
            route="/allocationitem"
          >
            <el-badge :is-dot="deepnodistr" class="item">未分配项目</el-badge>
          </el-menu-item>
          <el-menu-item
            index="1-6"
            v-if="this.$store.getters.getdisplaybool['deep']==='1'"
            align="center"
            route="/deep"
          >
            <el-badge :is-dot="deepcount" class="item">首次深化项目列表</el-badge>
          </el-menu-item>
          <el-menu-item
            index="1-7"
            v-if="this.$store.getters.getdisplaybool['deepse']==='1'"
            align="center"
            route="/deepse"
          >
            <el-badge :is-dot="deepcountse" class="item">最后深化项目列表</el-badge>
          </el-menu-item>
          <el-menu-item
            index="1-8"
            v-if="this.$store.getters.getdisplaybool['realdeep']==='1'"
            align="center"
            route="/realdeep"
          >已深化项目</el-menu-item>

          <el-menu-item
            index="1-9"
            v-if="this.$store.getters.getdisplaybool['designmanager']==='1'"
            align="center"
            route="/designmanager"
          >
            <el-badge :is-dot="designcount" class="item">设计分配</el-badge>
          </el-menu-item>

          <el-menu-item
            index="1-10"
            v-if="this.$store.getters.getdisplaybool['realdesignmanagerse']==='1'"
            align="center"
            route="/realdesignmanagerse"
          >
            <el-badge :is-dot="designcountse" class="item">设计完成</el-badge>
          </el-menu-item>

          <el-menu-item
            index="1-11"
            v-if="this.$store.getters.getdisplaybool['realdesignmanager']==='1'"
            align="center"
            route="/realdesignmanager"
          >
            <el-badge class="item">已分配项目</el-badge>
          </el-menu-item>
          <el-menu-item
            index="1-12"
            v-if="this.$store.getters.getdisplaybool['designperson']==='1'"
            align="center"
            route="/designperson"
          >
            <el-badge :is-dot="designcountsepe" class="item">数据填写</el-badge>
          </el-menu-item>
          <el-menu-item
            index="1-13"
            v-if="this.$store.getters.getdisplaybool['realdesignperson']==='1'"
            align="center"
            route="/realdesignperson"
          >
            <el-badge class="item">已完成项目</el-badge>
          </el-menu-item>
        </el-submenu>
        <el-menu-item index="1" route="/bbs">论坛中心</el-menu-item>
      </el-menu>
    </el-row>
    <el-container>
      <!-- <el-header style="text-align: right; font-size: 12px; height: 60px;" class="el-h2"></el-header> -->
      <el-main>
        <div class="breadcrumb">
          <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item
              v-for="item in BreadList"
              :key="item.path"
              :to="{ path: item.path}"
            >{{item.name}}</el-breadcrumb-item>
          </el-breadcrumb>
        </div>
        <keep-alive>
          <router-view />
        </keep-alive>
      </el-main>
    </el-container>
  </div>
</template>

<script>
var m = this.$options;
export default {
  data() {
    return {
      lockReconnect: false, //判断websocket是否连接
      str: null,
      mtoken: "",
      sock: null
    };
  },
  computed: {
    deepnodistr() {
      if (this.$store.getters.getdeepdistr > 0) {
        //分配深化师
        return true;
      } else {
        return false;
      }
    },
    deepcount() {
      if (this.$store.getters.getdeepcount > 0) {
        //初次深化数量
        return true;
      } else {
        return false;
      }
    },
    deepcountse() {
      if (this.$store.getters.getdeepcountse > 0) {
        //最后深化项目
        return true;
      } else {
        return false;
      }
    },
    designcount() {
      if (this.$store.getters.getdesigncount > 0) {
        //设计分配数据列表
        return true;
      } else {
        return false;
      }
    },
    designcountse() {
      if (this.$store.getters.getdesigncountse > 0) {
        //分配设计后项目
        return true;
      } else {
        return false;
      }
    },
    designcountsepe() {
      if (this.$store.getters.getdesigncountsepe > 0) {
        //设计师数据填写---------
        return true;
      } else {
        return false;
      }
    },

    Unprocessedtransactions() {
      if (
        sessionStorage.getItem("mposition") === "设计师" &&
        this.$store.getters.getdesigncountsepe > 0
      ) {
        return true;
      } else if (
        sessionStorage.getItem("mposition") === "负责人" &&
        (this.$store.getters.getdesigncountse > 0 ||
          this.$store.getters.getdesigncount > 0)
      ) {
        return true;
      } else if (
        sessionStorage.getItem("mposition") === "深化师" &&
        (this.$store.getters.getdeepcountse > 0 ||
          this.$store.getters.getdeepcount > 0)
      ) {
        return true;
      } else if (
        sessionStorage.getItem("mposition") === "深化负责人" &&
        this.$store.getters.getdeepdistr > 0
      ) {
        return true;
      } else {
        return false;
      }
    },

    BreadList() {
      return this.$route.meta.position;
    }
  },
  mounted() {
    //this.initwebsocket();
    this.$setWs.initWebSocket();
    this.$store.dispatch("setdisplaybool");
    this.$store.dispatch("creatNewProject");
    this.$store.dispatch("setProjectdb");
    this.$store.dispatch("setProjectdbwrong");
  },

  methods: {
    outsub() {
      // this.$store.dispatch("setouttype",true);
      this.$store.dispatch("outsubmit");
      this.$router.push({ path: "/" });
      // this.sock.onclose();
      //  this.$store.dispatch("setouttype",false);
    }

    // initwebsocket() {
    //   var thisstore = this.$store;
    //   var thisrouter = this.$router;
    //   var m = this.$options;
    //   this.sock = new WebSocket(
    //     "ws://192.168.100.143:8082/websocket/" + sessionStorage.getItem("id")
    //   )
    //   this.sock.onopen = function() {
    //     this.lockReconnect = true;
    //     console.log("web连接");
    //   };
    //   this.sock.onerror = function() {
    //     if (sessionStorage.length !== 0) {
    //       console.log(new Date().getTime());

    //       console.log("websocket连接错误重连");
    //        m.methods.initwebsocket();
    //       // thisrouter.push({ path: "/" });
    //     }
    //     console.log("websocket连接错误");
    //   };
    //   this.sock.onmessage = function(e) {
    //     if (e.data === "新增项目") {
    //       thisstore.dispatch("creatNewProject");
    //     } else if (e.data === "更新项目及项目数据") {
    //       thisstore.dispatch("creatNewProject");
    //       thisstore.dispatch("setProjectdb");
    //     } else if (e.data === "退出") {
    //       sessionStorage.clear();
    //       thisrouter.push({ path: "/" });
    //     }
    //   };
    //   this.sock.onclose = function() {
    //     if (sessionStorage.length !== 0) {
    //       console.log(new Date().getTime());

    //       console.log("断开重连");
    //      m.methods.initwebsocket();

    //       // thisrouter.push({ path: "/" });
    //     } else {
    //       console.log("断开连接");
    //     }
    //   };
    // }
  }
};
</script>

<style>
.item1 {
  margin-top: -20px;
  margin-right: 5px;
}
.el-menu1 {
  margin-left: 100px;
}
.breadcrumb {
  position: relative;
  width: 100%;
  height: 50px;
}
.header {
  position: relative;
  width: 100%;
  height: 100px;
  background-color: rgb(10, 185, 168);
  padding: 0px;
}
.el-h2 {
  background-color: rgb(64, 140, 184);
}
.el-c {
  position: relative;
  margin-right: 0px;
  width: 100%;
  height: 100%;
}

.el-avatar {
  position: absolute;
  top: 10px;
  right: 100px;
}
.el-dropdown {
  position: absolute;
  color: rgb(0, 0, 0);
  top: 12px;
  right: 50px;
}
.button1 {
  color: rgb(0, 0, 0);
  position: absolute;
  top: -10px;
  left: -250px;
}
.button2 {
  color: rgb(0, 0, 0);
  position: relative;
  top: 0px;
  left: -220px;
}
</style>