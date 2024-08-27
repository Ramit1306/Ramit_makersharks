package com.example.makersharks.service;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public Page<Supplier> searchSuppliers(String location, String natureOfBusiness, String manufacturingProcess, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Supplier> suppliers = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
                location,
                NatureOfBusiness.valueOf(natureOfBusiness.toUpperCase()),
                ManufacturingProcess.valueOf(manufacturingProcess.toUpperCase()));
        return new PageImpl<>(suppliers, pageable, suppliers.size());
    }
}
