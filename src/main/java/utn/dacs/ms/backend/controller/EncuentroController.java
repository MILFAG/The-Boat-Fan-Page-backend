package utn.dacs.ms.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.EncuentroDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.Encuentro;
import utn.dacs.ms.backend.service.impl.EncuentroServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/encuentros")
public class EncuentroController {
    @Autowired
    EncuentroServiceImpl encuentroService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<EncuentroDTO>> getAll() {
        List<Encuentro> encuentros = encuentroService.getAll();
        List<EncuentroDTO> data = encuentros.stream().map(encuentro -> modelMapper.map(encuentro, EncuentroDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<EncuentroDTO>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncuentroDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Encuentro> encuentro = encuentroService.getById(id);

        if (encuentro.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        EncuentroDTO data = modelMapper.map(encuentro.get(), EncuentroDTO.class);
        return new ResponseEntity<EncuentroDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<EncuentroDTO> create(@RequestBody EncuentroDTO encuentroDTO) {
        Encuentro encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        EncuentroDTO data = modelMapper.map(encuentroService.save(encuentro), EncuentroDTO.class);
        return new ResponseEntity<EncuentroDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<EncuentroDTO> update(@RequestBody EncuentroDTO encuentroDTO) throws ResourceNotFoundException {

        if (encuentroDTO.getId() == null || !encuentroService.existById(encuentroDTO.getId())) {
            throw new ResourceNotFoundException("");
        }

        Encuentro encuentro = modelMapper.map(encuentroDTO, Encuentro.class);
        EncuentroDTO data = modelMapper.map(encuentroService.save(encuentro), EncuentroDTO.class);
        return new ResponseEntity<EncuentroDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !encuentroService.existById(id)) {
            throw new ResourceNotFoundException("");
        }

        encuentroService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
