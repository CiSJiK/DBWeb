package knucse.repository;

import knucse.domain.Novel;
import knucse.entity.NovelEntity;

import java.util.List;
import java.util.Optional;

public interface NovelInterfaceRepository {
    void save(NovelEntity novel);
    Optional<NovelEntity> findByNnum(int nnum);
    List<NovelEntity> findAll();
}
