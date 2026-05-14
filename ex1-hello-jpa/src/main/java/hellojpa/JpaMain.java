package hellojpa;

import jakarta.persistence.*;
import org.hibernate.Hibernate;

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

//            Team teamB = new Team();
//            teamB.setName("teamB");
//            em.persist(teamB);

//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setTeam(teamB);
//            em.persist(member2);

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.persist(child1);
            em.persist(child2);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);
//            System.out.println("refMember = " + m.getClass()); // Proxy
//            System.out.println("m = " + m.getTeam().getClass());

//            System.out.println("============");
//            System.out.println("teamName = " + m.getTeam().getName()); // 초기화
//            System.out.println("============");

//            em.remove(findParent);
//            em.detach(refMember);
//            em.close();
//            em.clear();

//            refMember.getUsername(); // 강제 초기화
//            Hibernate.initialize(m); // 강제 초기화
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

//            printMember(member);
//            printMemberAndTeam(member);

//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();

            // SQL: select * from Member
            // SQL: select * from Team where TEAM_ID = xxx

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }

    private static void printMember(Member member) {
        System.out.println("member = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team.getName());
    }
}
