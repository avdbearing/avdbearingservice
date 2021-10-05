package com.avdbearing.controllers;


import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;
import com.avdbearing.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/supplier")

public class SupplierController {
    @Resource
    private SupplierService supplierService;

    @PostMapping("/create")
    public String createSupplier(@Valid SupplierCreateDto supplierCreateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "addSupplier";
        }

        supplierService.addSupplier(supplierCreateDto);
        System.out.println(supplierCreateDto);
        return "redirect:/supplier/all";
    }

    @GetMapping("/create")
    public ModelAndView createSupplier() {
        ModelAndView modelAndView = new ModelAndView("addSupplier");
        modelAndView.addObject("newSupplier", new SupplierCreateDto());

        return modelAndView;
    }

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("supplier");
        modelAndView.addObject("suppliers", supplierService.getAll());
        modelAndView.addObject("newSupplier", new SupplierCreateDto());


        System.out.println("all supplier");

        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable("id") Long id) {

        supplierService.deleteSupplierById(id);
        return "redirect:/supplier/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateSupplier(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updateSupplier");
        modelAndView.addObject("currentSupplier", supplierService.getSupplierById(id));

        return modelAndView;

    }

    @PostMapping("/update")

    public String updateSuppler(@ModelAttribute("currentSupplier") SupplierDto supplierDto) {

        supplierService.updateSupplier(supplierDto);

        return "redirect:/supplier/all";
    }


}
