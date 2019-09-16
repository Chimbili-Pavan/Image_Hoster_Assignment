package ImageHoster.repository;


import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CommentRepository {

    private EntityManagerFactory emf;


    public void uploadComments(Comment newcomment){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(newcomment);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
        }
    }

    public Comment getComments(Integer id){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.user.id = :imageId",Comment.class).setParameter("id",id);
            return query.getSingleResult();
        }
        catch (Exception e){
            return null;
        }


    }
}
