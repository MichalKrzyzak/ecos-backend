package com.ecos.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public interface Disconnector {
    default void disconnect(EntityManagerFactory entityManagerFactory, EntityManager entityManager) {
        entityManager.close();
        entityManagerFactory.close();
    }
}
