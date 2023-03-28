package com.hw.lineage.server.application;

import com.hw.lineage.common.util.Base64Utils;
import com.hw.lineage.server.application.service.impl.UserServiceImpl;
import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @description: AvatarTest
 * @author: HamaWhite
 */
public class AvatarTest {

    private static final Logger LOG = LoggerFactory.getLogger(AvatarTest.class);


    @Test
    public void testGenerateAvatar() throws Exception {
        UserServiceImpl service = new UserServiceImpl();

        String[] usernames = {"demo", "admin", "HamaWhite", "Asteria", "Cattleya"};
        for (String username : usernames) {
            byte[] bytes = Whitebox.invokeMethod(service, "generateAvatar", (long)username.hashCode());
            assertThat(bytes).isNotNull();
            LOG.info("username: {}, avatar: {}", username, Base64Utils.encodeBytes(bytes));
        }
    }
}
