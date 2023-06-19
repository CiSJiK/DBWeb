package knucse.service;

import jakarta.transaction.Transactional;
import knucse.domain.Account;
import knucse.repository.AccountInterfaceRepository;

import java.util.Optional;

@Transactional
public class AccountService {
    private final AccountInterfaceRepository accountInterfaceRepository;
    public AccountService(AccountInterfaceRepository accountInterfaceRepository){
        this.accountInterfaceRepository =accountInterfaceRepository;
    }

    public String join(Account account){
        System.out.println();
        System.out.println("<<<<< AccountService.join 회원 가입 서비스 시작 >>>>> ");
        System.out.println("account.uid = " + account.getUid());
        System.out.println("account.upw = " + account.getUpw());
        validDuplicateAccount(account);
        accountInterfaceRepository.save(account);
        return account.getUid();
    }

    private void validDuplicateAccount(Account account){
        Optional<Account> result = accountInterfaceRepository.findByUid(account.getUid());
        result.ifPresent(m ->{
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
