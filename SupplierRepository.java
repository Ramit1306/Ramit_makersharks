package com.example.makersharks.repository;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.model.NatureOfBusiness;
import com.example.makersharks.model.ManufacturingProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            String location,
            NatureOfBusiness natureOfBusiness,
            ManufacturingProcess manufacturingProcess);
}
