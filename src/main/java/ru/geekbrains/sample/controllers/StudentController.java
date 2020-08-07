package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.geekbrains.sample.dao.StudentRepository;
import ru.geekbrains.sample.dto.StudentDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }

    @PostMapping
    public void sendForm(@RequestBody StudentDTO studentDTO) {
        studentRepository.save(studentDTO);
    }

}
