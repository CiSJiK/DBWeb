package knucse.service;

import knucse.domain.Novel;
import knucse.entity.NovelDoneListEntity;
import knucse.entity.NovelEntity;
import knucse.entity.NovelListEntity;
import knucse.repository.NovelInterfaceRepository;
import knucse.repository.NovelListInterfaceRepository;

import java.util.List;
import java.util.Optional;
public class NovelService {
    private final NovelInterfaceRepository novelInterfaceRepository;
    private final NovelListInterfaceRepository nlr;

    public NovelService(NovelInterfaceRepository novelInterfaceRepository, NovelListInterfaceRepository r){
        this.novelInterfaceRepository = novelInterfaceRepository;
        nlr = r;
    }

    public int join(NovelEntity novel) {
        System.out.println();
        System.out.println("<<<<< NovelService.join novel 등록 서비스 시작 >>>>> ");
        System.out.println("novel.nnum = " + novel.getNnum());
        System.out.println("novel.nname = " + novel.getNname());
        System.out.println("feedback.ncon = " + novel.getNcon());
        novelInterfaceRepository.save(novel);
        return novel.getNnum();
    }
    /*
    전체 소설 목록 불러오기
     */
    public List<NovelListEntity> findNovel(){
        return nlr.findAll();
    }
    /*
    완결된 소설 목록 불러오기
     */
    public List<NovelDoneListEntity> findDone(){return nlr.findDone();}
    public int findMaxNnum(){return nlr.findNewNnum();}
}
