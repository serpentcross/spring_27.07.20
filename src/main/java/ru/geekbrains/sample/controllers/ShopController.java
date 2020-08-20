package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.sample.services.BookService;
import ru.geekbrains.sample.services.SchoolService;

import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ShopController {

    public final BookService bookService;
    public final SchoolService schoolService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/schools/{id}")
    public void getSchools(@PathVariable String id) {
        schoolService.getAllSchoolModels(UUID.fromString(id));
    }


}