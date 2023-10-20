package utn.dacs.ms.backend.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.NivelSponsorDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.NivelSponsor;
import utn.dacs.ms.backend.service.impl.NivelSponsorServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/nivelesSponsor")
public class NivelSponsorController {
    @Autowired
    NivelSponsorServiceImpl nivelSponsorService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<NivelSponsorDTO>> getAll() {
        List<NivelSponsor> nivelesSponsor = nivelSponsorService.getAll();
        List<NivelSponsorDTO> data = nivelesSponsor.stream().map(nivelSponsor -> modelMapper.map(nivelSponsor, NivelSponsorDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<NivelSponsorDTO>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NivelSponsorDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<NivelSponsor> nivelSponsor = nivelSponsorService.getById(id);

        if (nivelSponsor.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        NivelSponsorDTO data = modelMapper.map(nivelSponsor.get(), NivelSponsorDTO.class);
        return new ResponseEntity<NivelSponsorDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<NivelSponsorDTO> create(@RequestBody NivelSponsorDTO nivelSponsorDto) {
        NivelSponsor nivelSponsor = modelMapper.map(nivelSponsorDto, NivelSponsor.class);
        NivelSponsorDTO data = modelMapper.map(nivelSponsorService.save(nivelSponsor), NivelSponsorDTO.class);
        return new ResponseEntity<NivelSponsorDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<NivelSponsorDTO> update(@RequestBody NivelSponsorDTO nivelSponsorDto) throws ResourceNotFoundException {

        if (nivelSponsorDto.getId() == null || !nivelSponsorService.existById(nivelSponsorDto.getId())) {
            throw new ResourceNotFoundException("");
        }

        NivelSponsor nivelSponsor = modelMapper.map(nivelSponsorDto, NivelSponsor.class);
        NivelSponsorDTO data = modelMapper.map(nivelSponsorService.save(nivelSponsor), NivelSponsorDTO.class);
        return new ResponseEntity<NivelSponsorDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !nivelSponsorService.existById(id)) {
            throw new ResourceNotFoundException("");
        }

        nivelSponsorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
