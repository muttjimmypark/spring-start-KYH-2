package hellogroup.hellospringartiname.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* hellogroup.hellospringartiname..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long timeMs = System.currentTimeMillis() - start;
            System.out.println("END : " + joinPoint.toString() + ", HowLong : " + timeMs + "ms");
        }
    }
}
