package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            // flush -> commit, query

            // List<Member> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER", Member.class).getResultList();

            // dbconn.executeQuery("select * from member");
            // jdbc는 jpa와 관련이 없음 -> flush가 자동으로 안됨 (commit 후 flush가 될 것) -> 강제 flush가 필요
            // em.flush();

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }


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
