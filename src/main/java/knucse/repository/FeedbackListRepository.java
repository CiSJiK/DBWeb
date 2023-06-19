package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Feedback;
import knucse.entity.FeedbackEntity;
import knucse.entity.FeedbackListEntity;

import java.util.List;
import java.util.Optional;

public class FeedbackListRepository implements FeedbackListInterfaceRepository{
    private final EntityManager em;

    public FeedbackListRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public List<FeedbackListEntity> findByNnum(int nnum){
        List<FeedbackListEntity> result = em.createQuery("select f from feedbackList f where f.nnum = nnum",
                        FeedbackListEntity.class).getResultList();
        return result;
    }
}
