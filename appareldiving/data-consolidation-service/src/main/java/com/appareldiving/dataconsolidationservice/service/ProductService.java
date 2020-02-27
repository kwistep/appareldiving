package com.appareldiving.dataconsolidationservice.service;

import com.appareldiving.dataconsolidationservice.entity.Product;
import com.appareldiving.dataconsolidationservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;


    public Product saveProduct(Product product)
    {
        return productRepository.save(product);
    }

    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public boolean isFinished(int quantity) {
        int size = getAll().size();
        return size == quantity;
    }

}
