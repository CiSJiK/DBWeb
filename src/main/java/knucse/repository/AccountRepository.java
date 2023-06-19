package knucse.repository;

import jakarta.persistence.EntityManager;
import knucse.domain.Account;
import java.util.Optional;


public class AccountRepository{
    private final EntityManager em;

    public AccountRepository(EntityManager em){
        this.em = em;
    }
    public Account save(Account account) {
        em.persist(account);
        return account;
    }

    public Optional<Account> findByUid(String uid) {
        Account account = em.find(Account.class, uid);
        return Optional.ofNullable(account);
    }
}
