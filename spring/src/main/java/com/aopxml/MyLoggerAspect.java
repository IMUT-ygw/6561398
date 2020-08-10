package com.aopxml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author nmtl_ygw
 * @Description  切面类
 * @date 2020/4/11 21:10
 */
@Component
public class MyLoggerAspect {

    /**
     * 前置通知
     * 注解必须有value属性，其值为切入点表达式
     */

    public void beforeMethod(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();
        System.out.println("方法名" + name + " ========方法参数" + args[0] + ", " + args[1]);
        System.out.println("前置通知，方法执行之前！");
    }

//    /**
//     * 后置通知
//     * 注解必须有value属性，其值为切入点表达式
//     */
//    public void afterMethod(JoinPoint joinPoint){
//        System.out.println("后置通知，方法执行之后finally处！");
//    }
//
//
//    /**
//     * 返回通知
//     * 注解必须有value属性，其值为切入点表达式
//     */
//    public void Returning(JoinPoint joinPoint,Object result){
//        System.out.println("返回通知，方法执行之后！");
//    }
//
//    /**
//     * 异常通知
//     * 注解必须有value属性，其值为切入点表达式
//     */
//    public void afterThrowing(Exception ex){
//        System.out.println("异常通知，方法执行之后！" + ex);
//    }
//
//    /**
//     * 环绕通知
//     * 注解必须有value属性，其值为切入点表达式
//     */
//    public Object afterThrowing(ProceedingJoinPoint joinPoint){
//        Object result = null;
//        try{
//            System.out.println("环绕前置通知~");
//           result = joinPoint.proceed();
//            System.out.println("环绕返回通知");
//            return result;
//        }catch (Throwable throwable){
//            System.out.println("环绕异常通知");
//        }finally {
//            System.out.println("环绕后置通知");
//        }
//        return -11111;
//    }
}
