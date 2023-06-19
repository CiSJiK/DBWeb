package knucse.repository;

import knucse.domain.Account;
import knucse.entity.AccountEntity;

import java.util.Optional;

public interface AccountInterfaceRepository {
    void save(AccountEntity account);
    Optional<AccountEntity> findByUid(String uid);
    boolean checkLogin(AccountEntity account);
}
