package cz.upce.nnpia_cv5.controller;

import cz.upce.nnpia_cv5.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class CheckoutController {

    private final UserService userService;
    private final CheckoutService checkoutService;
    private final ReservationService reservationService;

    @GetMapping("/reserve")
    public String reserve(Model model){
        model.addAttribute("user", userService.getUser());
        model.addAttribute("courts", reservationService.getSortedReservation(userService.getToReservation()));
        return "/reserve";
    }

    @GetMapping("/reserve/remove/{id}")
    public String removeFromReservation(@PathVariable Long id, Model model){
        userService.removeUnitReservation(id);
        return "redirect:/reserve";
    }

    @GetMapping("/reserve/checkout")
    public String checkout(Model model){
        checkoutService.saveReservation();
        return "redirect:/";
    }

}
