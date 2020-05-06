package com.winsion.net.bootstrap.core.jpa;

import javax.persistence.EntityManager;

/**
 * Created by zhoucong on 16/2/25
 */
public class EntityManagerHolder {
    private static EntityManager entityManagerHolder = null;

    public static EntityManager getEntityManager() {
        return entityManagerHolder;
    }

    public static void setEntityManager(EntityManager entityManager) {
        if (entityManagerHolder == null || entityManagerHolder != entityManager) {
            entityManagerHolder = entityManager;
        }
    }
}
