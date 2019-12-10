package boilerplate.spring.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
//@Component
public class HelloMethodAspect {

    @Pointcut("execution(* boilerplate.spring.aop.service.HelloService.*(..))")
    public void helloLayer() {
    }

    @Around("helloLayer()")
    public Object aroundHello(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            log.info("@Around");
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            log.info("@Around");
        }
    }

    @Before("helloLayer()")
    public void beforeHello(JoinPoint joinPoint) {
        log.info("@Before");
        log.info("first argument: {}", joinPoint.getArgs()[0]);
    }

    @After("helloLayer()")
    public void afterHello(JoinPoint joinPoint) {
        log.info("@After");
    }

    @AfterReturning(value = "helloLayer()", returning = "returnObject")
    public void afterHelloReturning(JoinPoint joinPoint, Object returnObject) {
        log.info("@AfterReturning");
        log.info("returning object: {}", returnObject);
    }

    @AfterThrowing(value = "helloLayer()", throwing = "e")
    public void afterHelloThrowing(JoinPoint joinPoint, Exception e) {
        log.info("@AfterThrowing");
        log.info("exception: {}", e.getMessage());
    }
}
