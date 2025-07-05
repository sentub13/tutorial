package com.example.main.controller;

import com.example.main.model.Seller;
import com.example.main.service.SellerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @Operation(summary = "Get all sellers", responses = {
            @ApiResponse(responseCode = "200", description = "List of sellers",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Seller.class)))
    })
    @GetMapping
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @Operation(summary = "Get seller by ID", responses = {
            @ApiResponse(responseCode = "200", description = "Seller found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Seller.class))),
            @ApiResponse(responseCode = "404", description = "Seller not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Seller> getSellerById(@PathVariable Integer id) {
        return sellerService.getSellerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new seller", requestBody = @RequestBody(
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Seller.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Seller created",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Seller.class)))
            })
    @PostMapping
    public ResponseEntity<?> createSeller(@org.springframework.web.bind.annotation.RequestBody Seller seller) {
        try {
            Seller savedSeller = sellerService.saveSeller(seller);
            return ResponseEntity.ok(savedSeller);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
    }

    @Operation(summary = "Update a seller", requestBody = @RequestBody(
            required = true,
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Seller.class))),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Seller updated",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Seller.class))),
                    @ApiResponse(responseCode = "404", description = "Seller not found")
            })
    @PutMapping("/{id}")
    public ResponseEntity<Seller> updateSeller(@PathVariable Integer id, @org.springframework.web.bind.annotation.RequestBody Seller seller) {
        if (!sellerService.getSellerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        seller.setSellerId(id);
        return ResponseEntity.ok(sellerService.saveSeller(seller));
    }

    @Operation(summary = "Delete a seller", responses = {
            @ApiResponse(responseCode = "204", description = "Seller deleted"),
            @ApiResponse(responseCode = "404", description = "Seller not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeller(@PathVariable Integer id) {
        if (!sellerService.getSellerById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sellerService.deleteSeller(id);
        return ResponseEntity.noContent().build();
    }
}
