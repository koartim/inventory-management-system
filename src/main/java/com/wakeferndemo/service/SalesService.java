package com.wakeferndemo.service;

import com.wakeferndemo.models.Sale;
import com.wakeferndemo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SaleRepository salesRepository;

    public Sale recordSale(Sale sale) {
        return salesRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

}
