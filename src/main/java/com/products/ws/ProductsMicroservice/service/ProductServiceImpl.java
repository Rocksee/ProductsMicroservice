package com.products.ws.ProductsMicroservice.service;

import com.products.ws.ProductsMicroservice.rest.CreatedProductRestModel;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String createProduct(CreatedProductRestModel productRestModel) {
        return "";
    }
}
