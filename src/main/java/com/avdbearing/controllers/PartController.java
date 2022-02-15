package com.avdbearing.controllers;

import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.domain.core.Brand;
import com.avdbearing.domain.core.Part;
import com.avdbearing.domain.core.Supplier;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;
import com.avdbearing.services.BrandService;
import com.avdbearing.services.PartService;
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
@RequestMapping("/part")

public class PartController {
    @Resource
    private PartService partService;
    @Resource
    private SupplierService supplierService;
    @Resource
    private BrandService brandService;


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
        modelAndView.addObject("brands", brandService.getAll());
        modelAndView.addObject("newPart", new PartCreateDto());
        modelAndView.addObject("partTypes", PartType.values());

        System.out.println("/create inside");
        return modelAndView;

    }


//    @GetMapping("/all")
//    public ModelAndView getAll() {
//        ModelAndView modelAndView = new ModelAndView("parts");
//        modelAndView.addObject("suppliers", supplierService.getAll());
//        modelAndView.addObject("brands", brandService.getAll());
//        modelAndView.addObject("newPart", new PartCreateDto());
//        modelAndView.addObject("parts", partService.getAll());
//        modelAndView.addObject("partTypes", PartType.values());
//
//
//        System.out.println("get all done");
//
//        return modelAndView;
//    }


    @GetMapping("/delete/{id}")
    public String deletePart(@PathVariable("id") Long id) {

        partService.deletePartById(id);


        return "redirect:/part/all";
    }


    @GetMapping("/update/{id}")
    public ModelAndView updatePart(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updatePart");
        modelAndView.addObject("currentPart", partService.getPartById(id));
        modelAndView.addObject("brands", brandService.getAll());
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
        Page<Part> page = partService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Part> parts = page.getContent();


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");



        model.addAttribute("parts", parts);

        return "parts";
    }


}
