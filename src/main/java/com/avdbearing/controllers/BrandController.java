package com.avdbearing.controllers;


import com.avdbearing.dto.BrandCreateDto;
import com.avdbearing.dto.BrandDto;
import com.avdbearing.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    @PostMapping("/create")
    public String createBrand(@Valid BrandCreateDto brandCreateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "addBrand";
        }

        brandService.addBrand(brandCreateDto);
        System.out.println(brandCreateDto);
        return "redirect:/brand/all";
    }
    @GetMapping("/create")
    public ModelAndView createBrand() {
        ModelAndView modelAndView = new ModelAndView("addBrand");
        modelAndView.addObject("brands", brandService.getAll());
        modelAndView.addObject("newBrand", new BrandCreateDto());


        System.out.println("/create inside");
        return modelAndView;

    }

    @GetMapping("/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("brands");
        modelAndView.addObject("newBrand", new BrandCreateDto());
        modelAndView.addObject("brands", brandService.getAll());


        System.out.println("get all done");

        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public String deleteBrand(@PathVariable("id") Long id) {

        brandService.deleteBrandById(id);


        return "redirect:/brand/all";
    }
    @GetMapping("/update/{id}")
    public ModelAndView updateBrand(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updatePart");
        modelAndView.addObject("currentBrand", brandService.getBrandById(id));


        return modelAndView;

    }
    @PostMapping("/update")
    public String updateBrand(@Valid BrandDto brandDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());
            return "redirect:/brand/update/" + brandDto.getId();
        }

        brandService.updateBrand(brandDto);


        return "redirect:/brand/all";
    }


}
