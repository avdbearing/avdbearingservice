package com.avdbearing.controllers;

import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;
import com.avdbearing.services.PartService;
import com.avdbearing.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;


@Controller
@RequestMapping("/part")

public class PartController {
    @Resource
    private PartService partService;
    @Resource
    private SupplierService supplierService;

    @PostMapping("/create")
    public String createPart(@Valid PartCreateDto partCreateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "addPart";
        }

        partService.addPart(partCreateDto);
        System.out.println(partCreateDto);
        return "redirect:/part/all";
    }


    @GetMapping("/create")
    public ModelAndView createPart() {
        ModelAndView modelAndView = new ModelAndView("addPart");
        modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("newPart", new PartCreateDto());
        modelAndView.addObject("partTypes", PartType.values());

        System.out.println("/create inside");
        return modelAndView;

    }


    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("parts");
        modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("newPart", new PartCreateDto());
        modelAndView.addObject("parts", partService.getAll());
        modelAndView.addObject("partTypes", PartType.values());


        System.out.println("get all done");

        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable("id") Long id) {

        partService.deletePartById(id);


        return "redirect:/part/all";
    }


    @GetMapping("/update/{id}")
    public ModelAndView updatePart(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updatePart");
        modelAndView.addObject("currentPart", partService.getPartById(id));
        modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("partTypes", PartType.values());

        return modelAndView;

    }

    @PostMapping("/update")
    public String updatePart(@Valid PartDto partDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "redirect:/part/update/" + partDto.getId();
        }

        partService.updatePart(partDto);


        return "redirect:/part/all";
    }


}
