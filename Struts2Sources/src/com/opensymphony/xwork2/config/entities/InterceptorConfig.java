/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.xwork2.config.entities;

import com.opensymphony.xwork2.util.location.Located;
import com.opensymphony.xwork2.util.location.Location;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配置Interceptors
 * <p/>
 * 在struts的XML配置文件中使用&lt;interceptors&gt;标签定义
 *
 * @author Mike
 */
public class InterceptorConfig extends Located implements Serializable {

    Map<String,String> params;
    String className;
    String name;


    protected InterceptorConfig(String name, String className) {
        this.params = new LinkedHashMap<String,String>();
        this.name = name;
        this.className = className;
    }

    protected InterceptorConfig(InterceptorConfig orig) {
        this.name = orig.name;
        this.className = orig.className;
        this.params = new LinkedHashMap<String,String>(orig.params);
    }


    public String getClassName() {
        return className;
    }

    public String getName() {
        return name;
    }

    public Map<String,String> getParams() {
        return params;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof InterceptorConfig)) {
            return false;
        }

        final InterceptorConfig interceptorConfig = (InterceptorConfig) o;

        if ((className != null) ? (!className.equals(interceptorConfig.className)) : (interceptorConfig.className != null))
        {
            return false;
        }

        if ((name != null) ? (!name.equals(interceptorConfig.name)) : (interceptorConfig.name != null)) {
            return false;
        }

        if ((params != null) ? (!params.equals(interceptorConfig.params)) : (interceptorConfig.params != null)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        result = ((name != null) ? name.hashCode() : 0);
        result = (29 * result) + ((className != null) ? className.hashCode() : 0);
        result = (29 * result) + ((params != null) ? params.hashCode() : 0);

        return result;
    }

    /**
     * The builder for this object.  An instance of this object is the only way to construct a new instance.  The
     * purpose is to enforce the immutability of the object.  The methods are structured in a way to support chaining.
     * After setting any values you need, call the {@link #build()} method to create the object.
     */
    public static final class Builder {
        private InterceptorConfig target;

        public Builder(String name, String className) {
            target = new InterceptorConfig(name, className);
        }

        public Builder(InterceptorConfig orig) {
            target = new InterceptorConfig(orig);
        }

        public Builder name(String name) {
            target.name = name;
            return this;
        }

        public Builder className(String name) {
            target.className = name;
            return this;
        }

        public Builder addParam(String name, String value) {
            target.params.put(name, value);
            return this;
        }

        public Builder addParams(Map<String,String> params) {
            target.params.putAll(params);
            return this;
        }

        public Builder location(Location loc) {
            target.location = loc;
            return this;
        }

        public InterceptorConfig build() {
            target.params = Collections.unmodifiableMap(target.params);
            InterceptorConfig result = target;
            target = new InterceptorConfig(target);
            return result;
        }
    }
}
