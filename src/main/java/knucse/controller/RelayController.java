package knucse.controller;

import knucse.domain.Account;
import knucse.entity.*;
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
import java.util.List;
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
    @GetMapping("/index")
    public String home() {
        System.out.println("call home");
        return "/home";
    }
    @GetMapping(value="/novels/novel_list")
    public String call_novel_with_topics(Model model) {
        List<NovelListEntity> novelList = novelService.findNovel();
        model.addAttribute("novelList", novelList);
        return "/novels/novel_list";
    }
    @GetMapping(value="/chaos")
    public String call_novel_without_topics(Model model) {
        List<ReadNovelEntity> novelWithoutTopic = contextService.findContext(0);
        model.addAttribute("novelWithoutTopic", novelWithoutTopic);
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
        List<ReadNovelEntity> ReadNovelEntity = contextService.findContext(nnum);
        model.addAttribute("context", ReadNovelEntity);
        return "read";
    }

    @GetMapping(value = "/novel/complete_novel_list")
    public String call_complete_novel_page(Model model){
        List<NovelDoneListEntity> novelDoneListEntity = novelService.findDone();
        model.addAttribute("novelDoneListEntity", novelDoneListEntity);
        return "novel_list";
    }




}
