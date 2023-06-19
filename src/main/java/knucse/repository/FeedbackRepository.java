package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Feedback;
import java.util.Optional;
import java.util.List;
public class FeedbackRepository implements FeedbackInterfaceRepository{
    private final EntityManager em;

    public FeedbackRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Feedback save(Feedback feedback){
        em.persist(feedback);
        return feedback;
    }

    @Override
    public Optional<Feedback> findByFid(int fid){
        Feedback feedback = em.find(Feedback.class, fid);
        return Optional.ofNullable(feedback);
    }

    @Override
    public List<Feedback> findAll(){
        List<Feedback> result = em.createQuery("select f from feedback f", Feedback.class)
                .getResultList();
        return result;
    }
}
