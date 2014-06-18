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
import org.extremecomponents.table.core.TableConstants;

/**
 * �־�״̬
 * @author Jeff Johnston
 */
public class PersistState extends AbstractState {
    public Map getParameters(Context context, String tableId, String stateAttr) {
        return (Map) context.getSessionAttribute(TableConstants.STATE + tableId);
    }
}
