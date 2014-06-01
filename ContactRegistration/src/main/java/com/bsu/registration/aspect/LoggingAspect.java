package com.bsu.registration.aspect;

import com.bsu.registration.model.Contact;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author gbondarchuk
 */
@Aspect
public class LoggingAspect {
    private static final Log log = LogFactory.getLog(LoggingAspect.class);

    @Pointcut("execution(* com.bsu.registration.service.ContactServiceImpl.save(..))")
    private void onServiceMethod() {
    }

    @AfterReturning(value = "com.bsu.registration.aspect.LoggingAspect.onServiceMethod()", returning = "data")
    public void log(JoinPoint data) {
        Contact contact = (Contact) data.getArgs()[0];
        log.info("Trying to save with name: " + contact.getFirstName() + " " + contact.getLastName());
    }
}
