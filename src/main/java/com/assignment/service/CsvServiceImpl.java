package com.assignment.service;

import com.assignment.Model.Beneficiary;
import com.assignment.Model.LoanDetails;
import com.assignment.repo.BeneficiaryRepository;
import com.assignment.repo.LoanRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvServiceImpl implements CsvService{

    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    @Autowired
    private LoanRepository loanRepository;

    private Logger logger = LoggerFactory.getLogger(CsvServiceImpl.class);

    @Override
    public boolean hasCsvFormat(MultipartFile file) {
        String type = "text/csv";
        return type.equals(file.getContentType());
    }

    @Override
    public void processAndSaveData(MultipartFile file) {

        if(file.getOriginalFilename().equals("Task-1 Beneficiary Details.csv")){
            try {
                List<Beneficiary> beneficiary = csvToBeneficiary(file.getInputStream());
                if (beneficiary != null && !beneficiary.isEmpty()) {
                    beneficiaryRepository.saveAll(beneficiary);
                }
            } catch (IOException e) {
                logger.error("Failed to process and save data from CSV file", e);
            }
        }
        if(file.getOriginalFilename().equals("Task-2 Loan_Details.csv")){
            try {
                List<LoanDetails> loanDetails = csvToLoanDetails(file.getInputStream());

                if (loanDetails != null && !loanDetails.isEmpty()) {
                    loanRepository.saveAll(loanDetails);
                }
            } catch (IOException e) {
                logger.error("Failed to process and save data from CSV file", e);
            }
        }

    }

    private List<Beneficiary> csvToBeneficiary(InputStream inputStream) throws IOException {
        List<Beneficiary> beneficiaries = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                String beneficiaryId = csvRecord.get("beneficiary_id");
                String beneficiaryName = csvRecord.get("beneficiary_name");
                String beneficiaryType = csvRecord.get("beneficary_type");
                String companyName = csvRecord.get("company_name");
                String registrationNumber = csvRecord.get("registration_number");
                String category = csvRecord.get("category");
                String gender = csvRecord.get("gender");
                String pincode = csvRecord.get("pincode");

                Beneficiary beneficiary = new Beneficiary(beneficiaryId, beneficiaryName, beneficiaryType, companyName, registrationNumber, category, gender, pincode);

                beneficiaries.add(beneficiary);
            }
        }

        return beneficiaries;
    }


    private List<LoanDetails> csvToLoanDetails(InputStream inputStream) throws IOException {
        List<LoanDetails> loanDetails = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {

            for (CSVRecord csvRecord : csvParser) {
                String application_id = csvRecord.get("application_id");
                String beneficiary_id = csvRecord.get("beneficiary_id");
                String lending_institution_name = csvRecord.get("lending_institution_name");
                String lending_institution_type = csvRecord.get("lending_institution_type");
                String lending_institution_branch_name = csvRecord.get("lending_institution_branch_name");
                String ifsc_code = csvRecord.get("ifsc_code");
                String lending_institution_branch_state_code = csvRecord.get("lending_institution_branch_state_code");
                String lending_institution_branch_state = csvRecord.get("lending_institution_branch_state");
                Integer lending_institution_branch_district_code = Integer.valueOf(csvRecord.get("lending_institution_branch_district_code"));
                String lending_institution_branch_district = csvRecord.get("lending_institution_branch_district");
                String project_type_selected_by_beneficiary = csvRecord.get("project_type_selected_by_beneficiary");
                Integer project_address_state_code = Integer.valueOf(csvRecord.get("project_address_state_code"));
                String project_address_state = csvRecord.get("project_address_state");
                Integer project_address_district_code = Integer.valueOf(csvRecord.get("project_address_district_code"));
                String project_address_district = csvRecord.get("lending_institution_branch_state");
                String approval_date = csvRecord.get("approval_date");
                String loan_status = csvRecord.get("loan_status");
                Double approved_amount_aif = Double.valueOf(csvRecord.get("approved_amount_aif"));
                Double approved_amount_total = Double.valueOf(csvRecord.get("approved_amount_total"));
                Boolean is_loan_npa = Boolean.valueOf(csvRecord.get("is_loan_npa"));
                String loan_account_number = csvRecord.get("loan_account_number");
                Boolean is_cgtmse = Boolean.valueOf(csvRecord.get("is_cgtmse"));



                LoanDetails loan = new LoanDetails(application_id, beneficiary_id, lending_institution_name, lending_institution_type,
                        lending_institution_branch_name, ifsc_code, lending_institution_branch_state_code,lending_institution_branch_state,
                        lending_institution_branch_district_code, lending_institution_branch_district,project_type_selected_by_beneficiary,
                        project_address_state_code, project_address_state, project_address_district_code, project_address_district,
                        approval_date, loan_status, approved_amount_aif, approved_amount_total, is_loan_npa,loan_account_number, is_cgtmse);


                loanDetails.add(loan);
            }
        }

        return loanDetails;
    }

}
