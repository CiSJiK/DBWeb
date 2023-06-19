package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Context;
import knucse.entity.ContextEntity;

import java.util.Optional;
import java.util.List;

public class ContextRepository implements ContextInterfaceRepository{
    private final EntityManager em;
    public ContextRepository(EntityManager em){
        this.em = em;
    }
    @Override
    public void save(ContextEntity context){
        em.persist(context);
    }
    @Override
    public Optional<ContextEntity> findByCid(int cid){
        ContextEntity context = em.find(ContextEntity.class, cid);
        return Optional.ofNullable(context);
    }
    @Override
    public List<ContextEntity> findAll(){
        List<ContextEntity> result = em.createQuery("select c from context c", ContextEntity.class)
                .getResultList();
        return result;
    }
}