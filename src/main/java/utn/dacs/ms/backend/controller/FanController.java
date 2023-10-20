package utn.dacs.ms.backend.controller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utn.dacs.ms.backend.dto.FanDTO;
import utn.dacs.ms.backend.exceptions.ResourceNotFoundException;
import utn.dacs.ms.backend.model.entity.Fan;
import utn.dacs.ms.backend.service.impl.FanServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping(value = "/fans")
public class FanController {
    @Autowired
    FanServiceImpl fanService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<FanDTO>> getAll() {
        List<Fan> fans = fanService.getAll();
        List<FanDTO> data = fans.stream().map(fan -> modelMapper.map(fan, FanDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<List<FanDTO>>(data, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FanDTO> getById(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Optional<Fan> fan = fanService.getById(id);
        if (fan.isEmpty()) {
            throw new ResourceNotFoundException("");
        }
        FanDTO data = modelMapper.map(fan.get(), FanDTO.class);
        return new ResponseEntity<FanDTO>(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<FanDTO> create(@RequestBody FanDTO fanDTO) {
        Fan fan = modelMapper.map(fanDTO, Fan.class);
        FanDTO data = modelMapper.map(fanService.save(fan), FanDTO.class);
        return new ResponseEntity<FanDTO>(data, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<FanDTO> update(@RequestBody FanDTO fanDTO) throws ResourceNotFoundException {

        if (fanDTO.getId() == null || !fanService.existById(fanDTO.getId())) {
            throw new ResourceNotFoundException("");
        }

        Fan alumno = modelMapper.map(fanDTO, Fan.class);
        FanDTO data = modelMapper.map(fanService.save(alumno), FanDTO.class);
        return new ResponseEntity<FanDTO>(data, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {

        if (id == null || !fanService.existById(id)) {
            throw new ResourceNotFoundException("");
        }

        fanService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
