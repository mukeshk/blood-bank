package io.indorse.bloodbank.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    @Column(name = "addressLine1", nullable = false, unique = false, length = 150)
    private String addressLine1;

    @Column(name = "addressLine2", nullable = true, unique = false, length = 150)
    private String addressLine2;

    @Column(name = "city", nullable = false, unique = false,length = 150)
    private String city;

    @Column(name = "state", nullable = false, unique = false,length = 150)
    private String state;

    @Column(name = "zipCode", nullable = false, unique = false,length = 6)
    private String zipCode;
}
