package intro.spring.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class TimeStampAspect {

    @Around("execution(* intro.spring..*(..))")
    public Object timeStamp(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("Start: " + joinPoint.toString());

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("End: " + joinPoint.toString());

        System.out.println("Time taken: " + (endTime - startTime) + "ms");
        return result;
    }
}
