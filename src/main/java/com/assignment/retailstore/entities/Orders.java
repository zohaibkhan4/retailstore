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
public class Orders {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "orders_seq" )
    @SequenceGenerator(name = "orders_seq", allocationSize = 5 )
    private Long id;

    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Column(name = "ref_val_status_id")
    private Long refValStatusId;

    @Column(name = "order_dt")
    private Date orderDt;

    @Column(name = "order_shipment_dt")
    private Date orderShipmentDt;

    @Column(name = "order_total")
    private Double orderTotal;

    @Column(name = "discount")
    private Long discount;

    @Column(name = "grand_total")
    private Double grandTotal;

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
    private List<OrderDetails> orderDetailsList;

    @Column(nullable = false)
    private Date orderDt;

    @Column(nullable = false)
    private Date orderShipmentdDt;

    @Column(nullable = false, columnDefinition = "decimal(10,3) default 0")
    private Double orderTotalAmt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_status_id", nullable = false)
    private RefCdVals status;

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
