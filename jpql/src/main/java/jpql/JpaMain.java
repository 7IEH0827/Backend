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
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//            member.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            em.persist(member2);

            em.flush();
            em.clear();

            String query ="select index(t.members) From Member m";

            List<Integer> result = em.createQuery(query, Integer.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

//            System.out.println("result = " + result.size());
            for (Integer s : result) {
                System.out.println("s = " + s);
            }
            
//            Member findMember = result.get(0);
//            findMember.setAge(20);

//            System.out.println("result = " + result.getUsername());
//            TypedQuery<String> query2 = em.createQuery("select m.username from Member m", String.class);
//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();

//            MemberDTO memberDTO = result.get(0);
//            System.out.println("memberDTO = " + memberDTO.getUsername());
//            System.out.println("memberDTO = " + memberDTO.getAge());

//            List<Member> resultList = query.getResultList();

//            Member result = query.getSingleResult();
            // Spring Data JPA ->
//            System.out.println("result = " + result);

//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
