package com.gamenet.service;

import com.gamenet.dao.UserDao;
import org.springframework.security.core.userdetails.User;
import com.gamenet.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ivan on 06.01.16.
 */
public class SocialNetUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.gamenet.domain.User user = userDao.getUserByName(username);

        List<GrantedAuthority> authorities = buildUserForAuthority(user.getUserRoles());

        return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(com.gamenet.domain.User user, List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    private List buildUserForAuthority(Set<UserRole> userRoles) {
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            System.out.println(userRoles.size() + " ---  "+userRole);
            setAuths.add(new SimpleGrantedAuthority(userRole.toString()));
        }

        List<GrantedAuthority> result = new ArrayList<>(setAuths);

        return result;
    }
    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


}
