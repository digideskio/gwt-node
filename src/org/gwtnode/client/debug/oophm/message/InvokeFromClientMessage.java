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
package org.gwtnode.client.debug.oophm.message;

import org.gwtnode.client.debug.oophm.OophmBufferBuilder;
import org.gwtnode.client.debug.oophm.OophmStream;
import org.gwtnode.client.node.buffer.Buffer;

/**
 * @author Chad Retz
 */
public class InvokeFromClientMessage extends InvokeMessage {

    private final int methodDispatchId;
    
    public InvokeFromClientMessage(int methodDispatchId, Value<?> thisValue,
            Value<?>... argValues) {
        super(thisValue, argValues);
        this.methodDispatchId = methodDispatchId;
        length += 4;
    }
    
    public InvokeFromClientMessage(OophmStream stream) {
        super();
        length = 0;
        methodDispatchId = stream.readInt();
        length += 4;
        initThisAndArgs(stream);
    }
    
    public int getMethodDispatchId() {
        return methodDispatchId;
    }
    
    @Override
    public String toString() {
        return toString(new StringBuilder()).
                append(", methodDispatchId: ").
                append(methodDispatchId).toString();
    }
    
    @Override
    public Buffer toBuffer() {
        return toBuffer(new OophmBufferBuilder().
                append(type).
                append(methodDispatchId)).toBuffer();
    }
}