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
 * ��ҳ�ӿ�
 * @author Jeff Johnston
 */
public interface Limit {
	/**
	 * ��ȡ���˼���
	 * @return
	 */
    public FilterSet getFilterSet();

    /**
     * �����к�
     * @return
     */
    public int getRowEnd();

    /**
     * ��ʼ�к�
     * @return
     */
    public int getRowStart();

    /**
     * ����
     * @return
     */
    public Sort getSort();

    /**
     * ҳ��
     * @return
     */
    public int getPage();

    /**
     * ҳ��
     * @return
     */
    public int getCurrentRowsDisplayed();

    /**
     * �ܼ�¼��
     * @return
     */
    public int getTotalRows();

    /**
     * �Ƿ����
     * @return
     */
    public boolean isFiltered();

    /**
     * �Ƿ����
     * @return
     */
    public boolean isCleared();

    /**
     * �Ƿ�����
     * @return
     */
    public boolean isSorted();

    /**
     * �Ƿ��ǵ���
     * @return
     */
    public boolean isExported();

    /**
     * ����������
     * @param totalRows �ܼ�¼��
     * @param defaultRowsDisplayed ҳ��
     */
    public void setRowAttributes(int totalRows, int defaultRowsDisplayed);
}
