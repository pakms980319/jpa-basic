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
            member.setUsername("관리자1");
            member.setType(MemberType.USER);
            member.setAge(10);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setType(MemberType.USER);
            member2.setAge(10);

            Team team = new Team();
            team.setName("teamA");
            team.getMembers().add(member);
            team.getMembers().add(member2);
            em.persist(team);

            member.setTeam(team);
            member2.setTeam(team);
            em.persist(member);
            em.persist(member2);

            em.flush();
            em.clear();

            String query = "select group_concat(m.username) from Member m";
            List<String> resultList = em.createQuery(query, String.class)
                                        .getResultList();

            for (String s : resultList) {
                System.out.println("s = " + s);
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
