package com.myself.demo_app.service.impl;

import com.myself.demo_app.dto.Response;
import com.myself.demo_app.entity.ProductDto;
import com.myself.demo_app.repository.ProductRepository;
import com.myself.demo_app.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Response save(ProductDto productDto) {
        return null;
    }

    @Override
    public Response update(Long id, ProductDto productDto) {
        return null;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }

    @Override
    public Response get(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        return null;
    }
}
