package ua.pp.lazin.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectHello {


    @Before("execution(* ua..*.*(..))")
    public void printHello() {
        System.out.println("Hello from Aspect");
    }
}
