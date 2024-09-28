package com.example.demo.service;
import com.example.demo.entity.Registration;
import com.example.demo.expection.ResourceNotFound;
import com.example.demo.payload.RegistrationDto;
import com.example.demo.reposetry.RegistrationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private RegistrationRepository repository;
    private static ModelMapper mapper;
    public RegistrationService(RegistrationRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RegistrationDto createData(RegistrationDto registration) {
        Registration save = repository.save(mapToEntity(registration));
       RegistrationDto dto = mapToDto(save);
        return dto ;
//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(registration.getName());
//        dto.setEmail(registration.getEmail());
//        dto.setMobile(registration.getMobile());

    }

    public List<RegistrationDto> getData() {
        List<Registration> all = repository.findAll();
        List<RegistrationDto> list = all.stream().map(r -> mapToDto(r)).toList();
        return list;
    }

    public void deleteData(long id) {
        repository.deleteById(id);
    }

    public Registration updateData(long id, Registration reg) {
        Registration registration = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Record is not here"));

        registration.setId(id);
        registration.setName(reg.getName());
        registration.setEmail(reg.getEmail());
        registration.setMobile(reg.getMobile());
        Registration save = repository.save(registration);
        return save;
    }
    Registration mapToEntity(RegistrationDto registrationDto){
        Registration registration= mapper.map(registrationDto , Registration.class);
    return  registration;
    }
    static RegistrationDto mapToDto(Registration registration){
      RegistrationDto registrationDto=  mapper.map(registration , RegistrationDto.class);
   return  registrationDto;
    }

    public RegistrationDto getRegisterById(long id) {
        Registration registration = repository.findById(id)

                .orElseThrow(
                        ()->new ResourceNotFound("Record not Found")
                );
        RegistrationDto registrationDto = mapToDto(registration);
        return registrationDto;
    }
}
