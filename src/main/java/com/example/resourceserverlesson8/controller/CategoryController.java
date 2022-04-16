package com.example.resourceserverlesson8.controller;

import com.example.resourceserverlesson8.dto.CategoryDto;
import com.example.resourceserverlesson8.repository.UserRepository;
import com.example.resourceserverlesson8.service.CategoryService;
import com.example.resourceserverlesson8.userRole.UserRole;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/s1/category")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity findAllByParent(@RequestParam(required = false) Long id){
        return ResponseEntity.ok(service.findAll(id));

    }

    @GetMapping("{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.getOne(id));
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR',  'MODERATOR')")
    public ResponseEntity add(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(service.add(categoryDto));
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRATOR', 'MODERATOR')")
    public ResponseEntity update(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(service.update(id,categoryDto));
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public ResponseEntity delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
