package com.gamenet.web;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import com.gamenet.service.FriendInviteService;
import com.gamenet.service.UserService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ivan on 21.01.16.
 */
@Controller
@Secured("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
public class FriendshipController {

    @Autowired
    private FriendInviteService friendInviteService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/requestForFriendship", method = RequestMethod.POST)
    public String requestForFriendship(@RequestBody String userId) {

        int id = Integer.parseInt(getValueByJSONParam(userId, "userId"));
        System.out.println("GET! "+id);
        friendInviteService.requestForFriendship(userService.getCurrentUser(), userService.getUserById(id));
        return "";
    }

    private String getValueByJSONParam(String jsonString, String parameter) {
        JSONParser parser = new JSONParser();

        Object obj = null;
        try {
            obj = parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) obj;
        String value = (String) jsonObject.get(parameter);
        return value;
    }

}
