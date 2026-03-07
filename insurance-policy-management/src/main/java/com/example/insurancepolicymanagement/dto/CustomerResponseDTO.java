package com.example.insurancepolicymanagement.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}