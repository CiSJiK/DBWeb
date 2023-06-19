package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.entity.NovelEntity;
import knucse.entity.ReadFeedbackEntity;

import java.util.Optional;

public class ReadFeedbackRepositoy implements ReadFeedbackInterfaceRepository{
    private final EntityManager em;

    public ReadFeedbackRepositoy(EntityManager em) { this.em = em; }
    @Override
    public Optional<ReadFeedbackEntity> findByFid(int fid){
        ReadFeedbackEntity feedback = em.find(ReadFeedbackEntity.class, fid);
        return Optional.ofNullable(feedback);
    }
}
