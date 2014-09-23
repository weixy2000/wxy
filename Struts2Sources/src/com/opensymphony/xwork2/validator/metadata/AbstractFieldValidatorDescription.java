/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.xwork2.validator.metadata;

import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <code>AbstractFieldValidatorDescription</code>
 *
 * @author Rainer Hermanns
 * @version $Id: AbstractFieldValidatorDescription.java 1630 2007-10-05 15:10:08Z mrdon $
 */
public abstract class AbstractFieldValidatorDescription implements ValidatorDescription {

    /**
     * Jakarta commons-logging reference.
     */
    protected static Logger log = null;

    public String fieldName;
    public String key;
    public String message;
    public boolean shortCircuit;
    public boolean simpleValidator;


    public AbstractFieldValidatorDescription() {
        log = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * Creates an AbstractFieldValidatorDescription with the specified field name.
     *
     * @param fieldName
     */
    public AbstractFieldValidatorDescription(String fieldName) {
        this.fieldName = fieldName;
        log = LoggerFactory.getLogger(this.getClass());
    }

    /**
     * Sets the field name for this validator rule.
     *
     * @return fieldName the field name for this validator rule
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets the field name for this validator rule.
     *
     * @param fieldName the field name for this validator rule
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Sets the I18N message key.
     * @param key the I18N message key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Sets the default validator failure message.
     *
     * @param message the default validator failure message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Set the shortCircuit flag.
     *
     * @param shortCircuit the shortCircuit flag.
     */
    public void setShortCircuit(boolean shortCircuit) {
        this.shortCircuit = shortCircuit;
    }

    public void setSimpleValidator(boolean simpleValidator) {
        this.simpleValidator = simpleValidator;
    }

    public boolean isSimpleValidator() {
        return simpleValidator;
    }

    /**
     * Returns the validator XML definition.
     *
     * @return the validator XML definition.
     */
    public String asXml() {
        if ( simpleValidator) {
            return asSimpleXml();
        }
        return asFieldXml();
    }

    /**
     * Returns the field validator XML definition.
     *
     * @return the field validator XML definition.
     */
    public abstract String asFieldXml();

     /**
      * Returns the validator XML definition.
      *
      * @return the validator XML definition.
      */
     public abstract String asSimpleXml();

}
