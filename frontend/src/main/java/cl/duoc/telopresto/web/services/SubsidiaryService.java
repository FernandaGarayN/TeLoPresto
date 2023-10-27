package cl.duoc.telopresto.web.services;

import cl.duoc.telopresto.web.apiclients.subsidiary.SubsidiaryClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class SubsidiaryService {
    private final SubsidiaryClient subsidiaryClient;
    public List<String> getListOfSubsidiaries(){
        return subsidiaryClient.listOfSubsidiary();
    }
}
