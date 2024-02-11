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
public class RefCdGrps {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "grp_code")
    private String grpCode;

    @Column(name = "grp_desc")
    private String grpDesc;

    @Column(name = "grp_shrt_desc")
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

    /*@Column(nullable = false, length = 10)
    private String grpCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "grpCode", cascade = CascadeType.ALL)
    private List<RefCdVals> refCdValsList;

    @Column(nullable = false, length = 100)
    private String grpDesc;

    @Column(nullable = false, length = 30)
    private String grpShrtDesc;

    @Column(nullable = true, length = 255)
    private String grpRemarks;

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
