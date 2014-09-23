/*
 * Copyright (c) 2002-2006 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.xwork2.validator.validators;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.conversion.impl.XWorkConverter;
import com.opensymphony.xwork2.validator.ValidationException;

import java.util.Map;


/**
 * <!-- START SNIPPET: javadoc -->
 * Field Validator that checks if a conversion error occured for this field.
 * <!-- END SNIPPET: javadoc -->
 * <p/>
 * <!-- START SNIPPET: parameters -->
 * <ul>
 *     <li>fieldName - The field name this validator is validating. Required if using Plain-Validator Syntax otherwise not required</li>
 * </ul>
 * <!-- END SNIPPET: parameters -->
 *
 * <!-- START SNIPPET: example -->
 * <pre>
 *     &lt;!-- Plain Validator Syntax --&gt;
 *     &lt;validator type="conversion"&gt;
 *     		&lt;param name="fieldName"&gt;myField&lt;/param&gt;
 *          &lt;message&gt;Conversion Error Occurred&lt;/message&gt;
 *     &lt;/validator&gt;
 *      
 *     &lt;!-- Field Validator Syntax --&gt;
 *     &lt;field name="myField"&gt;
 *        &lt;field-validator type="conversion"&gt;
 *           &lt;message&gt;Conversion Error Occurred&lt;/message&gt;
 *        &lt;/field-validator&gt;
 *     &lt;/field&gt;
 * </pre>
 * <!-- END SNIPPET: example -->
 *
 * @author Jason Carreira
 * @author tm_jee
 * 
 * @version $Date $Id: ConversionErrorFieldValidator.java 1833 2008-06-21 09:29:39Z rainerh $
 */
public class ConversionErrorFieldValidator extends RepopulateConversionErrorFieldValidatorSupport {

    /**
     * The validation implementation must guarantee that setValidatorContext will
     * be called with a non-null ValidatorContext before validate is called.
     *
     * @param object
     * @throws ValidationException
     */
    @Override
    public void doValidate(Object object) throws ValidationException {
        String fieldName = getFieldName();
        String fullFieldName = getValidatorContext().getFullFieldName(fieldName);
        ActionContext context = ActionContext.getContext();
        Map<String, Object> conversionErrors = context.getConversionErrors();
        
        if (conversionErrors.containsKey(fullFieldName)) {
            if ((defaultMessage == null) || ("".equals(defaultMessage.trim()))) {
                defaultMessage = XWorkConverter.getConversionErrorMessage(fullFieldName, context.getValueStack());
            }
            
            addFieldError(fieldName, object);
        }
    }
    
}
