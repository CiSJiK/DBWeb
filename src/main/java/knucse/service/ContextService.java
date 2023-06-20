package knucse.service;

import jakarta.transaction.Transactional;
import knucse.entity.ContextEntity;
import knucse.entity.ReadNovelEntity;
import knucse.repository.ContextInterface;

import java.util.List;
import java.util.Optional;

@Transactional
public class ContextService {
    private final ContextInterface contextInterfaceRepository;
    private final ReadNovelInterfaceRepository readnovel;

    public ContextService(ContextInterface contextInterfaceRepository, ReadNovelInterfaceRepository r){
        this.contextInterfaceRepository = contextInterfaceRepository;
        readnovel = r;

    }

    public int join(ContextEntity context){
        System.out.println();
        System.out.println("<<<<< ContextService.join context 등록 서비스 시작 >>>>> ");
        System.out.println("context.cid = " + context.getCid());
        System.out.println("context.nnum = " + context.getNnum());
        System.out.println("context.uid = " + context.getUid());
        System.out.println("context.ctext = " + context.getCtext());
        contextInterfaceRepository.save(context);
        return context.getCid();
    }
    public List<ReadNovelEntity> findContext(int nnum){
        return readnovel.findByNnum(nnum);
    }
    public Optional<ContextEntity> findOne(int cid){
        return contextInterfaceRepository.findByCid(cid);
    }
}
