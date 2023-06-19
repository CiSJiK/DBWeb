package knucse.repository;

import knucse.domain.Account;

import java.util.Optional;

public interface AccountInterfaceRepository {
    Account save(Account account);
    Optional<Account> findByUid(String uid);
    boolean checkLogin(Account account);
}
