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
 * ��ҳ�����ӿ�
 * @author Jeff Johnston
 */
public interface LimitFactory {
	/**
	 * ��ȡҳ��
	 * @param totalRows
	 * @param defaultRowsDisplayed
	 * @return
	 */
    public int getCurrentRowsDisplayed(int totalRows, int defaultRowsDisplayed);

    /**
     * ��ȡҳ��
     * @return
     */
    public int getPage();

    /**
     * ��ȡ�������
     * @return
     */
    public Sort getSort();
    
    /**
     * �Ƿ��ǵ���
     * @return
     */
    public boolean isExported();

    /**
     * ��ȡ���˼���
     * @return
     */
    public FilterSet getFilterSet();

    /**
     * ��ȡ������򱻹��˵Ĳ���
     * @param parameter
     * @return
     */
    public Map getSortedOrFilteredParameters(String parameter);
}