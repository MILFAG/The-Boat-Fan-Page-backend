package utn.dacs.ms.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.PartidaDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.Partida;
import utn.dacs.ms.backend.service.impl.PartidaServiceImpl;
import utn.dacs.ms.backend.service.interfaces.PartidaService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/partidas")
public class PartidaController {
    @Autowired
    PartidaServiceImpl partidaService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<PartidaDTO>> getAll() {
        List<Partida> partidas = partidaService.getAll();
        List<PartidaDTO> data = partidas.stream().map(partida -> modelMapper.map(partida, PartidaDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<PartidaDTO>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Partida> partida = partidaService.getById(id);

        if (partida.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        PartidaDTO data = modelMapper.map(partida.get(), PartidaDTO.class);
        return new ResponseEntity<PartidaDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<PartidaDTO> create(@RequestBody PartidaDTO partidaDTO) {
        Partida partida = modelMapper.map(partidaDTO, Partida.class);
        PartidaDTO data = modelMapper.map(partidaService.save(partida), PartidaDTO.class);
        return new ResponseEntity<PartidaDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<PartidaDTO> update(@RequestBody PartidaDTO partidaDTO) throws ResourceNotFoundException {

        if (partidaDTO.getId() == null || !partidaService.existById(partidaDTO.getId())) {
            throw new ResourceNotFoundException("");
        }

        Partida partida = modelMapper.map(partidaDTO, Partida.class);
        PartidaDTO data = modelMapper.map(partidaService.save(partida), PartidaDTO.class);
        return new ResponseEntity<PartidaDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !partidaService.existById(id)) {
            throw new ResourceNotFoundException("");
        }

        partidaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
