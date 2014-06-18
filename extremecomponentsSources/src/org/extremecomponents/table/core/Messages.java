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

import java.util.Locale;

import org.extremecomponents.table.context.Context;

/**
 * 消息接口
 * @author Jeff Johnston
 */
public interface Messages {
	/**
	 * 初始化
	 * @param context
	 * @param locale
	 */
    public void init(Context context, Locale locale);
    /**
     * 根据key获取消息value
     * @param code
     * @return
     */
    public String getMessage(String code);
    public String getMessage(String code, Object[] args);
}
