package com.hw.lineage.server;

import com.hw.lineage.server.start.LineageServerApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description: AbstractSpringBootTest
 * @author: HamaWhite
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LineageServerApplication.class)
public abstract class AbstractSpringBootTest {
}
