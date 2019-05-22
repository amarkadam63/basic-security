package com.amarkadam.basicsecurity.service;

import com.amarkadam.basicsecurity.entity.User;
import com.amarkadam.basicsecurity.config.entity.UserPrinciple;
import com.amarkadam.basicsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipleUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user == null)
            throw new UsernameNotFoundException("User Not Found");

        return new UserPrinciple(user);
    }
}


