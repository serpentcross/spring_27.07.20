package ru.geekbrains.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.geekbrains.sample.dto.Student;

@Controller
public class MainController {

   @GetMapping("/")
   public String getIndexPage() {
      return "index";
   }

    @GetMapping("/students")
    public String getStudentPage() {
        //чтобы вывести список студентов нужно добавить бин StudentsRepository положить данные в Model
        return "student";
    }

    @PostMapping("/students")
    public String sendForm(@ModelAttribute Student student) {
        System.out.println(student);
        return "redirect:/";
    }

}