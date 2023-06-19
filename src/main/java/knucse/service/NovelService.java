package knucse.service;

import knucse.domain.Novel;
import knucse.entity.NovelEntity;
import knucse.repository.NovelInterfaceRepository;
import java.util.List;
import java.util.Optional;
public class NovelService {
    private final NovelInterfaceRepository novelInterfaceRepository;

    public NovelService(NovelInterfaceRepository novelInterfaceRepository){
        this.novelInterfaceRepository = novelInterfaceRepository;
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

    public List<NovelEntity> findNovel(){
        return novelInterfaceRepository.findAll();
    }

    public Optional<NovelEntity> findOne(int novelnum){
        return novelInterfaceRepository.findByNnum(novelnum);
    }
}
