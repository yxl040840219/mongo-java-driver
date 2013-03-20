/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.mongodb.io;

import org.bson.io.OutputBuffer;
import org.mongodb.io.async.AsyncCompletionHandler;
import org.mongodb.io.async.AsyncWritableByteChannel;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public abstract class ChannelAwareOutputBuffer extends OutputBuffer {

    /**
     * Pipe the contents of the buffer into the given socket channel
     *
     * @param socketChannel channel
     */
    public abstract void pipeAndClose(SocketChannel socketChannel) throws IOException;

    /**
     * Pipe the contents of the buffer into the given socket
     * @param out
     * @throws IOException
     */
    public abstract void pipeAndClose(final Socket out) throws IOException;

    /**
     * Pipe the contents of the buffer into the given asynchronous channel.
     *
     * @param channel the channel
     * @param handler the handler to invoke on complete or failure
     */
    public abstract void pipeAndClose(final AsyncWritableByteChannel channel, AsyncCompletionHandler handler);

}
