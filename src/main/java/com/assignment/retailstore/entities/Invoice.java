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
public class Invoice {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

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

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @Column(nullable = false)
    private Date invoiceDt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_val_status_id", nullable = false)
    private RefCdVals paymentStatus;

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
