package com.assignment.retailstore.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@ToString
public class EmployeeDAO {

    public Long id;
    public Long storeId;
    public Long customerId;
    public String designation;
    public String fullName;
    public String userLogin;
    public String userPassword;
    public Date issueDt;
    public Date expiryDt;
    public int noOfLoginAttempts;
    public Date lastLoginDt;
    public Long manager_id;
}
