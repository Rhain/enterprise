package com.rhain.enterprise.controller;

import com.github.pagehelper.PageInfo;
import com.rhain.enterprise.model.Carousel;
import com.rhain.enterprise.model.Category;
import com.rhain.enterprise.payload.ApiResponse;
import com.rhain.enterprise.payload.CarouselRequest;
import com.rhain.enterprise.payload.CategoryRequest;
import com.rhain.enterprise.payload.PayloadResponse;
import com.rhain.enterprise.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/carousel")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createCarousel(@Valid @RequestBody CarouselRequest carousel){
        Carousel cate = carouselService.addCarousel(carousel);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/carousels/{id}")
                .buildAndExpand(cate.getId()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "Carousel create successfully"));
    }

    @GetMapping
    public PayloadResponse<?> getAllCarousels(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                                          @RequestParam(name = "limit", required = false, defaultValue = "10") int pageSize) {
        PageInfo<Carousel> carousels = carouselService.findCarousels(pageNum, pageSize);
        return new PayloadResponse(true, carousels);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Carousel carousel){
        carouselService.updateCarousel(carousel);
        return ResponseEntity.ok(new ApiResponse(true, "Update Carousel successfully"));
    }

    @DeleteMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> delete(@RequestParam(name = "id")Integer id){
        carouselService.deleteCarousel(id);
        return ResponseEntity.ok(new ApiResponse(true, "Delete Carousel successfully"));
    }
}
