package utn.dacs.ms.backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.Encuentro;
import utn.dacs.ms.backend.model.repository.EncuentroRepository;
import utn.dacs.ms.backend.service.interfaces.EncuentroService;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EncuentroServiceImpl implements EncuentroService {
    @Autowired
    EncuentroRepository encuentroRepository;
    @Override
    public Optional<Encuentro> getById(Long id) {
        return encuentroRepository.findById(id);
    }

    @Override
    public List<Encuentro> getAll() {
        return encuentroRepository.findAll();
    }

    public List<Encuentro> getProximos(){
        return encuentroRepository.findAll().stream().filter(encuentro -> encuentro.getFecha().compareTo(new Date())>=0).toList();
    }


    @Override
    public void delete(Long id) {
        Optional<Encuentro> encuentro = getById(id);
        encuentroRepository.delete(encuentro.get());
    }

    @Override
    public Encuentro save(Encuentro entity) {
        return encuentroRepository.save(entity);
    }

    @Override
    public List<Encuentro> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Encuentro getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return encuentroRepository.existsById(id);
    }
}
