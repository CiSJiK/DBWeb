package knucse.repository;

import knucse.entity.ReadFeedbackEntity;

import java.util.Optional;

public interface ReadFeedbackInterfaceRepository {
    Optional<ReadFeedbackEntity> findByFid(int fid);
}
