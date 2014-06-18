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

/**
 * 所有的表格单元格需要实现该接口
 * 
 * @author Jeff Johnston
 */
public interface Cell {

    /**
     * 将被用于导出
     */
    public String getExportDisplay(TableModel model, Column column);

    /**
     * html内容将被用于显示于表格中
     */
    public String getHtmlDisplay(TableModel model, Column column);
}
