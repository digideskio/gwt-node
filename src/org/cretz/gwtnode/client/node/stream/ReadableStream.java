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
package org.cretz.gwtnode.client.node.stream;

import org.cretz.gwtnode.client.node.event.FileDescriptorEventHandler;
import org.cretz.gwtnode.client.node.event.ParameterlessEventHandler;
import org.cretz.gwtnode.client.node.event.StringOrBufferEventHandler;

public class ReadableStream extends Stream {
    
    protected ReadableStream() {
    }
    
    public final void onData(StringOrBufferEventHandler handler) {
        on("data", handler);
    }
    
    public final void onEnd(ParameterlessEventHandler handler) {
        on("end", handler);
    }
    
    public final void onFileDescriptor(FileDescriptorEventHandler handler) {
        on("fd", handler);
    }
    
    public final native boolean readable() /*-{
        return this.readable;
    }-*/;
    
    public final native void setEncoding(String encoding) /*-{
        this.setEncoding(encoding);
    }-*/;
    
    public final native void pause() /*-{
        this.pause();
    }-*/;
    
    public final native void resume() /*-{
        this.resume();
    }-*/;
}
