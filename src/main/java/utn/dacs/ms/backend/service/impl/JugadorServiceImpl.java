package utn.dacs.ms.backend.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.Jugador;
import utn.dacs.ms.backend.model.repository.JugadorRepository;
import utn.dacs.ms.backend.service.interfaces.JugadorSerivce;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorSerivce {
    @Autowired
    JugadorRepository jugadorRepository;
    @Override
    public Optional<Jugador> getById(Long id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public List<Jugador> getAll() {
        return jugadorRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Jugador> jugador = getById(id);
        jugadorRepository.delete(jugador.get());
    }

    @Override
    public Jugador save(Jugador entity) {
        return jugadorRepository.save(entity);
    }

    @Override
    public List<Jugador> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Jugador getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return jugadorRepository.existsById(id);
    }
}
