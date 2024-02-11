package com.assignment.retailstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_val_store_type_id")
    private Long refValStoreTypeId;

    @Column(name = "store_code")
    private String storeCode;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "area")
    private String area;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

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

    @Column(nullable = false, length = 10, unique = true)
    private String storeCode;

    @Column(nullable = false, length = 100)
    private String storeDesc;

    @Column(nullable = false, length = 30)
    private String storeEmail;

    @Column(nullable = true, length = 255)
    private String storeAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_store_type_id", nullable = false)
    // @Column(nullable = false, length = 20)
    private RefCdVals storeType;

    @Column(nullable = false, length = 20)
    private String storeArea;

    @Column(nullable = false, length = 20)
    private String storeCity;

    @Column(nullable = false, length = 20)
    private String storeCountry;

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
