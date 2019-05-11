package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_bank_inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uuid",length = 100,unique = true)
    private String uuid;

    @Enumerated(EnumType.STRING)
    @Column(name = "inventoryType", nullable = false)
    private InventoryType inventoryType;

    @Column(name = "bloodGroup", nullable = false)
    private boolean active;

    @Column(name="expiryDate",nullable = false)
    @NotNull
    private Date expiryDate;

    @Column(name="quantity",nullable = false)
    @NotNull
    private float quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "bloodGroup", nullable = false)
    private BloodGroup bloodGroup;

    @ManyToOne
    @JoinColumn(name="branchId")
    private BloodBankBranch branch;

    @ManyToOne
    @JoinColumn(name="transactionId")
    private AccountTransaction accountTransaction;

}
