package com.avdbearing.controllers;

import com.avdbearing.domain.Enum.PartType;
import com.avdbearing.dto.PartCreateDto;
import com.avdbearing.dto.PartDto;
import com.avdbearing.services.PartService;
import com.avdbearing.services.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.stream.LongStream;


@Controller
@RequestMapping("/part")

public class PartController {
    @Resource
    private PartService partService;
    @Resource
    private SupplierService supplierService;

    @PostMapping("/create")
    public String createPart(@ModelAttribute("newPart") PartCreateDto partCreateDto) {
        partService.addPart(partCreateDto);
//        System.out.println(partCreateDto);
        return "redirect:/part/all";
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


        return modelAndView;

    }

    @PostMapping("/update")
    public String updatePart(@ModelAttribute("currentPart") PartDto partDto) {

        partService.updatePart(partDto);


        return "redirect:/part/all";
    }


//    @PostMapping(name = "/create")
//    protected void createPart(HttpServletRequest req, HttpServletResponse resp) {
//        String article = req.getParameter("article");
//        String brand = req.getParameter("brand");
//        String description = req.getParameter("description");
//        String price = req.getParameter("price");
//        String type = req.getParameter("type");
//        String inner = req.getParameter("inner");
//        String outer = req.getParameter("outer");
//        String width = req.getParameter("width");
//        String supplier = req.getParameter("supplier");
//
//
//        PartDto partDto = new PartDto(inner, outer, width, article,
//                brand, description, price, type, supplier);
//
//        System.out.println(partDto);
//    }
}
