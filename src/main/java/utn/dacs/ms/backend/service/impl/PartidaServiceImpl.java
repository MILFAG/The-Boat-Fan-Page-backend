package utn.dacs.ms.backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.Partida;
import utn.dacs.ms.backend.model.repository.PartidaRepository;
import utn.dacs.ms.backend.service.interfaces.PartidaService;

import javax.servlet.http.Part;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PartidaServiceImpl implements PartidaService {
    @Autowired
    PartidaRepository partidaRepository;
    @Override
    public Optional<Partida> getById(Long id) {
        return partidaRepository.findById(id);
    }

    @Override
    public List<Partida> getAll() {
        return partidaRepository.findAll();
    }



    @Override
    public void delete(Long id) {
        Optional<Partida> partida = getById(id);
        partidaRepository.delete(partida.get());
    }

    @Override
    public Partida save(Partida entity) {
        return partidaRepository.save(entity);
    }

    @Override
    public List<Partida> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Partida getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return partidaRepository.existsById(id);
    }
}
