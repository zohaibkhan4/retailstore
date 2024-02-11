package com.assignment.retailstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Products {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_val_prd_category_id")
    private Long refValPrdCategoryId;

    @Column(name = "ref_val_prd_type_id")
    private Long refValPrdTypeId;

    @Column(name = "prd_desc")
    private String prdDesc;

    @Column(name = "buy_price")
    private double buyPrice;

    @Column(name = "retail_price")
    private double retail_price;

    @Column(name = "quantity_in_stock")
    private Long quantity_in_stock;

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

    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<OrderDetails> refPrdOrderDtlList;

    @Column(nullable = false, length = 100)
    private String prdDesc;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_prd_category_id", nullable = false)
    private RefCdVals prdCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_prd_type_id", nullable = false)
    private RefCdVals prdType;

    @Column(nullable = false, columnDefinition = "decimal(10,3) default 0 ")
    private double buyPrice;

    @Column(nullable = false, columnDefinition = "decimal(10,3) default 0 ")
    private double retailPrice;

    @Column(nullable = false, columnDefinition = "bigint default 0 ")
    private Long quantityInStock;

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
