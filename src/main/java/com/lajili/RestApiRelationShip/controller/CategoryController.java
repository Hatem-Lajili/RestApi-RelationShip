package com.lajili.RestApiRelationShip.controller;

import com.lajili.RestApiRelationShip.dto.requestDto.CategoryRequestDto;
import com.lajili.RestApiRelationShip.dto.responseDto.CategoryResponseDto;
import com.lajili.RestApiRelationShip.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponseDto>> getCategories() {
        List<CategoryResponseDto> categoryResponseDtos = categoryService.getCategories();
        return new ResponseEntity<>(categoryResponseDtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryResponseDto> addCategory(
            @RequestBody final CategoryRequestDto categoryRequestDto) {
        CategoryResponseDto categoryResponseDto = categoryService.addCategory(categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<CategoryResponseDto> editCategory(
            @RequestBody final CategoryRequestDto categoryRequestDto,
            @PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.editCategory(id, categoryRequestDto);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryResponseDto> deleteCategory(@PathVariable final Long id) {
        CategoryResponseDto categoryResponseDto = categoryService.deleteCategory(id);
        return new ResponseEntity<>(categoryResponseDto, HttpStatus.NO_CONTENT);
    }

}
