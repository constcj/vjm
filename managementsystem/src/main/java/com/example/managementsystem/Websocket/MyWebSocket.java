package com.example.managementsystem.Websocket;

import javafx.print.Printer;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@ServerEndpoint(value = "/websocket/{id}")///{id}通过url获取用户id
@Component
public class MyWebSocket {

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }

    private static int onlineCount=0;

    //用户ID
    private String userId = "";

    private  static CopyOnWriteArrayList<MyWebSocket> webSocket=new CopyOnWriteArrayList<>();

    private Session session;

    /**
     * 连接建立成功调用的方法*/
    //@PathParam("id")String id,通过url获取用户id
    @OnOpen
    public void onOpen( @PathParam("id")String id,Session session){

        for (MyWebSocket item : webSocket
        ) {
            try {
              if ( item.userId.equals(id)) {
                  webSocket.remove(item);
                  subOnlineCount();
                  item.sendMessage("退出");
                }
            }catch (IOException E){
                E.printStackTrace();
            }
        }

        this.userId=id;
        this.session=session;
        webSocket.add(this);
        addOnlineCount();
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void coClose(){
        System.out.println(System.currentTimeMillis());
        webSocket.remove(this);
        subOnlineCount();
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message)
    {
        for (MyWebSocket item : webSocket
        ) {
            try {
                item.sendMessage(message);
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     * */
public static void sendInfo(String message){
    for (MyWebSocket item :
            webSocket) {
        try {
            item.sendMessage(message);
        }catch ( IOException E){
            E.printStackTrace();
        }
        }
    }

    /**
     * 主动退出登录
     * */
    public static void outS(String id){

        for (MyWebSocket item : webSocket
        ) {
                if ( item.userId.equals(id)) {
                    webSocket.remove(item);
                    subOnlineCount();
                }
        }

    }

}

