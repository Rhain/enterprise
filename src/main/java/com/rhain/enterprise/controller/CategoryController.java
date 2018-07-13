package com.rhain.enterprise.controller;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Category;
import com.rhain.enterprise.payload.ApiResponse;
import com.rhain.enterprise.payload.CategoryRequest;
import com.rhain.enterprise.payload.PayloadResponse;
import com.rhain.enterprise.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryRequest category){
        Category cate = categoryService.addCategory(category);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/category/{id}")
                .buildAndExpand(cate.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Category create successfully"));
    }

    @GetMapping
    public PayloadResponse<?> getAllCategories(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                                       @RequestParam(name = "limit", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Category> categories = categoryService.findCategories(pageNum, pageSize);
        return new PayloadResponse(true, categories);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Category category){
        categoryService.updateCategory(category);
        return ResponseEntity.ok(new ApiResponse(true, "Update category successfully"));
    }

    @GetMapping("/check")
    public PayloadResponse<?> checkName(@RequestParam(name = "name") String name) {
        Boolean exist = categoryService.checkCategoryNameExist(name);
        return new PayloadResponse(true, exist);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(name = "id")Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok(new ApiResponse(true, "Delete category successfully"));
    }
}
