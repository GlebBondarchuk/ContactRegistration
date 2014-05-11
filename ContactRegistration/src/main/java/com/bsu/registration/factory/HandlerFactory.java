package com.bsu.registration.factory;

import com.bsu.registration.handler.Action;
import com.bsu.registration.handler.Handler;
import com.bsu.registration.handler.RequestHandler;
import com.bsu.registration.view.PageModel;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author gbondarchuk
 */
public class HandlerFactory {
    public static RequestHandler getInstance(PageModel pageModel) {
        Action action = pageModel.getAction();
        Reflections reflections = new Reflections("com.bsu.registration.handler");
        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(Handler.class);
        for (Class clazz : annotatedClasses) {
            Handler handler = (Handler) clazz.getAnnotations()[0];
            if (handler != null && action.equals(handler.value())) {
                try {
                    return RequestHandler.class.cast(clazz.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new IllegalArgumentException("Action is not recognized.");
    }
}