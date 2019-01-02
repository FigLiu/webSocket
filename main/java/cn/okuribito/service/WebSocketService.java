package cn.okuribito.service;

import org.springframework.stereotype.Service;

/**
 * all the impl classes of this interface can used to
 * handle message from webSocket
 */
@Service
public interface WebSocketService {

    /**
     * use className to get method to handle message
     * @param className className
     * @return class
     */
    default Class<?> returnHandleClass(String className){
        Class cla = getClass();
        try {
            cla = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cla;
    }
}
