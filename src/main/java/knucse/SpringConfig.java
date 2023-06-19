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
    public AccountInterfaceRepository accountInterfaceRepository(){
        return new AccountRepository(em);
    }

    @Bean
    public FeedbackService feedbackService(){
        return new FeedbackService(feedbackInterfaceRepository(), flir(), rfir());
    }
    @Bean
    public FeedbackInterfaceRepository feedbackInterfaceRepository(){
        return new FeedbackRepository(em);
    }
    @Bean
    public FeedbackListInterfaceRepository flir() {return new FeedbackListRepository(em);}
    @Bean
    public ReadFeedbackInterfaceRepository rfir(){return new ReadFeedbackRepositoy(em);}

    @Bean
    public NovelService novelService() {
        return new NovelService(novelInterfaceRepository(), nlir());
    }
    @Bean
    public NovelInterfaceRepository novelInterfaceRepository(){
        return new NovelRepository(em);
    }
    @Bean
    public NovelListInterfaceRepository nlir() { return new NovelListRepository(em); }
    @Bean
    public ContextService contextService(){ return  new ContextService(contextInterfaceRepository(), readnovel()); }
    @Bean
    public ContextInterfaceRepository contextInterfaceRepository() { return new ContextRepository(em); }
    @Bean
    public ReadNovelInterfaceRepository readnovel(){ return new ReadNovelRepository(em);}
}
