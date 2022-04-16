package com.example.resourceserverlesson8.service.impl;

import com.example.resourceserverlesson8.dto.CustomUserDetail;
import com.example.resourceserverlesson8.entity.User;
import com.example.resourceserverlesson8.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user=userRepository.findByEmail(username);
        return user.map(CustomUserDetail::new)
                .orElse(null);
    }


}
