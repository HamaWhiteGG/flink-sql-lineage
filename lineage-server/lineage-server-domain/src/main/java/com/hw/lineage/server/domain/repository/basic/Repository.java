/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hw.lineage.server.domain.repository.basic;

/**
 * @description: Basic Repository interface
 * @author: HamaWhite
 */
public interface Repository<T extends Entity, ID extends Identifier> {

    /**
     * Attach an aggregate to a repository to make it traceable
     */
    default void attach(T entity) {
    }

    /**
     * Detach an aggregate
     */
    default void detach(T entity) {
    }

    T find(ID id);

    T save(T entity);

    void remove(ID id);

    default boolean check(String name) {
        return false;
    }
}
