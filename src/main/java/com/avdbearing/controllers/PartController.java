package com.avdbearing.controllers;

import com.avdbearing.dto.PartCreateDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/part")

public class PartController  {

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

    @PostMapping("/create")
    public void createPart(@RequestBody PartCreateDto partCreateDto) {

        System.out.println(partCreateDto);
    }


    @GetMapping( "/all")
    public void getAll(){
        System.out.println("get all done");
    }


}
