/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.commons.beanutils;





/**
 * <p>A <strong>DynaClass</strong> is a simulation of the functionality of
 * <code>java.lang.Class</code> for classes implementing the
 * <code>DynaBean</code> interface.  DynaBean instances that share the same
 * DynaClass all have the same set of available properties, along with any
 * associated data types, read-only states, and write-only states.</p>
 *
 * @author Craig McClanahan
 * @author Michael Smith
 * @author Paulo Gaspar
 * @version $Revision: 555824 $ $Date: 2007-07-13 01:27:15 +0100 (Fri, 13 Jul 2007) $
 */

public interface DynaClass {


    /**
     * 返回DynaClass的名称 (类似于
     * <code>java.lang.Class</code>的<code>getName()</code>方法), which
     * allows the same <code>DynaClass</code> implementation class to support
     * different dynamic classes, with different sets of properties.
     *
     * @return DynaClass的名称
     */
    public String getName();


    /**
     * 如果存在该属性则返回该属性的描述DynaProperty；
     * 否则，返回<code>null</code>.
     *
     * @param name 获取DynaProperty的属性名称
     * 
     * @return 描述指定属性DynaProperty
     *
     * @exception IllegalArgumentException 如果没有指定属性名称
     */
    public DynaProperty getDynaProperty(String name);


    /**
     * <p>返回所有当前定义在DynaClass中的属性描述对象DynaProperty数组，
     * 如果没有属性被定义则将会返回一个长度为0的数组</p>
     * 
     *
     * <p><strong>FIXME</strong> - Should we really be implementing
     * <code>getBeanInfo()</code> instead, which returns property descriptors
     * and a bunch of other stuff?</p>
     *
     * @return DynaClass属性集合
     */
    public DynaProperty[] getDynaProperties();


    /**
     * 初始化并返回一个DynaBean的实例，该实例与当前DynaClass相关联
     * 
     *
     * @return 一个新的DynaBean实例
     *
     * @exception IllegalAccessException if the Class or the appropriate
     *  constructor is not accessible
     * @exception InstantiationException if this Class represents an abstract
     *  class, an array class, a primitive type, or void; or if instantiation
     *  fails for some other reason
     */
    public DynaBean newInstance()
            throws IllegalAccessException, InstantiationException;


}
