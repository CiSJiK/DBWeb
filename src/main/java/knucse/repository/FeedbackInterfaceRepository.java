package knucse.repository;

import knucse.domain.Feedback;

import java.util.List;
import java.util.Optional;

public interface FeedbackInterfaceRepository {
    Feedback save(Feedback feedback);
    Optional<Feedback> findByFid(int fid);
    List<Feedback> findAll();
}
