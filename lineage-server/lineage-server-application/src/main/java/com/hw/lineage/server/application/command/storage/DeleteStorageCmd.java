package com.hw.lineage.server.application.command.storage;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description: DeleteStorageCmd
 * @author: HamaWhite
 * @version: 1.0.0
 */
@Data
public class DeleteStorageCmd implements Serializable {

    @NotBlank
    private String filePath;

}
