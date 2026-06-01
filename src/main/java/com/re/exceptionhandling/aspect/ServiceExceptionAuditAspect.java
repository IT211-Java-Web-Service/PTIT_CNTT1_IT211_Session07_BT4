package com.re.exceptionhandling.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceExceptionAuditAspect {

    private static final Logger AUDIT_LOGGER = LoggerFactory.getLogger("AUDIT_LOG");

    @AfterThrowing(
            pointcut = "within(com.re.exceptionhandling.service..*)",
            throwing = "exception"
    )
    public void logServiceException(JoinPoint joinPoint, Throwable exception) {
        AUDIT_LOGGER.error(
                "Service method failed: {}.{}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                exception
        );
    }
}
