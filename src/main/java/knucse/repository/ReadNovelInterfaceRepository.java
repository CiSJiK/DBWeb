package knucse.repository;

import knucse.entity.ReadNovelEntity;

import java.util.List;
import java.util.Optional;

public interface ReadNovelInterfaceRepository {
    List<ReadNovelEntity> findByNnum(int nnum);
}
