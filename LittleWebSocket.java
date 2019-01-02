package cn.okuribito.webSocket;

import cn.okuribito.model.WebSocketHandlerInfo;
import cn.okuribito.service.WebSocketService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

@Component
@ServerEndpoint(value = "/webSocket/{path}",configurator = HttpSessionConfigurator.class)
public class LittleWebSocket {

    private static ConcurrentHashMap<String,String> messages = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String, HashSet<String>> pathSessions = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, WebSocketHandlerInfo> handlerInfos = new ConcurrentHashMap<>();

    private Session session;

    private String currentPath;

    private HttpSession httpSession;

    private static WebSocketService webSocketService;

    @OnOpen
    public void onOpen(@PathParam("path") String path, Session session, EndpointConfig config){
        HashSet<String> set = pathSessions.get(path);
        if(set == null){
            set = new HashSet<>();
            set.add(session.getId());
            pathSessions.put(path,set);
        }
        messages.put(session.getId(),"");
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getSimpleName());
        System.out.println(session.getId());
        this.session = session;
        this.currentPath = path;
        //this.httpSession = httpSession;
        //clients.put(httpSession.getId(),this);
    }



    @OnMessage
    public void onMessage(Session session,String message){
        System.out.println(message);
        messages.put(session.getId(),message);
        System.out.println(this.currentPath);
        Object result;
        try {
            Method method = handlerInfos.get(currentPath).getHandleMethod();
            Class cla = handlerInfos.get(currentPath).getImplClass();

            result = method.invoke(cla.newInstance(),new Object[3]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    @OnClose
    public void onClose(Session session){
        //clients.remove(httpSession.getId());
    }

    @OnError
    public void onError(Session session,Throwable e){
        e.printStackTrace();
    }

}
