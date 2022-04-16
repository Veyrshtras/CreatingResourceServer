package com.example.resourceserverlesson8.config;

import com.example.resourceserverlesson8.dto.CustomUserDetail;
import com.example.resourceserverlesson8.entity.User;
import com.example.resourceserverlesson8.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

@Configuration
public class JpaAuditingConfig {

    private final UserRepository userRepository;

    public JpaAuditingConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public AuditorAware<User> userAuditorAware(){
        return ()-> {
            SecurityContext context= SecurityContextHolder.getContext();
            if (context!=null&& context.getAuthentication()!=null){
                return userRepository.findByEmail(context.getAuthentication().getName());
            }
            return Optional.empty();
        };
    }


}
