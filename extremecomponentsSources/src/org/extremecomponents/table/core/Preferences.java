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
package org.extremecomponents.table.core;

import org.extremecomponents.table.context.Context;

/**
 * 首选项
 * @author Jeff Johnston
 */
public interface Preferences {
	/**
	 * 初始化
	 * @param context 上下文
	 * @param preferencesLocation 首选项资源文件位置
	 */
    public void init(Context context, String preferencesLocation);
    /**
     * 获取首选项
     * @param code
     * @return
     */
    public String getPreference(String code);
}
