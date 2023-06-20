package knucse.repository;

import knucse.entity.NovelEntity;
import knucse.entity.NovelListEntity;
import knucse.entity.ReadNovelEntity;

import java.util.List;
import java.util.Optional;

public interface NovelInterface {
    void save(NovelEntity novel);
    Optional<NovelEntity> findByNnum(int nnum);
    List<NovelEntity> findAllEntity();
    List<NovelListEntity> findDone();
    List<NovelListEntity> findAllList();
    int findNewNnum();
    List<ReadNovelEntity> findByNnumRead(int nnum);
}
