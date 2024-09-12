package ir.stdev.reception.application.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* ir.stdev.reception.api..*.*(..))")
    private void allMethodsFromApiPackage() {
    }

    @Pointcut("execution(* ir.stdev.reception.controller..*.*(..))")
    private void allMethodsFromControllerPackage() {
    }

    @Pointcut("execution(* ir.stdev.reception.persistence..*.*(..))")
    private void allMethodsFromPersistencePackage() {
    }

    @Pointcut("execution(* ir.stdev.reception.service..*.*(..))")
    private void allMethodsFromServicePackage() {
    }

    @Pointcut("allMethodsFromApiPackage() || allMethodsFromControllerPackage() || allMethodsFromPersistencePackage() || allMethodsFromServicePackage()")
    private void allMethods() {
    }

    @Around("allMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        log.info("@Before execute of :: {}.{}() - {}", className, methodName, joinPoint.getArgs());
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object proceed = joinPoint.proceed();
        stopWatch.stop();
        log.info("@After execute of :: Execution time of {}.{}() :: {} ms - {}", className, methodName, stopWatch.getTotalTimeMillis(), proceed);
        return proceed;
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "exception")
    public void logThrowing(JoinPoint joinPoint, Exception exception) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();
        log.error("@Throws after execute of :: {}.{}() - ", className, methodName, exception);
    }
}
