package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blood_bank_branch")
public class BloodBankBranch {

    @Id
    @Column(name = "id" , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="uuid",nullable = false,length = 100)
    private String uuid;

    @Column(name = "manager",nullable = false,length = 150)
    private String manager;

    @Column(name="contactNumber",nullable = false,length = 25)
    private String contactNumber;

    @Column(name = "contactEmail",nullable = false,length = 100)
    private String contactEmail;

    @Embedded
    private Address address;

    @OneToMany(targetEntity=AccountTransaction.class, mappedBy="branch")
    private Collection<AccountTransaction> transactions;

}
