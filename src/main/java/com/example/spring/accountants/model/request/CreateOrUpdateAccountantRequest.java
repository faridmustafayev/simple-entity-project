package com.example.spring.accountants.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrUpdateAccountantRequest {
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal salary;
}
