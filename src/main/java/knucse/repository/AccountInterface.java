package knucse.repository;

import knucse.entity.AccountEntity;

import java.util.Optional;

public interface AccountInterface {
    void save(AccountEntity account);
    Optional<AccountEntity> findByUid(String uid);
    boolean checkLogin(AccountEntity account);
}
