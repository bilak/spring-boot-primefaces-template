package com.github.bilak.spring_boot_primefaces_template.configuration;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by lvasek on 29/04/15.
 */
// copied from https://cagataycivici.wordpress.com/2010/02/17/port-jsf-2-0s-viewscope-to-spring-3-0/
public class ViewScope implements Scope {
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context.getViewRoot() != null) {
            Map<String, Object> viewMap = context.getViewRoot().getViewMap();

            if (viewMap.containsKey(name)) {
                return viewMap.get(name);
            } else {
                Object object = objectFactory.getObject();
                viewMap.put(name, object);

                return object;
            }
        }
        return null;
    }

    @Override
    public Object remove(String name) {
        return FacesContext.getCurrentInstance().getViewRoot().getViewMap().remove(name);
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
