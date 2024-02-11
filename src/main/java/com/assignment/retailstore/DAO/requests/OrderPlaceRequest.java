package com.assignment.retailstore.DAO.requests;

import com.assignment.retailstore.DAO.CustomerDetailDAO;
import com.assignment.retailstore.DAO.ProductDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderPlaceRequest {
    public Long employeeId;
    public CustomerDetailDAO customerDetail;
    public Double totalAmt;
    public List<ProductDAO> productsList;
}
