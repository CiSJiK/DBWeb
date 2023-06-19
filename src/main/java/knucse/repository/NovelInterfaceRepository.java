package knucse.repository;

import knucse.domain.Novel;

import java.util.List;
import java.util.Optional;

public interface NovelInterfaceRepository {
    Novel save(Novel novel);
    public Optional<Novel> findByNnum(int nnum);
    List<Novel> findAll();
}
