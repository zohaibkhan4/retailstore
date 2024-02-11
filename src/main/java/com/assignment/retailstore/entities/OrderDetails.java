package com.assignment.retailstore.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderDetails {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;

    @Column(nullable = false, columnDefinition = "bigint default 0 ")
    private Long quantity;

    @Column(nullable = false, columnDefinition = "decimal(10,3) default 0 ")
    private Double pricePerPrd;

    @Column(nullable = false, length = 30)
    private String createdBy;

    @Column(nullable = false)
    private Date createdDt;*/
}
