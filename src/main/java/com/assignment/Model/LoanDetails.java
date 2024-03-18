package com.assignment.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "loan_details")
public class LoanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String application_id;
    private String beneficiary_id;
    private String lending_institution_name;
    private String lending_institution_type;
    private String lending_institution_branch_name;
    @Column(unique = true, length = 11)
    @Pattern(regexp = "[A-Z]{4}0[A-Z0-9]{6}", message = "IFSC code must be 11 alphanumeric characters with fifth character 0 (ZERO)")
    private String ifsc_code;
    private String lending_institution_branch_state_code;
    private String lending_institution_branch_state;
    private Integer lending_institution_branch_district_code;
    private String lending_institution_branch_district;
    private String project_type_selected_by_beneficiary;
    private Integer project_address_state_code;
    private String project_address_state;
    private Integer project_address_district_code;
    private String project_address_district;
    private String approval_date;
    private String loan_status;
    private Double approved_amount_aif;
    private Double approved_amount_total;
    private Boolean is_loan_npa;
    private String loan_account_number;
    private Boolean is_cgtmse;


    public LoanDetails(String application_id, String beneficiary_id, String lending_institution_name, String lending_institution_type, String lending_institution_branch_name, String ifsc_code, String lending_institution_branch_state_code, String lending_institution_branch_state, Integer lending_institution_branch_district_code, String lending_institution_branch_district, String project_type_selected_by_beneficiary, Integer project_address_state_code, String project_address_state, Integer project_address_district_code, String project_address_district, String approval_date, String loan_status, Double approved_amount_aif, Double approved_amount_total, Boolean is_loan_npa, String loan_account_number, Boolean is_cgtmse) {
        this.application_id = application_id;
        this.beneficiary_id = beneficiary_id;
        this.lending_institution_name = lending_institution_name;
        this.lending_institution_type = lending_institution_type;
        this.lending_institution_branch_name = lending_institution_branch_name;
        this.ifsc_code = ifsc_code;
        this.lending_institution_branch_state_code = lending_institution_branch_state_code;
        this.lending_institution_branch_state = lending_institution_branch_state;
        this.lending_institution_branch_district_code = lending_institution_branch_district_code;
        this.lending_institution_branch_district = lending_institution_branch_district;
        this.project_type_selected_by_beneficiary = project_type_selected_by_beneficiary;
        this.project_address_state_code = project_address_state_code;
        this.project_address_state = project_address_state;
        this.project_address_district_code = project_address_district_code;
        this.project_address_district = project_address_district;
        this.approval_date = approval_date;
        this.loan_status = loan_status;
        this.approved_amount_aif = approved_amount_aif;
        this.approved_amount_total = approved_amount_total;
        this.is_loan_npa = is_loan_npa;
        this.loan_account_number = loan_account_number;
        this.is_cgtmse = is_cgtmse;
    }

    public String getApplication_id() {
        return application_id;
    }

    public void setApplication_id(String application_id) {
        this.application_id = application_id;
    }

    public String getBeneficiary_id() {
        return beneficiary_id;
    }

    public void setBeneficiary_id(String beneficiary_id) {
        this.beneficiary_id = beneficiary_id;
    }

    public String getLending_institution_name() {
        return lending_institution_name;
    }

    public void setLending_institution_name(String lending_institution_name) {
        this.lending_institution_name = lending_institution_name;
    }

    public String getLending_institution_type() {
        return lending_institution_type;
    }

    public void setLending_institution_type(String lending_institution_type) {
        this.lending_institution_type = lending_institution_type;
    }

    public String getLending_institution_branch_name() {
        return lending_institution_branch_name;
    }

    public void setLending_institution_branch_name(String lending_institution_branch_name) {
        this.lending_institution_branch_name = lending_institution_branch_name;
    }

    public String getIfsc_code() {
        return ifsc_code;
    }

    public void setIfsc_code(String ifsc_code) {
        this.ifsc_code = ifsc_code;
    }

    public String getLending_institution_branch_state_code() {
        return lending_institution_branch_state_code;
    }

    public void setLending_institution_branch_state_code(String lending_institution_branch_state_code) {
        this.lending_institution_branch_state_code = lending_institution_branch_state_code;
    }

    public String getLending_institution_branch_state() {
        return lending_institution_branch_state;
    }

    public void setLending_institution_branch_state(String lending_institution_branch_state) {
        this.lending_institution_branch_state = lending_institution_branch_state;
    }

    public Integer getLending_institution_branch_district_code() {
        return lending_institution_branch_district_code;
    }

    public void setLending_institution_branch_district_code(Integer lending_institution_branch_district_code) {
        this.lending_institution_branch_district_code = lending_institution_branch_district_code;
    }

    public String getLending_institution_branch_district() {
        return lending_institution_branch_district;
    }

    public void setLending_institution_branch_district(String lending_institution_branch_district) {
        this.lending_institution_branch_district = lending_institution_branch_district;
    }

    public String getProject_type_selected_by_beneficiary() {
        return project_type_selected_by_beneficiary;
    }

    public void setProject_type_selected_by_beneficiary(String project_type_selected_by_beneficiary) {
        this.project_type_selected_by_beneficiary = project_type_selected_by_beneficiary;
    }

    public Integer getProject_address_state_code() {
        return project_address_state_code;
    }

    public void setProject_address_state_code(Integer project_address_state_code) {
        this.project_address_state_code = project_address_state_code;
    }

    public String getProject_address_state() {
        return project_address_state;
    }

    public void setProject_address_state(String project_address_state) {
        this.project_address_state = project_address_state;
    }

    public Integer getProject_address_district_code() {
        return project_address_district_code;
    }

    public void setProject_address_district_code(Integer project_address_district_code) {
        this.project_address_district_code = project_address_district_code;
    }

    public String getProject_address_district() {
        return project_address_district;
    }

    public void setProject_address_district(String project_address_district) {
        this.project_address_district = project_address_district;
    }

    public String getApproval_date() {
        return approval_date;
    }

    public void setApproval_date(String approval_date) {
        this.approval_date = approval_date;
    }

    public String getLoan_status() {
        return loan_status;
    }

    public void setLoan_status(String loan_status) {
        this.loan_status = loan_status;
    }

    public Double getApproved_amount_aif() {
        return approved_amount_aif;
    }

    public void setApproved_amount_aif(Double approved_amount_aif) {
        this.approved_amount_aif = approved_amount_aif;
    }

    public Double getApproved_amount_total() {
        return approved_amount_total;
    }

    public void setApproved_amount_total(Double approved_amount_total) {
        this.approved_amount_total = approved_amount_total;
    }

    public Boolean getIs_loan_npa() {
        return is_loan_npa;
    }

    public void setIs_loan_npa(Boolean is_loan_npa) {
        this.is_loan_npa = is_loan_npa;
    }

    public String getLoan_account_number() {
        return loan_account_number;
    }

    public void setLoan_account_number(String loan_account_number) {
        this.loan_account_number = loan_account_number;
    }

    public Boolean getIs_cgtmse() {
        return is_cgtmse;
    }

    public void setIs_cgtmse(Boolean is_cgtmse) {
        this.is_cgtmse = is_cgtmse;
    }
}
