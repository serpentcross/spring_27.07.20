package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.geekbrains.sample.dao.StudentRepository;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final StudentRepository studentRepository;

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentRepository.findAllStudents());
        return "student";
    }

//    @PostMapping("/students")
//    public String sendForm(@ModelAttribute Student student) {
//        System.out.println(student);
//        return "redirect:/";
//    }

}