package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 비영속
            Member member = new Member();
//            Member member2 = new Member (160L, "B");
//            member.setId(3L);
            member.setUsername("C");
//            member.setRoleType(RoleType.GUEST);

            // 영속
            System.out.println("==============");
            em.persist(member);
//            em.persist(member2);
            System.out.println("member.id = " + member.getId());
            System.out.println("==============");

//            Member member = em.find(Member.class, 150L);
//            Member findMember2 = em.find(Member.class, 101L);
//            member.setName("AAAAA");
//            em.flush();

//            em.detach(member);
//            em.clear();

//            Member member2 = em.find(Member.class, 150L);

//            System.out.println("==================");

//            System.out.println("result = " + (findMember1 == findMember2));

//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

//            em.remove(findMember);
//            findMember.setName("HelloJPA");

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();

//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
