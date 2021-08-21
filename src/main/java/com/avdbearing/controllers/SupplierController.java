package com.avdbearing.controllers;


import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/supplier")

public class SupplierController {
    @Resource
    private SupplierService supplierService;

    @PostMapping("/create")
    public void createSupplier(@RequestBody SupplierCreateDto supplierCreateDto) {
        System.out.println(supplierCreateDto);
    }

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("supplier");
        modelAndView.addObject("suppliers", supplierService.getAll());

        System.out.println("all supplier");

        return modelAndView;
    }





}
