package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.entity.FeedbackEntity;
import knucse.entity.FeedbackListEntity;

import java.util.Optional;
import java.util.List;
public class FeedbackRepository implements FeedbackInterface {
    private final EntityManager em;

    public FeedbackRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(FeedbackEntity feedback){
        em.persist(feedback);
    }

    @Override
    public Optional<FeedbackEntity> findByFid(int fid){
        FeedbackEntity feedback = em.find(FeedbackEntity.class, fid);
        return Optional.ofNullable(feedback);
    }

    @Override
    public List<FeedbackEntity> findAll(){
        List<FeedbackEntity> result = em.createQuery("select f from feedback f", FeedbackEntity.class)
                .getResultList();
        return result;
    }
    @Override
    public List<FeedbackListEntity> findByNnum(int nnum){
        List<FeedbackListEntity> result = em.createQuery("select f from feedbackList f where f.nnum = nnum",
                FeedbackListEntity.class).getResultList();
        return result;
    }
}
