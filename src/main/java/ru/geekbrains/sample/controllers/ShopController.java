package ru.geekbrains.sample.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ru.geekbrains.sample.persistence.entities.Shopuser;
import ru.geekbrains.sample.services.BookService;
import ru.geekbrains.sample.services.SchoolService;
import ru.geekbrains.sample.services.ShopuserService;

import java.security.Principal;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ShopController {

    private final BookService bookService;
    private final SchoolService schoolService;
    private final ShopuserService shopuserService;

    @GetMapping("/")
    public String getIndexPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/schools/{id}")
    public void getSchools(@PathVariable String id) {
        schoolService.getAllSchoolModels(UUID.fromString(id));
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/profile")
    public String profilePage(Model model, Principal principal) {

        if (principal == null) {
            return "redirect:/";
        }

        Shopuser shopuser = shopuserService.findByLogin(principal.getName());

        model.addAttribute("shopuser", shopuser);

        return "profile";

    }


}