/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.dispatcher;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.ng.HostConfig;

/**
 * 接口：基于路径加载静态资源
 */
public interface StaticContentLoader {

    /**
     * @param path 请求资源路径
     * @return true 返回当前加载器是否能加载该类型资源
     */
    public boolean canHandle(String path);

    /**
     * @param filterConfig 过滤器配置
     */
    public abstract void setHostConfig(HostConfig filterConfig);

    /**
     * Locate a static resource and copy directly to the response, setting the
     * appropriate caching headers.
     *
     * @param path     The resource name
     * @param request  The request
     * @param response The response
     * @throws IOException If anything goes wrong
     */
    public abstract void findStaticResource(String path, HttpServletRequest request, HttpServletResponse response)
            throws IOException;

}