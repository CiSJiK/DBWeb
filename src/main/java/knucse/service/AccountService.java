package knucse.service;

import jakarta.transaction.Transactional;
import knucse.entity.AccountEntity;
import knucse.repository.AccountInterface;

import java.util.Optional;

@Transactional
public class AccountService {
    private final AccountInterface accountInterfaceRepository;
    public AccountService(AccountInterface accountInterfaceRepository){
        this.accountInterfaceRepository =accountInterfaceRepository;
    }

    public String join(AccountEntity account){
        System.out.println();
        System.out.println("<<<<< AccountService.join 회원 가입 서비스 시작 >>>>> ");
        System.out.println("account.uid = " + account.getUid());
        System.out.println("account.upw = " + account.getUpw());
        validDuplicateAccount(account);
        accountInterfaceRepository.save(account);
        return account.getUid();
    }

    private void validDuplicateAccount(AccountEntity account){
        Optional<AccountEntity> result = accountInterfaceRepository.findByUid(account.getUid());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

    }
    /*
    유효한 계정인지 검증
     */
    public boolean isVaildAccount(AccountEntity account){
        Optional<AccountEntity> result = accountInterfaceRepository.findByUid(account.getUid());
        if(account.getUpw().equals(result.get().getUpw())) return true;
        else return false;
    }

}
