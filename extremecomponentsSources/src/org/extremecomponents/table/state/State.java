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
package org.extremecomponents.table.state;

import java.util.Map;

import org.extremecomponents.table.context.Context;

/**
 * 状态接口
 * @author Jeff Johnston
 */
public interface State {
	/**
	 * 保存参数
	 * @param context
	 * @param tableId
	 * @param parameterMap
	 */
    public void saveParameters(Context context, String tableId, Map parameterMap);
    /**
     * 获取参数
     * @param context
     * @param tableId
     * @param stateAttr
     * @return
     */
    public Map getParameters(Context context, String tableId, String stateAttr);
}
