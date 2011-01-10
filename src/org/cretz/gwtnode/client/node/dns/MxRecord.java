/*
 * Copyright 2011 Chad Retz
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.cretz.gwtnode.client.node.dns;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js MX record
 * 
 * @author Chad Retz
 */
public class MxRecord extends JavaScriptObject {

    protected MxRecord() {
    }
    
    public final native int getPriority() /*-{
        return this.priority;
    }-*/;
    
    public final native String getExchange() /*-{
        return this.exchange;
    }-*/;
}
