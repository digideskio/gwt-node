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
package org.gwtnode.core.node.crypto;

import org.gwtnode.core.meta.GwtNodeFunction;
import org.gwtnode.core.meta.GwtNodeObject;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * The node.js signer object
 * 
 * @author Chad Retz
 */
@GwtNodeObject("Sign")
public class Signer extends JavaScriptObject {

    protected Signer() {
    }

    @GwtNodeFunction
    public final native void update(String data) /*-{
        this.update(data);
    }-*/;

    @GwtNodeFunction
    public final native String sign(String privateKey) /*-{
        return this.sign(privateKey);
    }-*/;

    @GwtNodeFunction
    public final native String sign(String privateKey, String outputFormat) /*-{
        return this.sign(privateKey, outputFormat);
    }-*/;
}
