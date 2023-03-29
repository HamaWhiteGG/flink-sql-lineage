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
            byte[] bytes =facade.generateAvatar(username.hashCode());
            assertThat(bytes).isNotNull();
            LOG.info("username: {}, avatar: {}", username, Base64Utils.encodeBytes(bytes));
        }
    }
}
