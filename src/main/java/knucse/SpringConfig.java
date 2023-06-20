package knucse;

import jakarta.persistence.EntityManager;
import knucse.repository.*;
import knucse.service.AccountService;
import knucse.service.ContextService;
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
        return new AccountService(accountInterfaceRepository());
    }
    @Bean
    public AccountInterface accountInterfaceRepository(){
        return new AccountRepository(em);
    }

    @Bean
    public FeedbackService feedbackService(){
        return new FeedbackService(feedbackInterfaceRepository(), flir(), rfir());
    }
    @Bean
    public FeedbackInterface feedbackInterfaceRepository(){
        return new FeedbackRepository(em);
    }
    @Bean
    public FeedbackInterface flir() {return new FeedbackRepository(em);}
    @Bean
    public ReadFeedbackInterfaceRepository rfir(){return new ReadFeedbackRepositoy(em);}

    @Bean
    public NovelService novelService() {
        return new NovelService(novelInterfaceRepository(), nlir());
    }
    @Bean
    public NovelInterface novelInterfaceRepository(){
        return new NovelRepository(em);
    }
    @Bean
    public NovelInterface nlir() { return new NovelRepository(em); }
    @Bean
    public ContextService contextService(){ return  new ContextService(contextInterfaceRepository(), readnovel()); }
    @Bean
    public ContextInterface contextInterfaceRepository() { return new ContextRepository(em); }
    @Bean
    public ReadNovelInterfaceRepository readnovel(){ return new ReadNovelRepository(em);}
}
