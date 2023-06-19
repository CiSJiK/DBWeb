package knucse.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import knucse.domain.Account;

import java.util.List;
import java.util.Optional;


public class AccountRepository implements AccountInterfaceRepository {
    private final EntityManager em;

    public AccountRepository(EntityManager em){
        this.em = em;
    }
    @Override @Transactional
    public Account save(Account account) {
        em.persist(account);
        return account;
    }

    @Override
    public Optional<Account> findByUid(String uid) {
        Account account = em.find(Account.class, uid);
        return Optional.ofNullable(account);
    }

    @Override
    public boolean checkLogin(Account account){
        String jpql = "select a from account a where a.uid = :uid and a.upw = :upw";
        TypedQuery<Account> query = em.createQuery(jpql, Account.class);
        query.setParameter("uid", account.getUid());
        query.setParameter("upw", account.getUpw());
        List<Account> result = query.getResultList();
        if(result.equals(account)) return true;
        return false;
    }
}
