package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setUsername("TeamA");
            member.setAge(10);

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            member.setTeam(team);
            em.persist(member);


            em.flush();
            em.clear();

            String query = "select m from Member m join Team t on m.username = t.name";
            List<Member> result = em.createQuery(query, Member.class)
                                    .getResultList();

            System.out.println("result.size() = " + result.size());

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        emf.close();
    }
}
