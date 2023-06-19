package knucse.service;

import knucse.domain.Feedback;
import knucse.entity.FeedbackEntity;
import knucse.entity.FeedbackListEntity;
import knucse.entity.ReadFeedbackEntity;
import knucse.repository.FeedbackInterfaceRepository;
import knucse.repository.FeedbackListInterfaceRepository;
import knucse.repository.ReadFeedbackInterfaceRepository;

import java.util.Optional;
import java.util.List;
public class FeedbackService {
    private final FeedbackInterfaceRepository feedbackInterfaceRepository;
    private final FeedbackListInterfaceRepository repository;
    private final ReadFeedbackInterfaceRepository readfeed;
    public FeedbackService(FeedbackInterfaceRepository feedbackInterfaceRepository, FeedbackListInterfaceRepository r, ReadFeedbackInterfaceRepository f){
        this.feedbackInterfaceRepository = feedbackInterfaceRepository;
        repository = r;
        readfeed = f;
    }

    public int join(FeedbackEntity feedback){
        System.out.println();
        System.out.println("<<<<< FeedbackService.join feedback 등록 서비스 시작 >>>>> ");
        System.out.println("feedback.fid = " + feedback.getFid());
        System.out.println("feedback.fname = " + feedback.getFname());
        System.out.println("feedback.fcon = " + feedback.getFcon());
        feedbackInterfaceRepository.save(feedback);
        return feedback.getFid();
    }
    /*
    특정 소설 번호의 피드백 목록 가져오기
     */
    public List<FeedbackListEntity> getFeedbacks(int nnum){
        return repository.findByNnum(nnum);
    }
    /*
    특정 피드백의 내용 가져오기
     */
    public Optional<ReadFeedbackEntity> findOne(int fid){
        return readfeed.findByFid(fid);
    }
}
