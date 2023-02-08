package com.lineage.server.domain.repository.basic;

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
    default void attach(T entity) {
        // TODO
    }


    /**
     * Detach an Aggregate
     */
    default void detach(T entity) {
        // TODO
    }

    T find(I id);

    T save(T entity);

    void remove(I id);

}
