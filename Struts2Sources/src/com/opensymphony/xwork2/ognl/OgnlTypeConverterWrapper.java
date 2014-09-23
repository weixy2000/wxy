/*
 * Copyright (c) 2002-2007 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.xwork2.ognl;

import com.opensymphony.xwork2.conversion.TypeConverter;

import java.lang.reflect.Member;
import java.util.Map;

/**
 * Wraps an XWork type conversion class for as an OGNL TypeConverter
 */
public class OgnlTypeConverterWrapper implements ognl.TypeConverter {

    private TypeConverter typeConverter;
    
    public OgnlTypeConverterWrapper(TypeConverter conv) {
        if (conv == null) {
            throw new IllegalArgumentException("Wrapped type converter cannot be null");
        }
        this.typeConverter = conv;
    }
    
    public Object convertValue(Map context, Object target, Member member,
            String propertyName, Object value, Class toType) {
        return typeConverter.convertValue(context, target, member, propertyName, value, toType);
    }
    
    public TypeConverter getTarget() {
        return typeConverter;
    }
}
