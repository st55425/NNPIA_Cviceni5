package cz.upce.nnpia_cv5.controller;

import cz.upce.nnpia_cv5.repository.CourtRepository;
import cz.upce.nnpia_cv5.service.ReservationService;
import cz.upce.nnpia_cv5.service.ReservationServiceImpl;
import cz.upce.nnpia_cv5.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class ReservationController {

    private final CourtRepository courtRepository;
    private final UserService userService;
    private final ReservationService reservationService;

    @GetMapping("/")
    public String showAllTrainingUnits(Model model){
        model.addAttribute("courts", courtRepository.findAll());
        model.addAttribute("reservation", userService.getToReservation());
        model.addAttribute("user", userService.getUser());
        return "to_reserve";
    }

    @GetMapping("/add/{id}")
    public String addToReservation(@PathVariable Long id, Model model){
        userService.addUnitToReservation(id);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeFromReservation(@PathVariable Long id, Model model){
        userService.removeUnitReservation(id);
        return "redirect:/";
    }

    @GetMapping("/my-reservations")
    public String showMyReservation(Model model){
        model.addAttribute("user", userService.getUser());
        model.addAttribute("reservations", reservationService.getUsersReservations(userService.getUser()));
        return "/my-reservations";
    }

    @GetMapping("/my-reservations/remove/{id}")
    public String removeReservation(@PathVariable Long id, Model model){
        reservationService.removeReservation(id);
        return "redirect:/my-reservations";
    }
}
