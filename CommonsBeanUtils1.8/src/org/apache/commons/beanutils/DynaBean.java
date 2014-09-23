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
 * <p>一个<strong>DynaBean</strong>是一个Java对象，
 * 支持属性的名称和数据类型，以及属性值，可以动态修改。
 * 可行的最大程度，BeanUtils包的其他组件将能都识别
 * 这样的bean就像对待标准JavaBean一样检索和设置
 * 属性值的目的。</p>
 *
 * @author Craig McClanahan
 * @author Paulo Gaspar
 * @version $Revision: 555824 $ $Date: 2007-07-13 01:27:15 +0100 (Fri, 13 Jul 2007) $
 */

public interface DynaBean {


    /**
     * 指定映射属性（Map等）是否包含指定键的值
     * 
     *
     * @param name 要检测的属性名称
     * @param key 要检测属性名称对应的key
     * @return <code>true<code> 如果指定属性包含指定key的值，
     * 否则返回 <code>false</code>
     *
     * @exception IllegalArgumentException 如果不存在该属性
     *  
     */
    public boolean contains(String name, String key);


    /**
     * 返回指定名称的一个简单的属性的值
     *
     * @param name 要检索值的属性名称
     * @return 属性值
     *
     * @exception IllegalArgumentException 如果不存在该属性
     *  
     */
    public Object get(String name);


    /**
     * 返回一个索引属性（数组等）指定索引的值
     *
     * @param name 要检索值的属性名称
     * @param index 要检索值的下标
     * @return 指定下标属性对应的值
     *
     * @exception IllegalArgumentException 如果没有该属性
     *  
     * @exception IllegalArgumentException 如果指定的属性存在但不是索引类型
     *  
     * @exception IndexOutOfBoundsException 如果指定的下标超出了索引范围
     * 
     * @exception NullPointerException 如果array或List没有被初始化
     *  
     */
    public Object get(String name, int index);


    /**
     * 返回映射属性指定key对应的值,
     * 如果对应的没有值则返回 <code>null</code>
     *
     * @param name 要检索值的属性名称
     * @param key 要检索值属性名称对应的key
     * @return 映射属性的值
     *
     * @exception IllegalArgumentException 如果没有该属性
     *  
     * @exception IllegalArgumentException 如果指定的属性存在但不是映射类型
     * 
     */
    public Object get(String name, String key);


    /**
     * 返回<code>DynaClass</code>的实例，该实例用于描述DynaBean可用属性的集合
     *
     *
     * @return 相关联的DynaClass
     */
    public DynaClass getDynaClass();


    /**
     * 移除映射属性指定key对应的值
     * 
     *
     * @param name 要移除的属性名称
     * 
     * @param key 将要被移除的key
     *
     * @exception IllegalArgumentException 如果没有该属性
     * 
     */
    public void remove(String name, String key);


    /**
     * 根据指定的属性名称设置简单属性的值
     *
     * @param name 要设置值的属性名称
     * @param value 将被设置的值
     *
     * @exception ConversionException 如果指定的值无法转换成该属性的类型
     * 
     * @exception IllegalArgumentException 如果没有该属性
     * 
     * @exception NullPointerException 如果企图将一个基本类型设置成null值
     * 
     */
    public void set(String name, Object value);


    /**
     * 设置一个索引属性（数组等）指定索引的值
     *
     * @param name 要设置值的属性名称
     * @param index 要设置值的属性索引
     * @param value 将被设置的值
     *
     * @exception ConversionException 如果指定的值无法转换成该属性的类型
     * 
     * @exception IllegalArgumentException 如果没有该属性
     * 
     * @exception IllegalArgumentException 如果指定的属性存在但不是索引类型
     * 
     * @exception IndexOutOfBoundsException 如果指定的下标超出了索引范围
     * 
     */
    public void set(String name, int index, Object value);


    /**
     * 设置一个映射属性（Map等）指定key的值
     *
     * @param name 要设置值的属性名称
     * @param key 要设置值的属性key
     * @param value 将被设置的值
     *
     * @exception ConversionException 如果指定的值无法转换成该属性的类型
     * 
     * @exception IllegalArgumentException 如果没有该属性
     * 
     * @exception IllegalArgumentException 如果指定的属性存在但不是映射类型
     * 
     */
    public void set(String name, String key, Object value);


}
