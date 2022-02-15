package com.avdbearing.controllers;


import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.SupplierCreateDto;
import com.avdbearing.dto.SupplierDto;
import com.avdbearing.services.ContactService;
import com.avdbearing.services.SupplierService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/supplier")

public class SupplierController {
    @Resource
    private SupplierService supplierService;
    @Resource
    private ContactService contactService;

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
        modelAndView.addObject("contacts", contactService.getAll());
        modelAndView.addObject("newSupplier", new SupplierCreateDto());

        System.out.println("create inside");
        return modelAndView;
    }
//
//    @GetMapping("/all")
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("supplier");
//        modelAndView.addObject("suppliers", supplierService.getAll());
//        modelAndView.addObject("newSupplier", new SupplierCreateDto());
//
//
//        System.out.println("all supplier");
//
//        return modelAndView;
//    }

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
        Page<Supplier> page = supplierService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Supplier> suppliers = page.getContent();


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");


        model.addAttribute("suppliers", suppliers);

        return "supplier";
    }


}
