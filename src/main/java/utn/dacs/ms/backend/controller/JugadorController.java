package utn.dacs.ms.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.JugadorDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.Jugador;
import utn.dacs.ms.backend.service.impl.JugadorServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/jugadores")
public class JugadorController {
    @Autowired
    JugadorServiceImpl jugadorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<JugadorDTO>> getAll() {
        List<Jugador> jugadores = jugadorService.getAll();
        List<JugadorDTO> data = jugadores.stream().map(jugador -> modelMapper.map(jugador, JugadorDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<JugadorDTO>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Jugador> jugador = jugadorService.getById(id);

        if (jugador.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        JugadorDTO data = modelMapper.map(jugador.get(), JugadorDTO.class);
        return new ResponseEntity<JugadorDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<JugadorDTO> create(@RequestBody JugadorDTO jugadorDTO) {
        Jugador jugador = modelMapper.map(jugadorDTO, Jugador.class);
        JugadorDTO data = modelMapper.map(jugadorService.save(jugador), JugadorDTO.class);
        return new ResponseEntity<JugadorDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<JugadorDTO> update(@RequestBody JugadorDTO jugadorDTO) throws ResourceNotFoundException {

        if (jugadorDTO.getId() == null || !jugadorService.existById(jugadorDTO.getId())) {
            throw new ResourceNotFoundException("");
        }
        Jugador jugador = modelMapper.map(jugadorDTO, Jugador.class);
        JugadorDTO data = modelMapper.map(jugadorService.save(jugador), JugadorDTO.class);
        return new ResponseEntity<JugadorDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !jugadorService.existById(id)) {
            throw new ResourceNotFoundException("");
        }
        jugadorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
