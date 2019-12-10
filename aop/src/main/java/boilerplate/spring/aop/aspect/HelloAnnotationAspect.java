package boilerplate.spring.aop.aspect;

import boilerplate.spring.aop.annotation.Notify;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class HelloAnnotationAspect {

    @Pointcut(value = "@annotation(notify)", argNames = "notify")
    public void annotationLayer(Notify notify) {
    }

    @Around(value = "annotationLayer(notify)", argNames = "joinPoint,notify")
    public Object aroundHello(ProceedingJoinPoint joinPoint, Notify notify) throws Throwable {
        try {
            log.info("@Around");
            log.info("annotation value: {}", notify.value());
            return joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            throw e;
        } finally {
            log.info("@Around");
        }
    }

    @Before(value = "annotationLayer(notify)", argNames = "joinPoint,notify")
    public void beforeHello(JoinPoint joinPoint, Notify notify) {
        log.info("@Before");
    }

    @After(value = "annotationLayer(notify)", argNames = "joinPoint,notify")
    public void afterHello(JoinPoint joinPoint, Notify notify) {
        log.info("@After");
    }

    @AfterReturning(value = "annotationLayer(notify)",
            returning = "returnObject",
            argNames = "joinPoint,returnObject,notify")
    public void afterHelloReturning(JoinPoint joinPoint, Object returnObject, Notify notify) {
        log.info("@AfterReturning");
        log.info("returning object: {}", returnObject);
        log.info("annotation value: {}", notify.value());
    }
}
