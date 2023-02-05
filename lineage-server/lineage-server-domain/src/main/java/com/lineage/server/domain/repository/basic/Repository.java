package com.lineage.server.domain.repository.basic;

import com.lineage.server.domain.entity.Task;

/**
 * @description: Basic Repository interface
 * @author: HamaWhite
 * @version: 1.0.0
 * @date: 2023/2/4 10:04 PM
 */
public interface Repository<T extends Entity, I extends Identifier> {

    /**
     * Attach an Aggregate to a Repository to make it traceable
     */
    default void attach(T aggregate) {
        // TODO
    }


    /**
     * Detach an Aggregate
     */
    default void detach(T aggregate) {
        // TODO
    }

    T find(I id);

    T save(T aggregate);

    Boolean remove(I id);

    Boolean update(T aggregate);
}
