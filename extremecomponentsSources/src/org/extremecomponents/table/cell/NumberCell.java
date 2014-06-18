/*
 * Copyright 2004 original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.extremecomponents.table.cell;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.util.ExtremeUtils;

/**
 * ���ָ�ʽ�ĵ�Ԫ�� 
 * @author Jeff Johnston
 */
public class NumberCell extends AbstractCell {
    protected String getCellValue(TableModel model, Column column) {
        String value = column.getPropertyValueAsString();
        if (StringUtils.isNotBlank(value)) {
            Locale locale = model.getLocale();
            value = ExtremeUtils.formatNumber(column.getFormat(), value, locale);
        }

        return value;
    }
}