package com.hw.lineage.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: Property
 * @author: HamaWhite
 */
@Data
public class Property implements Serializable {

    private String name;

    private String value;

    private String description;

    private boolean custom = false;
}
