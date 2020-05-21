package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    ArrayList<Customer> customers = new ArrayList<>();
    Customer customer = new Customer();
    @GetMapping("/form")
    public String loadFormPage(Model model) {
        model.addAttribute("customer", customer);
        return "form";
    }

    @PostMapping("/confirmform")
    public String processForm(@ModelAttribute Customer customer, Model model) {
        this.customer = customer;
        System.out.println(this.customer.toString());
        model.addAttribute("customer", customer);
        return "form2";

    }

    @GetMapping("/form2")
    public String loadForm2(Model model) {
        model.addAttribute("customer", customer);
        return "form2";
    }

    @PostMapping("/home")
    public String processFinalForm(@ModelAttribute Customer customer, Model model) {
        System.out.println(this.customer.toString());
        this.customer.getPet().setBreed(customer.getPet().getBreed());
        customers.add(this.customer);
        model.addAttribute("customers", customers);
        return "home";
    }

}
