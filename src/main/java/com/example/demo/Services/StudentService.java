package com.example.demo.Services;

import com.example.demo.DTOs.StudentDTO;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.configs.ApplicationModelMapper;
import com.example.demo.entities.StudentEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@Service
@Getter
@Setter
public class StudentService {
// i need jpa classs so that i have many methods and implementations , and jpa class is defined where ? IN repository Right
    // Now create an instance for repository class and do construction injections here
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    private final ModelMapper modelMapper;


    // Entity me hm tabel banate hai DB ke liye aur us table ko pass akr dete hai kaha par Respositry me correct
    // Now define that method where you want to call, in presentation layer
    public StudentDTO getStudentByID(Long ID)
    {
        StudentEntity studentEntity=studentRepository.findById(ID).orElse(null);
       return modelMapper.map(studentEntity,StudentDTO.class);
    }
    public StudentDTO createNewEntity(StudentDTO studentDTO)
    {
        StudentEntity convertTOstudentEntity=modelMapper.map(studentDTO,StudentEntity.class);
        StudentEntity saveEntity=studentRepository.save(convertTOstudentEntity);
        return modelMapper.map(saveEntity,StudentDTO.class);

//        return studentRepository.save(); // it will not save bcz it expect entity not dto
    }
}
