package com.avdbearing.controllers;

import com.avdbearing.domain.Enum.UserRole;
import com.avdbearing.domain.Enum.UserStatus;
import com.avdbearing.domain.User;
import com.avdbearing.dto.UserCreateDto;
import com.avdbearing.dto.UserDto;
import com.avdbearing.services.UserService;
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
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/create")
    public String createUser(@Valid UserCreateDto userCreateDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("error: " + bindingResult.getFieldError().getField());

            return "addUser";

        }

        userService.addUser(userCreateDto);
        System.out.println(userCreateDto);
        return "redirect:/user/all";
    }

    @GetMapping("/create")
    public ModelAndView createUser() {
        ModelAndView modelAndView = new ModelAndView("addUser");
        modelAndView.addObject("userRole" , UserRole.values());
        modelAndView.addObject("userStatus" , UserStatus.values());
        modelAndView.addObject("newUser", new UserCreateDto());


        System.out.println("create inside");
        return modelAndView;
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.deleteUserById(id);
        return "redirect:/user/all";
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateUser(@PathVariable("id") Long id) {

        ModelAndView modelAndView = new ModelAndView("updateUser");
        modelAndView.addObject("currentUser", userService.getUserById(id));

        return modelAndView;

    }

    @PostMapping("/update")

    public String updateUser(@ModelAttribute("currentUser") UserDto userDto) {

        userService.updateUser(userDto);

        return "redirect:/user/all";
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
        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> users = page.getContent();


        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");


        model.addAttribute("users", users);

        return "user";
    }


}


