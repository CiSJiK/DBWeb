package knucse.repository;

import knucse.entity.NovelDoneListEntity;
import knucse.entity.NovelListEntity;

import java.util.List;
import java.util.Optional;

public interface NovelListInterfaceRepository {
    List<NovelDoneListEntity> findDone();
    List<NovelListEntity> findAll();
    int findNewNnum();
}
