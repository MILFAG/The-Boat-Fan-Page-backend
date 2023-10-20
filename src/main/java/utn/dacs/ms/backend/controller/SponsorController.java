package utn.dacs.ms.backend.controller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.SponsorDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.Sponsor;
import utn.dacs.ms.backend.service.impl.SponsorServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/sponsors")
public class SponsorController {
    @Autowired
    SponsorServiceImpl sponsorService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<SponsorDTO>> getAll() {
        List<Sponsor> sponsors = sponsorService.getAll();
        List<SponsorDTO> data = sponsors.stream().map(sponsor -> modelMapper.map(sponsor, SponsorDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<SponsorDTO>>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SponsorDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Sponsor> sponsor = sponsorService.getById(id);

        if (sponsor.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        SponsorDTO data = modelMapper.map(sponsor.get(), SponsorDTO.class);
        return new ResponseEntity<SponsorDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<SponsorDTO> create(@RequestBody SponsorDTO sponsorDTO) {
        Sponsor sponsor = modelMapper.map(sponsorDTO, Sponsor.class);
        SponsorDTO data = modelMapper.map(sponsorService.save(sponsor), SponsorDTO.class);
        return new ResponseEntity<SponsorDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<SponsorDTO> update(@RequestBody SponsorDTO sponsorDTO) throws ResourceNotFoundException {

        if (sponsorDTO.getId() == null || !sponsorService.existById(sponsorDTO.getId())) {
            throw new ResourceNotFoundException("");
        }

        Sponsor sponsor = modelMapper.map(sponsorDTO, Sponsor.class);
        SponsorDTO data = modelMapper.map(sponsorService.save(sponsor), SponsorDTO.class);
        return new ResponseEntity<SponsorDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !sponsorService.existById(id)) {
            throw new ResourceNotFoundException("");
        }

        sponsorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
