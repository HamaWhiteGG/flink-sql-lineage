package com.hw.lineage.server.domain.repository;

import com.hw.lineage.server.AbstractSpringBootTest;
import com.hw.lineage.server.domain.entity.Catalog;
import com.hw.lineage.server.domain.query.catalog.CatalogEntry;
import com.hw.lineage.server.domain.vo.CatalogId;
import com.hw.lineage.server.domain.vo.PluginId;
import org.junit.Test;

import javax.annotation.Resource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @description: CatalogRepositoryTest
 * @author: HamaWhite
 */
public class CatalogRepositoryTest extends AbstractSpringBootTest {

    @Resource
    private CatalogRepository catalogRepository;

    @Test
    public void testFindEntry() {
        CatalogId catalogId = new CatalogId(1L);
        CatalogEntry entry = catalogRepository.findEntry(catalogId);

        assertThat(entry).isNotNull();
        assertThat(entry.getPluginId()).isEqualTo(1L);
        assertThat(entry.getPluginCode()).isEqualTo("flink1.16.x");
        assertThat(entry.getCatalogId()).isEqualTo(1L);
        assertThat(entry.getCatalogName()).isEqualTo("Flink1_16_Memory");
    }

    @Test
    public void testFind() {
        PluginId pluginId = new PluginId(1L);
        String catalogName = "Flink1_16_Memory";
        Catalog catalog = catalogRepository.find(pluginId, catalogName);

        assertThat(catalog).isNotNull();
        assertThat(catalog.getCatalogId()).isEqualTo(new CatalogId(1L));
    }
}
