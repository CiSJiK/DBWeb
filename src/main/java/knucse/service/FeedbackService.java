package knucse.service;

import knucse.domain.Feedback;
import knucse.repository.FeedbackInterfaceRepository;
import java.util.Optional;
import java.util.List;
public class FeedbackService {
    private final FeedbackInterfaceRepository feedbackInterfaceRepository;
    public FeedbackService(FeedbackInterfaceRepository feedbackInterfaceRepository){
        this.feedbackInterfaceRepository = feedbackInterfaceRepository;
    }

    public int join(Feedback feedback){
        System.out.println();
        System.out.println("<<<<< FeedbackService.join feedback 등록 서비스 시작 >>>>> ");
        System.out.println("feedback.fid = " + feedback.getFid());
        System.out.println("feedback.fname = " + feedback.getFname());
        System.out.println("feedback.fcon = " + feedback.getFcon());
        feedbackInterfaceRepository.save(feedback);
        return feedback.getFid();
    }

    public List<Feedback> findFeedback(){
        return feedbackInterfaceRepository.findAll();
    }
    public Optional<Feedback> findOne(int fid){
        return feedbackInterfaceRepository.findByFid(fid);
    }
}
