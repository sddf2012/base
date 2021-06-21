package my.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author liu peng bo
 * date: 2021/3/24 10:45
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class AopConfig {
    @Pointcut("execution(* my.service.ClubService.getName())")
    public void pointcut() {
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        joinPoint.getSignature();
        System.out.println("around begin");
        Object object = joinPoint.proceed();
        System.out.println("around end");
        return object;
    }
}
