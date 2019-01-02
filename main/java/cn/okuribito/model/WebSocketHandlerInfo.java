package cn.okuribito.model;

import java.lang.reflect.Method;

public class WebSocketHandlerInfo {

    private Class implClass;
    private Method handleMethod;

    public Class getImplClass() {
        return implClass;
    }

    public void setImplClass(Class implClass) {
        this.implClass = implClass;
    }

    public Method getHandleMethod() {
        return handleMethod;
    }

    public void setHandleMethod(Method handleMethod) {
        this.handleMethod = handleMethod;
    }


    public WebSocketHandlerInfo(Class implClass, Method handleMethod){
        this.implClass = implClass;
        this.handleMethod = handleMethod;
    }
}
