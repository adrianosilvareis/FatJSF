
package br.teste;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class teste {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("JPAPU").createEntityManager();
        em.getTransaction().begin();
        em.getTransaction().commit();
    }
}
