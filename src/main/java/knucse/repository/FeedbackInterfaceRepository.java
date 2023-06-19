package knucse.repository;

import knucse.domain.Feedback;
import knucse.entity.FeedbackEntity;

import java.util.List;
import java.util.Optional;

public interface FeedbackInterfaceRepository {
    void save(FeedbackEntity feedback);
    Optional<FeedbackEntity> findByFid(int fid);
    List<FeedbackEntity> findAll();
}
