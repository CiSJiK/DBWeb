package knucse.repository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import knucse.entity.NovelEntity;
import knucse.entity.NovelListEntity;
import knucse.entity.ReadNovelEntity;

import java.util.Optional;
import java.util.List;
public class NovelRepository implements NovelInterface {
    private final EntityManager em;

    public NovelRepository(EntityManager em) { this.em = em; }

    @Override
    @Transactional
    public void save(NovelEntity novel){
        em.persist(novel);
    }

    @Override
    public Optional<NovelEntity> findByNnum(int nnum){
        NovelEntity novel = em.find(NovelEntity.class, nnum);
        return Optional.ofNullable(novel);
    }

    @Override
    public List<NovelEntity> findAllEntity() {
        List<NovelEntity> result = em.createQuery("select n from novel n", NovelEntity.class)
                .getResultList();
        return result;
    }
    @Override
    public List<NovelListEntity> findDone(){
        List<NovelListEntity> novel = em.createQuery("select n from novelDoneList n").getResultList();
        return novel;
    }

    @Override
    public List<NovelListEntity> findAllList() {
        List<NovelListEntity> result = em.createQuery("select n from novelList n", NovelListEntity.class)
                .getResultList();
        return result;
    }

    @Override
    public int findNewNnum(){
        NovelListEntity result = em.createQuery("select n from novelList n", NovelListEntity.class)
                .getResultList().get(0);
        return result.getNnum();
    }
    @Override
    public List<ReadNovelEntity> findByNnumRead(int nnum) {
        List<ReadNovelEntity> result =
                em.createQuery("select n from readNovel n where n.nnum=nnum", ReadNovelEntity.class).getResultList();
        return result;
    }
}
