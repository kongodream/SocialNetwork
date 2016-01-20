package com.gamenet.web;

import com.gamenet.domain.Data;
import com.gamenet.domain.Profile;
import com.gamenet.service.DataService;
import com.gamenet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ivan on 02.01.16.
 */
@Controller
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private DataService dataService;

    @Secured("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @RequestMapping("/profile/{personId}")
    public String showProfile(@PathVariable int personId, ModelMap model){
        Profile profile = profileService.getProfile(personId);
        Data userData = dataService.getDataFor(personId);
        model.addAttribute("profile", profile);
        model.addAttribute("userData", userData);
//        model.addAttribute("profile", person.getProfile());
        return "views/profile";
    }
}
