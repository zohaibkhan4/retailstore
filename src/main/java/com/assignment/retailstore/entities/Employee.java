package com.assignment.retailstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Employee {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "ref_val_designation_id")
    private Long refValDesignationId;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "issue_dt")
    private Date issueDt;

    @Column(name = "expiry_dt")
    private Date expiryDt;

    @Column(name = "no_of_login_attempts")
    private Integer noOfLoginAttempts;

    @Column(name = "last_login_dt")
    private Date lastLoginDt;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_dt")
    private Date createdDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_dt")
    private Date modifiedDt;

    @Column(name = "modified_by")
    private String modifiedBy;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", nullable = false)
    private Stores storeId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", nullable = true)
    private Customers customerId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reports_to", nullable = true)
    private Employee employee;

    @Column(nullable = false, length = 30)
    private String fullName;

    @Column(nullable = false, length = 30, unique = true)
    private String userLogin;

    @Column(nullable = false, length = 50)
    private String userPassword;

    @Column(nullable = false)
    private Date issueDt;

    @Column(nullable = false)
    private Date expiryDt;

    @Column(nullable = false)
    private Date lastLoginDt;

    @Column(nullable = false, columnDefinition = "int(1) default 3")
    private int noOfLoginAttempts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_designation_id", nullable = false)
    private RefCdVals refValDesignation;

    @Column(nullable = false, length = 1)
    private int isActive;

    @Column(nullable = false, length = 30)
    private String createdBy;

    @Column(nullable = false)
    private Date createdDt;

    @Column(nullable = true, length = 30)
    private String modifiedBy;

    private String modifiedDt;*/
}
