package com.gamenet.web;

import com.gamenet.domain.User;
import com.gamenet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ivan on 02.01.16.
 */
@Controller
@Secured("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/profile/{personId}", method = RequestMethod.GET)
    public String showProfile(@PathVariable int personId, ModelMap model){
        User user = userService.getUserById(personId);
        User currentUser = userService.getCurrentUser();

        model.addAttribute("user", user);

        model.addAttribute("currentUser", currentUser);

        model.addAttribute("profile", user.getProfile());
        model.addAttribute("userData", user.getData());
        return "views/profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showMyProfile(ModelMap model) {
        User user = userService.getCurrentUser();

        return "redirect:/profile/" + user.getId();
    }
}
