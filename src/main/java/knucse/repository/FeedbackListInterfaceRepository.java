package knucse.repository;

import knucse.entity.FeedbackListEntity;

import java.util.List;
import java.util.Optional;

public interface FeedbackListInterfaceRepository {
    List<FeedbackListEntity> findByNnum(int nnum);
}
