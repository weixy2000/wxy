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
package org.extremecomponents.table.limit;

/**
 * 分页接口
 * @author Jeff Johnston
 */
public interface Limit {
	/**
	 * 获取过滤集合
	 * @return
	 */
    public FilterSet getFilterSet();

    /**
     * 结束行号
     * @return
     */
    public int getRowEnd();

    /**
     * 开始行号
     * @return
     */
    public int getRowStart();

    /**
     * 排序
     * @return
     */
    public Sort getSort();

    /**
     * 页码
     * @return
     */
    public int getPage();

    /**
     * 页容
     * @return
     */
    public int getCurrentRowsDisplayed();

    /**
     * 总记录数
     * @return
     */
    public int getTotalRows();

    /**
     * 是否过滤
     * @return
     */
    public boolean isFiltered();

    /**
     * 是否清除
     * @return
     */
    public boolean isCleared();

    /**
     * 是否被排序
     * @return
     */
    public boolean isSorted();

    /**
     * 是否是导出
     * @return
     */
    public boolean isExported();

    /**
     * 设置行属性
     * @param totalRows 总记录数
     * @param defaultRowsDisplayed 页容
     */
    public void setRowAttributes(int totalRows, int defaultRowsDisplayed);
}
