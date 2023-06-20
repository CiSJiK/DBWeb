package knucse.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import knucse.domain.Account;
import knucse.entity.AccountEntity;

import java.util.List;
import java.util.Optional;


public class AccountRepository implements AccountInterface {
    private final EntityManager em;

    public AccountRepository(EntityManager em){
        this.em = em;
    }
    @Override
    @Transactional
    public void save(AccountEntity account) {
        em.persist(account);
    }

    @Override
    public Optional<AccountEntity> findByUid(String uid) {
        AccountEntity account = em.find(AccountEntity.class, uid);
        return Optional.ofNullable(account);
    }

    @Override
    public boolean checkLogin(AccountEntity account){
        String jpql = "select a from account a where a.uid = :uid and a.upw = :upw";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("uid", account.getUid());
        query.setParameter("upw", account.getUpw());
        List<Account> result = query.getResultList();
        if(result.equals(account)) return true;
        return false;
    }
}
