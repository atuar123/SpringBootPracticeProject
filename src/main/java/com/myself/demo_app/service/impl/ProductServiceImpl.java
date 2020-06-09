package com.myself.demo_app.service.impl;

import com.myself.demo_app.dto.Response;
import com.myself.demo_app.entity.Product;
import com.myself.demo_app.entity.ProductDto;
import com.myself.demo_app.repository.ProductRepository;
import com.myself.demo_app.service.ProductService;
import com.myself.demo_app.util.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.PreUpdate;
import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final String root = "Product";
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper){
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Response save(ProductDto productDto) {
        Product product = modelMapper.map(productDto, Product.class);
        product = productRepository.save(product);
        if(product != null){
            return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,root+" Created Successfully",  null);
        }

        return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server errors occurs");
    }

    @Override
    public Response update(Long id, ProductDto productDto) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null){
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            modelMapper.map(productDto, product);
            product = productRepository.save(product);
            if(product != null){
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root+ " updated successfully",null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server errors occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND,root+" not found");
    }

    @Override
    public Response delete(Long id) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null){
            product.setIsActive(false);
            product = productRepository.save(product);
            if(product != null){
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root+ " deleted successfully", null);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server errors occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND,root+" not found");
    }

    @Override
    public Response get(Long id) {
        Product product = productRepository.findByIdAndIsActiveTrue(id);
        if(product != null){
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            if(product != null){
                return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root+ " retrieved successfully", productDto);
            }
            return ResponseBuilder.getFailureResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Internal server errors occurs");
        }
        return ResponseBuilder.getFailureResponse(HttpStatus.NOT_FOUND,root+" not found");
    }
    @Override
    public Response getAll() {
        List<Product> products = productRepository.findAllByIsActiveTrue();
        List<ProductDto> productDtos = this.getProducts(products);
        return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root+" retrieved Successfully", productDtos);
    }
    private List<ProductDto> getProducts(List<Product> products){
        List<ProductDto> productDtos = new ArrayList<>();
        products.forEach(product -> {
            modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
            ProductDto productDto = modelMapper.map(product, ProductDto.class);
            productDtos.add(productDto);
        });
        return productDtos;
    }

}
