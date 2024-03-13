package com.jtbank.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Credential {
    @Column(unique = true , length = 50 , nullable = false)
    private String accountEmail;
    @Column(nullable = false)
    private String accountPassword;
}
