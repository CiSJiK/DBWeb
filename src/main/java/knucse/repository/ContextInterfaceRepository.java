package knucse.repository;

import knucse.domain.Context;
import knucse.entity.ContextEntity;

import java.util.Optional;
import java.util.List;
public interface ContextInterfaceRepository {
    void save(ContextEntity context);
    Optional<ContextEntity> findByCid(int cid);
    List<ContextEntity> findAll();
}
