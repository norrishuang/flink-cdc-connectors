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

package org.apache.flink.cdc.runtime.serializer.event;

import org.apache.flink.api.common.typeutils.TypeSerializer;
import org.apache.flink.cdc.common.event.DropTableEvent;
import org.apache.flink.cdc.common.event.TableId;
import org.apache.flink.cdc.runtime.serializer.SerializerTestBase;

/** A test for the {@link RenameTableEventSerializer}. */
class DropTableEventSerializerTest extends SerializerTestBase<DropTableEvent> {
    @Override
    protected TypeSerializer<DropTableEvent> createSerializer() {
        return DropTableEventSerializer.INSTANCE;
    }

    @Override
    protected int getLength() {
        return -1;
    }

    @Override
    protected Class<DropTableEvent> getTypeClass() {
        return DropTableEvent.class;
    }

    @Override
    protected DropTableEvent[] getTestData() {
        return new DropTableEvent[] {
            new DropTableEvent(TableId.tableId("table")),
            new DropTableEvent(TableId.tableId("schema", "table")),
            new DropTableEvent(TableId.tableId("namespace", "schema", "table"))
        };
    }
}
