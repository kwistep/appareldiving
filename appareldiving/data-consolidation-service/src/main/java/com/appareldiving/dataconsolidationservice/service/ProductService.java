package com.appareldiving.dataconsolidationservice.service;

import com.appareldiving.dataconsolidationservice.entity.Offer;
import com.appareldiving.dataconsolidationservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository productRepository;


    public Offer saveProduct(Offer offer)
    {
        if(Objects.isNull(findById(offer.getOfferId())))
        {
            return productRepository.save(offer);
        }
        else
        {
            return null;
        }
    }

    public List<Offer> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Offer findById(String id) {
        return productRepository.findByProductId(id);
    }

    @Override
    public boolean isFinished(int quantity) {
        int size = getAll().size();
        return size == quantity;
    }

}
