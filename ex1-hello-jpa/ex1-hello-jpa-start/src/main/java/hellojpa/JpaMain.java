package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Hibernate;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Member member1 = new Member();
            member1.setUsername("hello");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("hello");
            em.persist(member2);

            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass());

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            System.out.println("refMember = " + refMember.getClass().getName());

            Hibernate.initialize(refMember);  // 강제 초기화
            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    public static void logic(Member m1, Member m2) {
        System.out.println("m1.getClass() == m2.getClass() ? " + (m1.getClass() == m2.getClass()));
    }
}
