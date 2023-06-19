package knucse.controller;

import knucse.domain.Account;
import knucse.repository.AccountInterfaceRepository;
import knucse.repository.FeedbackInterfaceRepository;
import knucse.repository.NovelInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
    private final AccountInterfaceRepository accountInterfaceRepository;
    private final FeedbackInterfaceRepository feedbackInterfaceRepository;
    private final NovelInterfaceRepository novelInterfaceRepository;
    @Autowired
    public Controller(AccountInterfaceRepository accountInterfaceRepository,
                      FeedbackInterfaceRepository feedbackInterfaceRepository,
                      NovelInterfaceRepository novelInterfaceRepository){
        this.accountInterfaceRepository = accountInterfaceRepository;
        this.feedbackInterfaceRepository = feedbackInterfaceRepository;
        this.novelInterfaceRepository = novelInterfaceRepository;
    }
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping(value="/novels/novel_list")
    public String call_forums_with_topics() {
        return "/novels/novel_list";
    }
    @GetMapping(value="/chaos")
    public String call_forums_without_topics() {
        return "/novels/read";
    }
    @GetMapping(value="/create_account")
    public String call_member_signup_page() {
        return "/create_account";
    }
    @PostMapping(value="/create_account")
    public String create_account(AccountForm form){
        System.out.println("*** 회원가입 폼 실행 시작 *** ");
        Account account = new Account();
        account.setUid(form.getUid());
        account.setUpw(form.getUpw());
        accountInterfaceRepository.save(account);
        return "redirect:/";
    }


    @GetMapping(value="/novels/finished_novel_list")
    public String call_the_finished_novel_page(){
        return "/novel_list";
    }
    @GetMapping("/novel/writing/{novel_name}/new")
    public String call_new_novel_page(@PathVariable String novel_name) {
        return "Read";
    }
    @GetMapping("/novel/writing/{novel_name}")
    public String call_writing_novel_page(@PathVariable String novel_name){
        return "Read";
    }
    @PostMapping(value="/subject/novel_list")
    public String call_main_page(){
        return "redirect:/";
    }

}
