package com.avdbearing.controllers;

import com.avdbearing.domain.Client;
import com.avdbearing.domain.Enum.UserStatus;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.ClientCreateDto;
import com.avdbearing.dto.ClientDto;
import com.avdbearing.dto.search.SearchDto;
import com.avdbearing.services.ClientService;
import com.avdbearing.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/client")

public class ClientController {

    @Resource
    private ClientService clientService;


    @PostMapping("/create")
    public String createClient(@Valid ClientCreateDto newClient, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "addClient";
        }

        clientService.addClient(newClient);
        System.out.println(newClient);
        return "redirect:/client/all";
    }

    @GetMapping("/create")
    public ModelAndView createClient() {

        ModelAndView modelAndView = new ModelAndView("addClient");
        modelAndView.addObject("newClient", new ClientCreateDto());
        modelAndView.addObject("type", UserStatus.values());

        System.out.println("/create inside");
        return modelAndView;
    }


//    @GetMapping("/all")
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("client");
//        modelAndView.addObject("clients", clientService.getAll());
//        modelAndView.addObject("newClient", new ClientCreateDto());
//        modelAndView.addObject("type", UserStatus.values());
//
//        System.out.println("all clients");
//
//        return modelAndView;
//    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") Long id) {

        clientService.deleteClientById(id);
        return "redirect:/client/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateClient(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updateClient");
        modelAndView.addObject("currentClient", clientService.getClientById(id));
        modelAndView.addObject("types", UserStatus.values());

        return modelAndView;

    }

    @PostMapping("/update")

    public String updateClient(@ModelAttribute("currentClient") ClientDto clientDto) {

        clientService.updateClient(clientDto);

        return "redirect:/client/all";
    }
    @GetMapping(value = "/all")
    public String viewIndexPage() {

        return "redirect:page/1?sort-field=id&sort-dir=asc";
    }

    @GetMapping(value = "/page/{page-number}")
    public String findPaginated(@PathVariable(name = "page-number") int pageNo,
                                @RequestParam(name = "sort-field") String sortField,
                                @RequestParam(name = "sort-dir") String sortDir,
                                Model model) {

        int pageSize = 10;
        Page<Client> page = clientService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Client> clients = page.getContent();

        SearchDto searchDto = new SearchDto();
        searchDto.setFields(Arrays.asList("Phone", "Second name"));


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("clients", clients);
        model.addAttribute("search", searchDto);

        return "client";
    }

}
