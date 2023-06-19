package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Novel;
import java.util.Optional;
import java.util.List;
public class NovelRepository {
    private final EntityManager em;

    public NovelRepository(EntityManager em) { this.em = em; }

    public Novel save(Novel novel){
        em.persist(novel);
        return novel;
    }

    public Optional<Novel> findByNnum(int nnum){
        Novel novel = em.find(Novel.class, nnum);
        return Optional.ofNullable(novel);
    }

    public List<Novel> findAll() {
        List<Novel> result = em.createQuery("select n from novel n", Novel.class)
                .getResultList();
        return result;
    }
}
