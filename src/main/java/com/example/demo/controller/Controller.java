package com.example.demo.controller;

import com.example.demo.entity.Registration;
import com.example.demo.payload.RegistrationDto;
import com.example.demo.reposetry.RegistrationRepository;
import com.example.demo.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/registration")
public class Controller {


    private RegistrationService service;
    private final RegistrationRepository registrationRepository;

    public Controller(RegistrationService service,
                      RegistrationRepository registrationRepository) {
        this.service = service;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public ResponseEntity<?> createReg(
            @Valid @RequestBody RegistrationDto registration ,
            BindingResult result
    ){
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream()
                    .map(FieldError::getDefaultMessage)
                    .collect(Collectors.toList());

            // Return the list of error messages
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }
        RegistrationDto data = service.createData(registration);
        return  new ResponseEntity<>(data , HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<RegistrationDto>> getAllData(){
        List<RegistrationDto> data = service.getData();
        return new ResponseEntity<>(data , HttpStatus.OK);
    }

    @DeleteMapping
    public  ResponseEntity<String> deleteReg(@RequestParam long id){
        service.deleteData(id);
        return  new ResponseEntity<>("delete" , HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateReg(@PathVariable long id , @RequestBody Registration reg){
        service.updateData(id , reg);
        return  new ResponseEntity<>(reg , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegById(@PathVariable long id){
      RegistrationDto dto=  service.getRegisterById(id);
        return  new ResponseEntity<>(dto , HttpStatus.OK);
    }
}
