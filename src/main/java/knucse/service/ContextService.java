package knucse.service;

import knucse.domain.Context;
import knucse.entity.ContextEntity;
import knucse.repository.ContextInterfaceRepository;
import java.util.List;
import java.util.Optional;

public class ContextService {
    private final ContextInterfaceRepository contextInterfaceRepository;

    public ContextService(ContextInterfaceRepository contextInterfaceRepository){
        this.contextInterfaceRepository = contextInterfaceRepository;
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
    public List<ContextEntity> findContext(){
        return contextInterfaceRepository.findAll();
    }
    public Optional<ContextEntity> findOne(int cid){
        return contextInterfaceRepository.findByCid(cid);
    }
}
