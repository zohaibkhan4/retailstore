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
// @Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "grp_code", "val_code" }) })
public class RefCdVals{

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grp_code")
    private String grpCode;

    @Column(name = "val_code")
    private String valCode;

    @Column(name = "val_desc")
    private String grpDesc;

    @Column(name = "val_shrt_desc")
    private String grpShrtDesc;

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
    private List<Products> productsListList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private List<Stores> storesList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grp_code", nullable = false, columnDefinition = "varchar(10)")
    private RefCdGrps grpCode;

    @Column(name = "val_code", nullable = false, length = 10)
    private String valCode;

    @Column(nullable = false, length = 100)
    private String valDesc;

    @Column(nullable = false, length = 30)
    private String valShrtDesc;

    @Column(nullable = true, length = 255)
    private String valRemarks;

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
