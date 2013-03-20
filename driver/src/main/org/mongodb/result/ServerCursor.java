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
 */

package org.mongodb.result;

import org.mongodb.ServerAddress;

import java.io.Serializable;

public final class ServerCursor implements Serializable {

    private static final long serialVersionUID = 6469149391944297594L;

    private final long id;
    private final ServerAddress address;

    public ServerCursor(final long id, final ServerAddress address) {
        if (id == 0) {
            throw new IllegalArgumentException();
        }
        if (address == null) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public ServerAddress getAddress() {
        return address;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ServerCursor that = (ServerCursor) o;

        if (id != that.id) {
            return false;
        }
        if (address != null ? !address.equals(that.address) : that.address != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ServerCursor{getId=" + id + ", address=" + address + '}';
    }
}
