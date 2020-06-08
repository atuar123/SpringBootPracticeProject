package com.myself.demo_app.service;

import com.myself.demo_app.dto.Response;
import com.myself.demo_app.entity.ProductDto;

public interface ProductService {
    Response save(ProductDto productDto);
    Response update(Long id, ProductDto productDto);
    Response delete (Long id);
    Response get (Long id);
    Response getAll ();


}
