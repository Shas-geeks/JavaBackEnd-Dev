package com.example.demo.controllers;

import com.example.demo.DTOs.StudentDTO;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.Services.StudentService;
import com.example.demo.entities.StudentEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
//    private  final StudentRepository studentRepository;
//    public StudentController(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }
    private final StudentService studentService;  // cereate instance of student service class
    public StudentController(StudentService studentService)
    {
        this.studentService=studentService;
    }

//    @GetMapping("student/detail")
//    public StudentDTO GetDetails(){
//        return new StudentDTO(10L,"Shashank",22,"shashank@gmail.com");
//    }

    @PostMapping("student/regform")
    public StudentDTO registerStudent (@RequestBody StudentDTO studentDTO)
    {

                studentDTO.setId(100L);
                studentDTO.setName("Ashwin");
                studentDTO.setEmail("Ashwin@gmail.com");
                return studentDTO;
    }
    // Controller -> presentation =====> Service LAYER (bRIDGE) ====> PERSISTANCE laYER (REPOSITORY)
    // findbyID method expect the student wrapper class that is entity or the obj
    // @requestParam jab URL ke saath compulsary parameter bhejna hoo
    @GetMapping("/student/{ID}")
    public StudentDTO getStudentByID(@PathVariable Long ID)
    {
        return studentService.getStudentByID(ID);
    }
    // Create A student Details
    // Jab poora ek saath jason me response bhejna ho to use => @RequestBody
    @PostMapping("student/createData")
    public StudentDTO createNewEntity(@RequestBody StudentDTO studentDTO)
    {
        return studentService.createNewEntity(studentDTO);
    }
}
