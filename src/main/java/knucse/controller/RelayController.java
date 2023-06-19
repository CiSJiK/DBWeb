package knucse.controller;

import knucse.domain.Account;
import knucse.entity.AccountEntity;
import knucse.service.AccountService;
import knucse.service.ContextService;
import knucse.service.FeedbackService;
import knucse.service.NovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RelayController {
    private final AccountService accountService;
    private final ContextService contextService;
    private final FeedbackService feedbackService;
    private final NovelService novelService;
    @Autowired
    public RelayController(AccountService accountService,
                           ContextService contextService,
                           FeedbackService feedbackService,
                           NovelService novelService) {
        this.accountService = accountService;
        this.contextService = contextService;
        this.feedbackService = feedbackService;
        this.novelService = novelService;
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }
    @GetMapping(value="/novels/novel_list")
    public String call_forums_with_topics(Model model) {
        // 완결된 작품이랑 완결되지 않은 작품이랑 섞인 리스트 출력
        return "/novels/novel_list";
    }
    @GetMapping(value="/chaos")
    public String call_forums_without_topics() {
        //nnum 0 으로 /novel/0
        return "/novels/read";
    }
    @GetMapping(value="/create_account")
    public String call_member_signup_page() {
        return "/create_account";
    }
    @PostMapping(value="/create_account")
    public String create_account(AccountEntity form){
        accountService.join(form);
        return "redirect:/";
    }

    @GetMapping(value="/novel/{nnum}")
    public String call_reading_novel_page(@PathVariable int nnum, Model model){

        return "read";
    }


}
