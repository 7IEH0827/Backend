package hellojpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // Criteria 사용 준비
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);

//            Root<Member> m = query.from(Member.class);

//            CriteriaQuery<Member> cq = query.select(m).where(cb.equal(m.get("username"), "kim"));

//            String qlString = "select m From Member as m ";

//            String username = "dsafas";
//            if (username != null) {
////                String where = "where m.username like '%kim%";
////                qlString + where;
//                cq = cq.where(cb.equal(m.get("username"), "kim"));
//            }

//            List<Member> result = em.createQuery(
//                    "select m From Member m where m.username like '%kim%'",
//                    Member.class
//            ).getResultList();

//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

//            List<Member> resultList = em.createQuery(cq).getResultList();

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            // flush -> commit, query

            List<Member> resultList = em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER", Member.class).getResultList();

            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

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
