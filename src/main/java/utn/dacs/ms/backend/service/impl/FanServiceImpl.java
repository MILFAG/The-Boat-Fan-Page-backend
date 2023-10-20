package utn.dacs.ms.backend.service.impl;
import org.springframework.stereotype.Service;
import utn.dacs.ms.backend.model.entity.Alumno;
import utn.dacs.ms.backend.model.entity.Fan;
import utn.dacs.ms.backend.model.repository.FanRepository;
import utn.dacs.ms.backend.service.interfaces.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class FanServiceImpl implements FanService {
    @Autowired
    FanRepository fanRepository;

    @Override
    public Optional<Fan> getById(Long id) {
        return fanRepository.findById(id);
    }

    @Override
    public List<Fan> getAll() {
        return fanRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Optional<Fan> fan = getById(id);
        fanRepository.delete(fan.get());
    }

    @Override
    public Fan save(Fan entity) {
        return fanRepository.save(entity);
    }

    @Override
    public List<Fan> find(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Fan getBy(Map<String, Object> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Boolean existById(Long id) {
        return fanRepository.existsById(id);
    }
}
