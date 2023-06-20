package knucse.service;

import jakarta.transaction.Transactional;
import knucse.entity.NovelEntity;
import knucse.entity.NovelListEntity;
import knucse.repository.NovelInterface;

import java.util.List;

@Transactional
public class NovelService {
    private final NovelInterface novelInterface;

    public NovelService(NovelInterface novelInterface){
        this.novelInterface = novelInterface;
    }

    public int join(NovelEntity novel) {
        System.out.println();
        System.out.println("<<<<< NovelService.join novel 등록 서비스 시작 >>>>> ");
        System.out.println("novel.nnum = " + novel.getNnum());
        System.out.println("novel.nname = " + novel.getNname());
        System.out.println("feedback.ncon = " + novel.getNcon());
        novelInterface.save(novel);
        return novel.getNnum();
    }
    /*
    전체 소설 목록 불러오기
     */
    public List<NovelListEntity> findNovel(){
        return novelInterface.findAllList();
    }
    /*
    완결된 소설 목록 불러오기
     */
    public List<NovelListEntity> findDone(){return novelInterface.findDone();}
    public int findMaxNnum(){return novelInterface.findNewNnum();}
}
