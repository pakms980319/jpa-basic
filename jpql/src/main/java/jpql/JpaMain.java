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
            member.setUsername("teamA");
            member.setType(MemberType.USER);
            member.setAge(10);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);
            em.persist(team);

            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            String query = "select m.username, 'HELLO', true from Member m " +
                            "where m.age between 0 and 10";
            List<Object[]> result = em.createQuery(query, Object[].class)
                                    .getResultList();



            for (Object[] objects : result) {
                System.out.println("objects[0] = " + objects[0]);
                System.out.println("objects[1] = " + objects[1]);
                System.out.println("objects[2] = " + objects[2]);
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
}
