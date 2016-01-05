package com.gamenet.web;

import com.gamenet.domain.Data;
import com.gamenet.domain.Person;
import com.gamenet.domain.Profile;
import com.gamenet.service.DataService;
import com.gamenet.service.PersonService;
import com.gamenet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ivan on 02.01.16.
 */
@Controller
public class ProfileController {

    @Autowired
    private PersonService personService;


    @RequestMapping("/profile/{personId}")
    public String showProfile(@PathVariable int personId,ModelMap model){
        Person person = personService.getPersonById(personId);
        model.addAttribute("person", person);
        model.addAttribute("data", person.getData());
        model.addAttribute("profile", person.getProfile());
        return "views/profile";
    }
}
