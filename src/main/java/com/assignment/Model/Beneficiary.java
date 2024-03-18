package com.assignment.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "beneficiaries")
public class Beneficiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String beneficiary_id ;
    private String beneficiary_name;
    private String beneficary_type;
    private String company_name;
    private String registration_number;
    private String category;
    private String gender;
    private String pincode;


    public Beneficiary(String beneficiary_id, String beneficiary_name, String beneficary_type, String company_name, String registration_number, String category, String gender, String pincode) {
        this.beneficiary_id = beneficiary_id;
        this.beneficiary_name = beneficiary_name;
        this.beneficary_type = beneficary_type;
        this.company_name = company_name;
        this.registration_number = registration_number;
        this.category = category;
        this.gender = gender;
        this.pincode = pincode;
    }
}
