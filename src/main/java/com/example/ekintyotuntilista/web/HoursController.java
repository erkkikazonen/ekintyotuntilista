package com.example.ekintyotuntilista.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ekintyotuntilista.domain.Hours;
import com.example.ekintyotuntilista.domain.HoursRepository;
import com.example.ekintyotuntilista.domain.JobRepository;

@Controller
public class HoursController {

    @Autowired
    private HoursRepository hrepository;

    @Autowired
    private JobRepository jrepository;

    @RequestMapping(value="/login")
    public String login() {    
        return "login";
    }

    @GetMapping("/hourslist")
    public String hourslist(Model model) {
        List<Hours> allHours = (List<Hours>) hrepository.findAll();
        model.addAttribute("hours", allHours);

        Integer totalEarnings = hrepository.getTotalEarnings();
        if (totalEarnings == null) {
            totalEarnings = 0;
        }
        model.addAttribute("totalEarnings", totalEarnings);

        return "hourslist";
    }

    @RequestMapping(value = "/hours", method = RequestMethod.GET)
    public @ResponseBody List<Hours> hoursListRest() {
        return (List<Hours>) hrepository.findAll();
    }

    @RequestMapping(value = "/hours/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Hours> findHoursRest(@PathVariable("id") Long hoursId) {
        return hrepository.findById(hoursId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addHours(Model model) {
        model.addAttribute("hours", new Hours());
        model.addAttribute("jobs", jrepository.findAll());
        return "addhours";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Hours hours) {
        hrepository.save(hours);
        return "redirect:hourslist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteHours(@PathVariable("id") Long hoursId, Model model) {
        hrepository.deleteById(hoursId);
        return "redirect:/hourslist";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editHours(@PathVariable("id") Long hoursId, Model model) {
        model.addAttribute("hours", hrepository.findById(hoursId));
        model.addAttribute("jobs", jrepository.findAll());
        return "edithours";
    }
}
