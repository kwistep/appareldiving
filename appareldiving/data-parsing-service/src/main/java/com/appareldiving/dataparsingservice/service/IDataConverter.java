package com.appareldiving.dataparsingservice.service;

import com.appareldiving.dataparsingservice.dto.Product;

public interface IDataConverter {

    public Product getProductData(String response);

}
