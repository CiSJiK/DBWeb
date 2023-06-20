package knucse.repository;

import knucse.entity.ContextEntity;

import java.util.Optional;
import java.util.List;
public interface ContextInterface {
    void save(ContextEntity context);
    Optional<ContextEntity> findByCid(int cid);
    List<ContextEntity> findAll();
}
