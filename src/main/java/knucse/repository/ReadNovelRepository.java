package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.entity.ReadNovelEntity;

import java.util.List;

public class ReadNovelRepository implements ReadNovelInterfaceRepository{
    private final EntityManager em;

    public ReadNovelRepository(EntityManager em) { this.em = em; }

    @Override
    public List<ReadNovelEntity> findByNnum(int nnum) {
        List<ReadNovelEntity> result =
                em.createQuery("select n from readNovel n where n.nnum=nnum", ReadNovelEntity.class).getResultList();
        return result;
    }
}
