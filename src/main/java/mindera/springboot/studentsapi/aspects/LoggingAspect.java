package mindera.springboot.studentsapi.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* mindera.mindswap.aveiro.module2.springboot.studentsapi.controller.HelloController.hello())")
    public void logBeforeHello(JoinPoint joinPoint) {
        logger.info("Before " + joinPoint.getSignature().getName() + " method call");
    }

    @AfterReturning(pointcut = "execution(* mindera.mindswap.aveiro.module2.springboot.studentsapi.controller.HelloController.helloList())", returning = "result")
    public void logAfterHelloList(JoinPoint joinPoint, Object result) {
        logger.info("After " + joinPoint.getSignature().getName() + " method call");
        logger.info("Response: " + result);
    }

    @AfterThrowing(pointcut = "execution(* mindera.mindswap.aveiro.module2.springboot.studentsapi.controller.DefaultController.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in " + joinPoint.getSignature().getName() + " method call");
        logger.error("Exception: " + exception);
    }


    @Around("execution(* mindera.mindswap.aveiro.module2.springboot.studentsapi.controller.CalculatorController.add(int, int))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        logger.info("Before " + joinPoint.getSignature().getName() + " method call");
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("After " + joinPoint.getSignature().getName() + " method call");
        logger.info("Execution time of " + joinPoint.getSignature().getName() + " method call: " + (endTime - startTime) + " milliseconds");
        return result;
    }


}
