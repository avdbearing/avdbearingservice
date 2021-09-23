package com.avdbearing.controllers;

import com.avdbearing.domain.Enum.UserStatus;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.ClientDto;
import com.avdbearing.services.ClientService;
import com.avdbearing.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/client")

public class ClientController {

    @Resource
    private ClientService clientService;



    @PostMapping("/create")
    public String createClient(@ModelAttribute("newClient") ClientCreateDto clientCreateDto) {
        clientService.addClient(clientCreateDto);
        System.out.println(clientCreateDto);
        return "redirect:/client/all";
    }

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("client");
        modelAndView.addObject("clients", clientService.getAll());
        modelAndView.addObject("newClient", new ClientCreateDto());



        System.out.println("all clients");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {

        clientService.deleteClientById(id);
        return "redirect:/client/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateClient(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updateClient");
        modelAndView.addObject("currentClient", clientService.getClientById(id));

        return modelAndView;

    }

    @PostMapping("/update")

    public String updateClient(@ModelAttribute("currentClient") ClientDto clientDto) {

        clientService.updateClient(clientDto);

        return "redirect:/client/all";
    }


}
