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

package com.hw.lineage.server.infrastructure.facade.impl;

import com.hw.lineage.common.util.Base64Utils;
import com.hw.lineage.server.domain.facade.AvatarFacade;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description: AvatarFacadeImplTest
 * @author: HamaWhite
 */
public class AvatarFacadeImplTest {

    private static final Logger LOG = LoggerFactory.getLogger(AvatarFacadeImplTest.class);

    @Test
    public void testGenerateAvatar() {
        AvatarFacade facade = new AvatarFacadeImpl();

        String[] usernames = {"demo", "admin", "HamaWhite", "Asteria", "Cattleya"};
        for (String username : usernames) {
            byte[] bytes = facade.generateAvatar(username.hashCode());
            assertThat(bytes).isNotNull();
            LOG.info("username: {}, avatar: {}", username, Base64Utils.encodeBytes(bytes));
        }
    }
}
