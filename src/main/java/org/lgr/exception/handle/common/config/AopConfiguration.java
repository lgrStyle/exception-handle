package org.lgr.exception.handle.common.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * aop日志记录
 *
 * @author liguirong
 */
@Component
@Aspect
@Slf4j
public class AopConfiguration {

    private ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * org.lgr.exception.handle.service.*.*(..))")
    public void pointcut() {

    }

    public void before(JoinPoint joinPoint) {
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatchThreadLocal.set(stopWatch);
            stopWatch.start();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void after(JoinPoint joinPoint) {
        try {
            String message = getLogMessage(joinPoint);
            StopWatch stopWatch = stopWatchThreadLocal.get();
            if (stopWatch != null) {
                stopWatch.stop();
                message = message + " - " + stopWatch.getLastTaskTimeMillis() + "ms";
            }
            log.info(message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public void afterReturning(JoinPoint joinPoint) {

    }

    //    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String message = getLogMessage(joinPoint);
        log.error(message, e);
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Date date = new Date();
        long start = date.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = "[" + sdf.format(date) + "] ";
        try {
            Object result = joinPoint.proceed();
            String message = startTime + getLogMessage(joinPoint) + " - " + (System.currentTimeMillis() - start) + "ms";
            log.info(message);
            return result;
        } catch (Exception e) {
            String message = startTime + getLogMessage(joinPoint) + " - " + (System.currentTimeMillis() - start) + "ms";
            log.error(message, e);
            throw e;
        }
    }

    private String getLogMessage(JoinPoint joinPoint) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(joinPoint.getTarget().getClass().getName());
            sb.append(".");
            sb.append(joinPoint.getSignature().getName());
            sb.append(" - ");
            sb.append("args=" + JSON.toJSONString(joinPoint.getArgs()));
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            if (requestAttributes != null) {
                HttpServletRequest request = requestAttributes.getRequest();
                String requestURI = request.getRequestURI();
                sb.append(" - ");
                sb.append("requestURI=" + requestURI);
                String remoteAddr = request.getRemoteAddr();
                sb.append(" - ");
                sb.append("ip=" + remoteAddr);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return sb.toString();
    }
}
