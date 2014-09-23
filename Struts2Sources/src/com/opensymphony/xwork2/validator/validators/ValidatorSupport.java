/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.xwork2.validator.validators;

import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.opensymphony.xwork2.validator.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;


/**
 * Abstract implementation of the Validator interface suitable for subclassing.
 *
 * @author Jason Carreira
 * @author tm_jee
 * @author Martin Gilday
 */
public abstract class ValidatorSupport implements Validator, ShortCircuitableValidator {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());
    protected String defaultMessage = "";
    protected String messageKey;
    private ValidatorContext validatorContext;
    private boolean shortCircuit;
    private boolean parse;
    private String type;
    private String[] messageParameters;
    private ValueStack stack;


    public void setValueStack(ValueStack stack) {
        this.stack = stack;
    }

    public void setDefaultMessage(String message) {
        this.defaultMessage = message;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setParse(boolean parse) {
        this.parse = parse;
    }

    public boolean getParse() {
        return parse;
    }

    public String getMessage(Object object) {
        String message;
        boolean pop = false;

        if (!stack.getRoot().contains(object)) {
            stack.push(object);
            pop = true;
        }

        stack.push(this);

        if (messageKey != null) {
            if ((defaultMessage == null) || ("".equals(defaultMessage.trim()))) {
                defaultMessage = messageKey;
            }
            if (validatorContext == null) {
                validatorContext = new DelegatingValidatorContext(object);
            }
            List<Object> parsedMessageParameters = null;
            if (messageParameters != null) {
                parsedMessageParameters = new ArrayList<Object>();
                for (String messageParameter : messageParameters) {
                    if (messageParameter != null) {
                        try {
                            Object val = stack.findValue(messageParameter);
                            parsedMessageParameters.add(val);
                        } catch (Exception e) {
                            // if there's an exception in parsing, we'll just treat the expression itself as the
                            // parameter
                            log.warn("exception while parsing message parameter [" + messageParameter + "]", e);
                            parsedMessageParameters.add(messageParameter);
                        }
                    }
                }
            }

            message = validatorContext.getText(messageKey, defaultMessage, parsedMessageParameters);

        } else {
            message = defaultMessage;
        }

        if (StringUtils.isNotBlank(message))
            message = TextParseUtil.translateVariables(message, stack);

        stack.pop();

        if (pop) {
            stack.pop();
        }

        return message;
    }

    public void setMessageKey(String key) {
        messageKey = key;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public String[] getMessageParameters() {
        return this.messageParameters;
    }

    public void setMessageParameters(String[] messageParameters) {
        this.messageParameters = messageParameters;
    }

    public void setShortCircuit(boolean shortcircuit) {
        shortCircuit = shortcircuit;
    }

    public boolean isShortCircuit() {
        return shortCircuit;
    }

    public void setValidatorContext(ValidatorContext validatorContext) {
        this.validatorContext = validatorContext;
    }

    public ValidatorContext getValidatorContext() {
        return validatorContext;
    }

    public void setValidatorType(String type) {
        this.type = type;
    }

    public String getValidatorType() {
        return type;
    }

    /**
     * Parse <code>expression</code> passed in against value stack. Only parse
     * when 'parse' param is set to true, else just returns the expression unparsed.
     *
     * @param expression
     * @return Object
     */
    protected Object conditionalParse(String expression) {
        if (parse) {
            return TextParseUtil.translateVariables('$', expression, stack);
        }
        return expression;
    }

    /**
     * Return the field value named <code>name</code> from <code>object</code>,
     * <code>object</code> should have the appropriate getter/setter.
     *
     * @param name
     * @param object
     * @return Object as field value
     * @throws ValidationException
     */
    protected Object getFieldValue(String name, Object object) throws ValidationException {

        boolean pop = false;

        if (!stack.getRoot().contains(object)) {
            stack.push(object);
            pop = true;
        }

        Object retVal = stack.findValue(name);

        if (pop) {
            stack.pop();
        }

        return retVal;
    }

    protected void addActionError(Object object) {
        validatorContext.addActionError(getMessage(object));
    }

    protected void addFieldError(String propertyName, Object object) {
        validatorContext.addFieldError(propertyName, getMessage(object));
    }

}
