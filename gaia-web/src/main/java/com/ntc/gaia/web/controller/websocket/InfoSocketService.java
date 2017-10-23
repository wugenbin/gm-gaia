package com.ntc.gaia.web.controller.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
/**
 * @author William
 * @date 2017/09/28
 */
@ServerEndpoint(value="/InfoSocket",configurator = SpringConfigurator.class)
@Component
public class InfoSocketService
{
    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<InfoSocketService> webSocketSet = new CopyOnWriteArraySet();

    private javax.websocket.Session session;

    public static synchronized CopyOnWriteArraySet<InfoSocketService> getWebSocketSet() {
        return webSocketSet;
    }

    @OnOpen

    public void onOpen(javax.websocket.Session session)
    {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    @OnClose
    public void onClose()
    {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, javax.websocket.Session session)
    {
        System.out.println("来自客户端的消息:" + message);

        for (InfoSocketService item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(javax.websocket.Session session, Throwable error)
    {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message)
            throws IOException
    {
        this.session.getBasicRemote().sendText(message);
    }

    public void sendMessageToClients(String message)
            throws IOException
    {
        for (InfoSocketService item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized int getOnlineCount()
    {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        onlineCount += 1;
    }

    public static synchronized void subOnlineCount() {
        onlineCount -= 1;
    }
}

