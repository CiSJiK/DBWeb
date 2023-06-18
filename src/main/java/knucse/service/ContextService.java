package knucse.service;

import jakarta.transaction.Transactional;
import knucse.entity.ContextEntity;
import knucse.entity.ReadNovelEntity;
import knucse.repository.ContextInterface;
import knucse.repository.NovelInterface;

import java.util.List;
import java.util.Optional;

@Transactional
public class ContextService {
    private final ContextInterface contextInterfaceRepository;
    private final NovelInterface readnovel;

    public ContextService(ContextInterface contextInterface, NovelInterface r){
        this.contextInterfaceRepository = contextInterface;
        readnovel = r;

    }

    public int join(ContextEntity context){
        System.out.println();
        System.out.println("<<<<< ContextService.join context 등록 서비스 시작 >>>>> ");
        System.out.println("context.cid = " + context.getCid());
        System.out.println("context.uid = " + context.getUnum());
        System.out.println("context.ctext = " + context.getCtext());
        contextInterfaceRepository.save(context);
        return context.getCid();
    }
    public List<ReadNovelEntity> findContext(int nnum){
        return readnovel.findByNnumRead(nnum);
    }
    public Optional<ContextEntity> findOne(int cid){
        return contextInterfaceRepository.findByCid(cid);
    }
}
