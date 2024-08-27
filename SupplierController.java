package com.example.makersharks.controller;

import com.example.makersharks.model.Supplier;
import com.example.makersharks.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
@Validated
public class SupplierController {
    private final SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> searchSuppliers(
            @RequestParam @NotEmpty String location,
            @RequestParam @NotEmpty String natureOfBusiness,
            @RequestParam @NotEmpty String manufacturingProcess,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<Supplier> suppliers = supplierService.searchSuppliers(location, natureOfBusiness, manufacturingProcess, page, size);
            return ResponseEntity.ok(suppliers);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}