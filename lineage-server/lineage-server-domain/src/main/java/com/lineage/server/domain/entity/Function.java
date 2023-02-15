package com.lineage.server.domain.entity;

import com.lineage.server.domain.entity.basic.BasicEntity;
import com.lineage.server.domain.repository.basic.Entity;
import com.lineage.server.domain.vo.FunctionId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @description: Function
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
@Accessors(chain = true)
public class Function extends BasicEntity implements Entity {

    private FunctionId functionId;

    private String functionName;

    private String functionFormat;

    private String functionPath;

    private String functionClass;

    private String descr;
}
