package cn.okuribito.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class ParamHandlerAdvice {

    /*
    * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
    * modifiers-pattern : 修饰符模式（public|private|protected|*）
    * 比如: execution(public * * (..)) 可以匹配所有的public方法
    * ret-type-pattern : 返回类型 根据返回类型匹配
    * 比如: execution(public void * (..)) 匹配所有返回类型是void的public方法
    *
    *
    */

    @Pointcut("@annotation(cn.okuribito.aop.ParamHandler)")
    public void pojo(){
    }

    @Before("pojo()")
    public Object handleWebSocketMessage(JoinPoint pj) throws Exception{
        System.out.println(Arrays.toString(pj.getArgs()));
        return "123";
    }
}
