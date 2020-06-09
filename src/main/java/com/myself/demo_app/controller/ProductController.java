package com.myself.demo_app.controller;

import com.myself.demo_app.annotations.ApiController;
import com.myself.demo_app.dto.Response;
import com.myself.demo_app.entity.ProductDto;
import com.myself.demo_app.service.ProductService;
import com.myself.demo_app.util.ResponseBuilder;
import com.myself.demo_app.util.UrlConstraint;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.validation.Valid;

@ApiController
@RequestMapping(UrlConstraint.ProductManagement.ROOT)
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @PostMapping(UrlConstraint.ProductManagement.CREATE)
    public Response create(@Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            return ResponseBuilder.getFailureResponse(result,"Bean Binding error");
        }
        return productService.save(productDto);
    }
    @PutMapping(UrlConstraint.ProductManagement.UPDATE)
    public Response update(@PathVariable("id") Long id, @Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            return ResponseBuilder.getFailureResponse(result,"Bean Binding error");
        }
        return productService.update(id,productDto);
    }
    @DeleteMapping(UrlConstraint.ProductManagement.DELETE)
    public Response delete(@PathVariable("id") Long id){
        return productService.delete(id);
    }
    @GetMapping(UrlConstraint.ProductManagement.GET)
    public Response get(@PathVariable("id") Long id){
        return productService.get(id);
    }
    @GetMapping(UrlConstraint.ProductManagement.GET_ALL)
    public Response get(){
        return productService.getAll();
    }
}
