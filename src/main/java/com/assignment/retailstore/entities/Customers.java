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
public class Customers {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_val_customer_type_id")
    private Long refValCustomerTypeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "modile_no")
    private String modileNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_dt")
    private java.sql.Date createdDt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_dt")
    private Date modifiedDt;

    @Column(name = "modified_by")
    private String modifiedBy;

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(nullable = false, length = 15)
    private String modileNo;

    @Column(nullable = false, length = 15)
    private String phoneNo;

    @Column(nullable = false, length = 255)
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_customer_type_id", nullable = false)
    private RefCdVals customerType;

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
