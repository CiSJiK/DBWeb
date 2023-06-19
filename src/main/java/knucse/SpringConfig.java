package knucse;

import jakarta.persistence.EntityManager;
import knucse.repository.*;
import knucse.service.AccountService;
import knucse.service.FeedbackService;
import knucse.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(AccountInterfaceRepository());
    }
    @Bean
    public AccountInterfaceRepository accountInterfaceRepository(){
        return new AccountRepository(em);
    }

    @Bean
    public FeedbackService feedbackService(){
        return new FeedbackService(FeedbackInterfaceRepository());
    }
    @Bean
    public FeedbackInterfaceRepository feedbackInterfaceRepository(){
        return new FeedbackRepository(em);
    }

    @Bean
    public NovelService novelService() {
        return new NovelService(NovelInterfaceRepository());
    }
    @Bean
    public NovelInterfaceRepository novelInterfaceRepository(){
        return new NovelRepository(em);
    }
}
