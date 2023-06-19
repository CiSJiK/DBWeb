package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Novel;
import knucse.entity.NovelEntity;

import java.util.Optional;
import java.util.List;
public class NovelRepository implements NovelInterfaceRepository{
    private final EntityManager em;

    public NovelRepository(EntityManager em) { this.em = em; }

    @Override
    public void save(NovelEntity novel){
        em.persist(novel);
    }

    @Override
    public Optional<NovelEntity> findByNnum(int nnum){
        NovelEntity novel = em.find(NovelEntity.class, nnum);
        return Optional.ofNullable(novel);
    }

    @Override
    public List<NovelEntity> findAll() {
        List<NovelEntity> result = em.createQuery("select n from novel n", NovelEntity.class)
                .getResultList();
        return result;
    }
}
