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

import java.util.Map;

/**
 * 分页工厂接口
 * @author Jeff Johnston
 */
public interface LimitFactory {
	/**
	 * 获取页容
	 * @param totalRows
	 * @param defaultRowsDisplayed
	 * @return
	 */
    public int getCurrentRowsDisplayed(int totalRows, int defaultRowsDisplayed);

    /**
     * 获取页号
     * @return
     */
    public int getPage();

    /**
     * 获取排序对象
     * @return
     */
    public Sort getSort();
    
    /**
     * 是否是导出
     * @return
     */
    public boolean isExported();

    /**
     * 获取过滤集合
     * @return
     */
    public FilterSet getFilterSet();

    /**
     * 获取被排序或被过滤的参数
     * @param parameter
     * @return
     */
    public Map getSortedOrFilteredParameters(String parameter);
}