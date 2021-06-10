package com.example.kasper24timers.controller;

import com.example.kasper24timers.model.Kommune;
import com.example.kasper24timers.model.Sogn;
import com.example.kasper24timers.repository.KommuneRepository;
import com.example.kasper24timers.repository.SognRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SognController {

    @Autowired
    SognRepository sognRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Sogn> sogne = new ArrayList<>();
        sognRepository.findAll().forEach(sogne::add);
        model.addAttribute("sogne", sogne);
        return "index";
    }

    @GetMapping("/createSogn")
    public String createSogn(){
        return "createSogn";
    }

    @PostMapping("/createSogn")
    public String createSogn(WebRequest request){
        String name = request.getParameter("name");
        String strsmitteniveau = request.getParameter("smitteniveau");
        String nedlukningStart = request.getParameter("nedlukningStart");

        double smitteniveau = Double.parseDouble(strsmitteniveau);

        Sogn sogn = new Sogn(name, smitteniveau, nedlukningStart);

        sognRepository.save(sogn);
        return "redirect:/";


    }




}
