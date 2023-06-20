package knucse.repository;

import knucse.entity.ReadFeedbackEntity;

import java.util.Optional;

public interface ReadFeedbackInterface {
    Optional<ReadFeedbackEntity> findByFid(int fid);
}
