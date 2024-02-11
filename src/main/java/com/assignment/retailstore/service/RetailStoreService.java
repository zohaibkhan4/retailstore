package com.assignment.retailstore.service;

import com.assignment.retailstore.DAO.requests.OrderPlaceRequest;
import com.assignment.retailstore.entities.*;
import com.assignment.retailstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class RetailStoreService {

    @Autowired
    RefCdGrpsRepository refCdGrpsRepository;

    @Autowired
    RefCdValsRepository refCdValsRepository;

    @Autowired
    StoresRepository storesRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderRepository orderRepository;

    public Iterable<RefCdGrps> getAllRefGroups(){
        return refCdGrpsRepository.findAll();
    }
    public Iterable<RefCdVals> getAllRefValues(){
        return refCdValsRepository.findAll();
    }
    public Iterable<Stores> getAllStores(){
        return storesRepository.findAll();
    }

    public Iterable<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public String placeNewOrder(OrderPlaceRequest orderPlaceRequest){

        Optional<Employee> employeeOptional = null;
        if( orderPlaceRequest.getEmployeeId() != null ){
            employeeOptional = employeeRepository.findById(orderPlaceRequest.getEmployeeId());
        }

        Optional<Customers> customersOptional = null;
        if( orderPlaceRequest.getCustomerDetail() != null ){
            customersOptional = customerRepository.findById(orderPlaceRequest.getCustomerDetail().getCustomerId());
        }

        RefCdVals refCdVals = refCdValsRepository.findByIsActiveAndGrpCodeAndValCode(true, "0003", "0002");

        LocalDate localDate = LocalDate.now();
        LocalDate localShipmntDate = localDate.plusDays(5L);
        Date date = new java.sql.Date(new java.util.Date().getTime());

        //
        Orders orders = new Orders();
        orders.setOrderDt(date);
        orders.setOrderShipmentDt(Date.valueOf(date.toLocalDate().plusDays(5L)));
        orders.setOrderTotal( orderPlaceRequest.getTotalAmt() );

        //
        if( customersOptional.get().getId() == employeeOptional.get().getCustomerId() ){
            orders.setDiscount(30L);
        } else if( refCdVals != null && refCdVals.getId() == customersOptional.get().getRefValCustomerTypeId() ){
            orders.setDiscount(10L);
        } else if ( orderPlaceRequest.getTotalAmt() >= 100 ){
            orders.setDiscount(5L);
        } else {
            orders.setDiscount(0L);
        }

        double grandTotal = orders.getOrderTotal().doubleValue() - (orders.getOrderTotal().doubleValue() *
                (orders.getDiscount().doubleValue() /100));
        if( orders.getDiscount() > 0 ){
            orders.setGrandTotal( grandTotal );
        } else{
            orders.setGrandTotal( orders.getOrderTotal() );
        }

        orders.setIsActive(true);
        orders.setCreatedBy(employeeOptional.get().getFullName());
        orders.setCreatedDt(date);

        RefCdVals refCdValsOrderSts = refCdValsRepository.findByIsActiveAndGrpCodeAndValCode(true, "0006", "0001");
        orders.setRefValStatusId(refCdValsOrderSts.getId());
        orderRepository.save(orders);

        // Order Details
        OrderDetails orderDetails = new OrderDetails();

        return "";
    }
}
