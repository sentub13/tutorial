package com.example.main.controller;

import com.example.main.model.Category;
import com.example.main.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Operation(summary = "Get all categories", responses = {
            @ApiResponse(responseCode = "200", description = "List of categories",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Category.class)))
    })
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @Operation(summary = "Get category by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Category found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Category.class))),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new category", requestBody = @RequestBody(
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Category.class)))
            })
    @PostMapping
    public Category createCategory(@org.springframework.web.bind.annotation.RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @Operation(summary = "Update a category", requestBody = @RequestBody(
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Category.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Category updated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Category.class))),
                    @ApiResponse(responseCode = "404", description = "Category not found")
            })
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Integer id, @org.springframework.web.bind.annotation.RequestBody Category category) {
        if (!categoryService.getCategoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        category.setCategoryId(id);
        return ResponseEntity.ok(categoryService.saveCategory(category));
    }

    @Operation(summary = "Delete a category", responses = {
            @ApiResponse(responseCode = "204", description = "Category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        if (!categoryService.getCategoryById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
