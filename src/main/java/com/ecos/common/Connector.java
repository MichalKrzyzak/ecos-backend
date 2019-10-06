package com.ecos.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface Connector {

    default EntityManager connect(EntityManagerFactory entityManagerFactory) {
        entityManagerFactory = Persistence.createEntityManagerFactory("myDatabaseFirstProgram");
        return entityManagerFactory.createEntityManager();
    }
}
