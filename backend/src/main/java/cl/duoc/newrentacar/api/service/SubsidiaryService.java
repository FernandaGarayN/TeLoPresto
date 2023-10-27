package cl.duoc.newrentacar.api.service;

import cl.duoc.newrentacar.api.endpoint.model.Subsidiary;
import cl.duoc.newrentacar.api.repository.SubsidiaryRepository;
import cl.duoc.newrentacar.api.repository.model.SubsidiaryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubsidiaryService {
    @Autowired private SubsidiaryRepository subsidiaryRepository;

    public List <Subsidiary> getAllSubsidiaries(){
        List<Subsidiary> finalSubsidiaries = new ArrayList<>();
        List<SubsidiaryEntity> subsidiaries = (List<SubsidiaryEntity>) subsidiaryRepository.findAll();
        for (SubsidiaryEntity entity : subsidiaries) {
            finalSubsidiaries.add(getSubsidiaries(entity));
        }
        return finalSubsidiaries;

    }

    private Subsidiary getSubsidiaries(SubsidiaryEntity dbSubsidiary) {
        Subsidiary subsidiary = new Subsidiary();
        subsidiary.setId(dbSubsidiary.getId());
        subsidiary.setName(dbSubsidiary.getName());
        subsidiary.setAddress(dbSubsidiary.getAddress());
        subsidiary.setPhoneNumber(dbSubsidiary.getPhoneNumber());
        return subsidiary;
    }
}
