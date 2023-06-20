package knucse.repository;

import knucse.entity.FeedbackEntity;
import knucse.entity.FeedbackListEntity;

import java.util.List;
import java.util.Optional;

public interface FeedbackInterface {
    void save(FeedbackEntity feedback);
    Optional<FeedbackEntity> findByFid(int fid);
    List<FeedbackEntity> findAll();
    List<FeedbackListEntity> findByNnum(int nnum);
}
