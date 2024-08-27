package com.example.makersharks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection(targetClass = ManufacturingProcess.class)
    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Enumerated(EnumType.STRING)
    private List<ManufacturingProcess> manufacturingProcesses;
}

public enum NatureOfBusiness {
    SMALL_SCALE, MEDIUM_SCALE, LARGE_SCALE
}

public enum ManufacturingProcess {
    MOULDING, D_PRINTING, CASTING, COATING
}

