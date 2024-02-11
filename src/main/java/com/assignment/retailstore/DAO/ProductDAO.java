package com.assignment.retailstore.DAO;

import com.assignment.retailstore.entities.OrderDetails;
import com.assignment.retailstore.entities.RefCdVals;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductDAO {
    private Long id;
    private String PrdCategory;
    private String PrdType;
    private String prdDesc;
    private double buyPrice;
    private double retail_price;
    private Long quantity_in_stock;
}
