package cn.okuribito.webSocket;

import cn.okuribito.aop.ParamHandler;
import cn.okuribito.model.WebSocketHandlerInfo;
import cn.okuribito.service.WebSocketService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

@Component
public class RequestListener implements ServletRequestListener, ServletContextListener {

    public RequestListener(){}

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ((HttpServletRequest) sre.getServletRequest()).getSession();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce){
        ServletContext sc = sce.getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        if(ac == null){
            return;
        }
        Map<String, WebSocketService> result = ac.getBeansOfType(WebSocketService.class);
        for(Map.Entry<String, WebSocketService> entry:result.entrySet()){
            Class cla = null;
            try {
                cla = Class.forName(entry.getValue().getClass().getName());
                Method[] methods = cla.getMethods();
                for (Method method : methods){
                    ParamHandler paramHandler = method.getAnnotation(ParamHandler.class);
                    if(paramHandler != null){
                        LittleWebSocket.handlerInfos.put(paramHandler.value(),new WebSocketHandlerInfo(cla,method));
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
