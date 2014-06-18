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

import org.extremecomponents.table.bean.Column;
import org.extremecomponents.table.core.TableModel;
import org.extremecomponents.table.view.html.ColumnBuilder;

/**
 * 单元格抽象基类
 * @author Jeff Johnston
 */
public abstract class AbstractCell implements Cell {
	/**
	 * 获取导出的显示值
	 */
    public String getExportDisplay(TableModel model, Column column) {
        return getCellValue(model, column);
    }

    /**
     * 获取html显示值
     */
    public String getHtmlDisplay(TableModel model, Column column) {
        ColumnBuilder columnBuilder = new ColumnBuilder(column);
        columnBuilder.tdStart();
        columnBuilder.tdBody(getCellValue(model, column));
        columnBuilder.tdEnd();
        return columnBuilder.toString();
    }

    /**
     * 获取显示值的实用方法
     */
    protected abstract String getCellValue(TableModel model, Column column);
}
