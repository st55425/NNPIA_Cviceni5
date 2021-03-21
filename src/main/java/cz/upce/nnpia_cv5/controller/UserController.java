package cz.upce.nnpia_cv5.controller;

import cz.upce.nnpia_cv5.dto.UserDto;
import cz.upce.nnpia_cv5.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/logout")
    public String logout(Model model){
        userService.setUser(null);
        model.addAttribute("user", userService.getUser());
        return "redirect:/";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("login", new UserDto());
        return "login";
    }

    @PostMapping("/login-process")
    public String loginProcess(UserDto userDto, Model model){
        if (userService.loginUser(userDto)){
            model.addAttribute("user", userService.getUser());
            return "redirect:/";
        }
        return "redirect:/login";
    }

    @GetMapping("/sign-up")
    public String showSingUpPage(Model model){
        model.addAttribute("signup", new UserDto());
        return "/sign-up";
    }

    @PostMapping("/sing-up-process")
    public String signUpProcess(UserDto userDto, Model model){
        if (userService.createUser(userDto)){
            model.addAttribute("user", userService.getUser());
            return "redirect:/";
        }
        return "redirect:/sign-up";
    }

}
