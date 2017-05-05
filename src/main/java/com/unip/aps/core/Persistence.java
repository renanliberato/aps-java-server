package com.unip.aps.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created on 9/4/2017.
 *
 * @author Renan Liberato Sant'Ana <renan.libsantana@gmail.com>
 */
public class Persistence {

    private static EntityManager entityManager;

    public static EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        }
        EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("messagedb");
        entityManager = entityManagerFactory.createEntityManager();

        return entityManager;
    }
}
