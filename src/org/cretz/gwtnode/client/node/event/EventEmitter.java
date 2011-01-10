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
package org.cretz.gwtnode.client.node.event;

import org.cretz.gwtnode.client.JavaScriptFunction;
import org.cretz.gwtnode.client.JavaScriptFunctionWrapper;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class EventEmitter extends JavaScriptObject {

    private static EventEmitter instance;
    
    private static final native EventEmitter getNative() /*-{
        return require('events').EventEmitter;
    }-*/;
    
    public static EventEmitter get() {
        if (instance == null) {
            instance = getNative();
        }
        return instance;
    }
    
    protected EventEmitter() {
    }
    
    public final void on(String event, JavaScriptFunctionWrapper wrapper) {
        on(event, wrapper.getNativeFunction());
    }
    
    public final native void on(String event, JavaScriptFunction func) /*-{
        this.on(event, func);
    }-*/;
    
    public final void removeListener(String event, JavaScriptFunctionWrapper listener) {
        removeListener(event, listener.getNativeFunction());
    }
    
    public final native void removeListener(String event, JavaScriptFunction func) /*-{
        this.removeListener(event, func);
    }-*/;
    
    public final native void removeAllListeners(String event) /*-{
        this.removeAllListeners(event);
    }-*/;
    
    public final native JsArray<JavaScriptFunction> listeners(String event) /*-{
        return this.listeners(event);
    }-*/;
    
    public final void emit(String event, Object... arguments) {
        Object[] args = new Object[arguments.length + 1];
        args[0] = event;
        System.arraycopy(arguments, 0, args, 1, arguments.length);
        emitNative(args);
    }
    
    private final native void emitNative(Object... arguments) /*-{
        this.emit.apply(this, arguments);
    }-*/;
}
