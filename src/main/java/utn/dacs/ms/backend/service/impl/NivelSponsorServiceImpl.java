package utn.dacs.ms.backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.NivelSponsor;
import utn.dacs.ms.backend.model.repository.NivelSponsorRepository;
import utn.dacs.ms.backend.service.interfaces.NivelSponsorService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NivelSponsorServiceImpl implements NivelSponsorService {
    @Autowired
    NivelSponsorRepository nivelSponsorRepository;

    @Override
    public Optional<NivelSponsor> getById(Long id) {
        return nivelSponsorRepository.findById(id);
    }

    @Override
    public List<NivelSponsor> getAll() {
        return nivelSponsorRepository.findAll();
    }



    @Override
    public void delete(Long id) {
        Optional<NivelSponsor> nivelSponsor = getById(id);
        nivelSponsorRepository.delete(nivelSponsor.get());
    }

    @Override
    public NivelSponsor save(NivelSponsor entity) {
        return nivelSponsorRepository.save(entity);
    }

    @Override
    public List<NivelSponsor> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public NivelSponsor getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return nivelSponsorRepository.existsById(id);
    }
}
