package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.entity.NovelDoneListEntity;
import knucse.entity.NovelEntity;
import knucse.entity.NovelListEntity;

import java.util.List;
import java.util.Optional;

public class NovelListRepository implements NovelListInterfaceRepository{
    private final EntityManager em;

    public NovelListRepository(EntityManager em) { this.em = em; }


    @Override
    public List<NovelDoneListEntity> findDone(){
        List<NovelDoneListEntity> novel = em.createQuery("select n from novelDoneList n").getResultList();
        return novel;
    }

    @Override
    public List<NovelListEntity> findAll() {
        List<NovelListEntity> result = em.createQuery("select n from novelList n", NovelListEntity.class)
                .getResultList();
        return result;
    }

    @Override
    public int findNewNnum(){
        List<NovelListEntity> result = em.createQuery("select MAX(nnum) from novelList n",NovelListEntity.class)
                .getResultList();
        NovelListEntity temp = result.get(0);
        return temp.getNnum();
    }
}
