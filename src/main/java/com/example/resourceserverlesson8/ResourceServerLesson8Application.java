package com.example.resourceserverlesson8;

import com.example.resourceserverlesson8.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerLesson8Application {

    public static void main(String[] args) {
        SpringApplication.run(ResourceServerLesson8Application.class, args);
    }

}
