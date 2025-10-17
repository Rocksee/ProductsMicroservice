package com.products.ws.ProductsMicroservice.service;

import com.products.ws.ProductsMicroservice.rest.CreatedProductRestModel;

public interface ProductService {

    String createProduct(CreatedProductRestModel productRestModel) throws Exception;
}
