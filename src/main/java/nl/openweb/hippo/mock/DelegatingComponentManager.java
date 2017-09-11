/*
 * Copyright 2017 Open Web IT B.V. (https://www.openweb.nl/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.openweb.hippo.mock;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

import org.hippoecm.hst.core.container.ComponentManager;
import org.hippoecm.hst.core.container.ComponentsException;
import org.hippoecm.hst.core.container.ContainerConfiguration;

/**
 * @author Ebrahim Aharpour
 * @since 9/10/2017
 */
public class DelegatingComponentManager implements ComponentManager {

    private ThreadLocal<ComponentManager> componentManager = new ThreadLocal<>();

    public void setComponentManager(ComponentManager componentManager) {
        this.componentManager.set(componentManager);
    }

    public void remove() {
        this.componentManager.remove();
    }

    @Override
    public void setConfigurationResources(String[] configurationResources) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.setConfigurationResources(configurationResources);
        }
    }

    @Override
    public String[] getConfigurationResources() {
        String[] result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getConfigurationResources();
        }
        return result;
    }

    @Override
    @Deprecated
    public void setServletConfig(ServletConfig servletConfig) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.setServletConfig(servletConfig);
        }
    }

    @Override
    @Deprecated
    public ServletConfig getServletConfig() {
        ServletConfig result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getServletConfig();
        }
        return result;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.setServletContext(servletContext);
        }
    }

    @Override
    public ServletContext getServletContext() {
        ServletContext result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getServletContext();
        }
        return result;
    }

    @Override
    public void initialize() {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.initialize();
        }
    }

    @Override
    public void start() {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.start();
        }
    }

    @Override
    public <T> T getComponent(String name) {
        T result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponent(name);
        }
        return result;
    }

    @Override
    public <T> T getComponent(Class<T> requiredType) throws ComponentsException {
        T result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponent(requiredType);
        }
        return result;
    }

    @Override
    public <T> Map<String, T> getComponentsOfType(Class<T> requiredType) {
        Map<String, T> result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponentsOfType(requiredType);
        }
        return result;
    }

    @Override
    public <T> T getComponent(String name, String... addonModuleNames) {
        T result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponent(name, addonModuleNames);
        }
        return result;
    }

    @Override
    public <T> T getComponent(Class<T> requiredType, String... addonModuleNames) throws ComponentsException {
        T result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponent(requiredType, addonModuleNames);
        }
        return result;
    }

    @Override
    public <T> Map<String, T> getComponentsOfType(Class<T> requiredType, String... addonModuleNames) {
        Map<String, T> result = new HashMap<>();
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getComponentsOfType(requiredType, addonModuleNames);
        }
        return result;
    }

    @Override
    public void publishEvent(EventObject event) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.publishEvent(event);
        }
    }

    @Override
    public void registerEventSubscriber(Object subscriber) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.registerEventSubscriber(subscriber);
        }
    }

    @Override
    public void unregisterEventSubscriber(Object subscriber) {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.unregisterEventSubscriber(subscriber);
        }
    }

    @Override
    public void stop() {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.stop();
        }
    }

    @Override
    public void close() {
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            cm.close();
        }
    }

    @Override
    public ContainerConfiguration getContainerConfiguration() {
        ContainerConfiguration result = null;
        ComponentManager cm = this.componentManager.get();
        if (cm != null) {
            result = cm.getContainerConfiguration();
        }
        return result;
    }
}
