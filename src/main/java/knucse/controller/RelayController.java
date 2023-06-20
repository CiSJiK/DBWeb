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
    @GetMapping("/")
    public String home() {
        System.out.println("call home");
        return "/home";
    }
    @GetMapping(value="/novels/novel_list")
    public String call_novel_with_topics(Model model) {
        List<NovelListEntity> novelList = novelService.findNovel();
        model.addAttribute("novel_list", novelList);
        return "/novel/novel_list";
    }
    @GetMapping(value="/novels/{nnum}")
    public String call_reading_novel_page(@PathVariable int nnum, Model model){
        List<ReadNovelEntity> entityList = contextService.findContext(nnum);
        model.addAttribute("context", entityList);
        return "/novel/read";
    }
    @PostMapping("/novel/{nnum}/new")
    public String register_new_context(@PathVariable int nnum, AccountForm an, ContextForm cn, Model model){
        AccountEntity a = new AccountEntity();
        ContextEntity e = new ContextEntity();
        a.setUid(an.getId());
        a.setUpw(an.getPw());
        e.setNnum(nnum);
        e.setUid(an.getId());
        e.setCtext(cn.getContext());
        boolean isTrue = accountService.isVaildAccount(a);
        if(isTrue){
            contextService.join(e);
            System.out.println("----- register_context success------");
        } else{
            System.out.println("----- register_context fail------");
        }
        model.addAttribute("cn", cn);
        return "/novel/read";
    }
    @GetMapping(value="/chaos")
    public String call_novel_without_topics(Model model) {
        List<ReadNovelEntity> entityList = contextService.findContext(0);
        model.addAttribute("context", entityList);
        return "/novel/read";
    }
    @GetMapping(value="/create_account")
    public String accountCall()
    {
        return "/create_account";
    }
    @PostMapping(value="/create_account")
    public String create_account(AccountForm form){
        AccountEntity entity = new AccountEntity();
        entity.setUnum(0);
        entity.setUid(form.getId());
        entity.setUpw(form.getPw());
        if(form.getPw().equals(form.getCheck())) {
            accountService.join(entity);
            return "redirect:/";
        }
        else {
            return "redirect:/create_account";
        }
    }
    @GetMapping(value = "/novels/complete_novel_list")
    public String call_complete_novel_page(Model model){
        List<NovelListEntity> novelDoneListEntity = novelService.findDone();
        model.addAttribute("novel_list", novelDoneListEntity);
        return "/novel/complete_novel_list";
    }
    @PostMapping(value = "/novels/novel_list")
    public String register_new_novel(NovelForm novel, Model model){
        NovelEntity entity = new NovelEntity();
        entity.setNname(novel.getTitle());
        entity.setNnum(novelService.findMaxNnum() + 1);
        System.out.println("insert start");
        novelService.join(entity);
        List<ReadNovelEntity> readNovelEntity = contextService.findContext(entity.getNnum());
        model.addAttribute("readNovelEntity", readNovelEntity);
        return "/novel/read";
    }


    //@GetMapping("/novel/{nnum}/feedback")
    /*(public String call_feedback_page(@PathVariable int nnum, Model model){
        List<FeedbackListEntity> fb =  feedbackService.getFeedbacks(nnum);
        model.addAttribute("fb", fb);
        return "/feedbacks/read";
    }
    @PostMapping("/novel/{nnum}/feedback")
    public String register_feedback(@PathVariable int nnum, AccountEntity an, FeedbackEntity fn, Model model){
        boolean isTrue = accountService.isVaildAccount(an);
        if(isTrue){
            feedbackService.join(fn);
            System.out.println("----- register_context success------");
        } else{
            System.out.println("----- register_context fail------");
        }
        model.addAttribute("fn", fn);
        return "/feedbacks/read";
    }*/
}
