package com.assignment.retailstore.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailDAO {
    private Long customerId;
    private String customerType;
    private String firstName;
    private String lastName;
    private String modileNo;
    private String phoneNo;
    private String email;
    private String address;
}
