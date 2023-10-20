package utn.dacs.ms.backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.Sponsor;
import utn.dacs.ms.backend.model.repository.SponsorRepository;
import utn.dacs.ms.backend.service.interfaces.SponsorService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {
    @Autowired
    SponsorRepository sponsorRepository;

    @Override
    public Optional<Sponsor> getById(Long id) {
        return sponsorRepository.findById(id);
    }

    @Override
    public List<Sponsor> getAll() {
        return sponsorRepository.findAll();
    }



    @Override
    public void delete(Long id) {
        Optional<Sponsor> sponsor = getById(id);
        sponsorRepository.delete(sponsor.get());
    }

    @Override
    public Sponsor save(Sponsor entity) {
        return sponsorRepository.save(entity);
    }

    @Override
    public List<Sponsor> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Sponsor getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return sponsorRepository.existsById(id);
    }

}
