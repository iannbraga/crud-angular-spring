package io.iannbraga.crudspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.iannbraga.crudspring.model.CourseModel;
import io.iannbraga.crudspring.repository.CourseRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
//Cria os construtores
@AllArgsConstructor
public class CourseController {
     
    private CourseRepository courseRepository;

    @GetMapping
    public List<CourseModel> list(){
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public CourseModel findById(@PathVariable Long id){
        return courseRepository.findById(id).orElseThrow();
    }
    
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseModel create(@RequestBody CourseModel newCourse){
        return courseRepository.save(newCourse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public CourseModel update(@RequestBody CourseModel newCourse, @PathVariable Long id){
        return courseRepository.save(newCourse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String deleteById(@PathVariable Long id){
        courseRepository.delete(findById(id));
        return "Deletado";
    }

}
