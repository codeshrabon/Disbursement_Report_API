package com.Bank.Disbursement_Report._API.Service;

//import com.Bank.Disbursement_Report._API.DTO.Disbursement_DTO;
import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Repository.Disbursement_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Disbursement_Service {

    @Autowired
    private final Disbursement_Repository disbursement_repo;

    Scanner scanner = new Scanner(System.in);

    public Disbursement_Service(Disbursement_Repository disbursementRepo) {
        disbursement_repo = disbursementRepo;
    }


    //Get all Disbursement report
    public List<Disbursement_Info> getAllDisbursementInfo() {
        //System.out.println(disbursement_infoList);
        return disbursement_repo.findAll();
    }

    /*public Disbursement_Info addedDisbursementData(Disbursement_Info disbursementInfo) {
    }*/



    // Added new disbursement from postman or system
    public Disbursement_Info addedDisbursement(Disbursement_Info disbursement_info) {
        //System.out.println("New Data Added");

        try{

            Disbursement_Info addedDisburse = disbursement_repo.save(disbursement_info);
            System.out.print("Added data to table: "+ addedDisburse);
            return addedDisburse;
        }
        catch (Exception e) {
            System.out.print("Not done" +e.getMessage());

            return null;
        }

    }

    //Get Disbursement Info from ID
    /*public Optional<Disbursement_Info> DisbursementById(Long id) {


        Optional<Disbursement_Info> DisbursementById = disbursement_repo.findAllById(id);
        getDisbursementById.ifPresentOrElse(disbursementInfo ->


                );
        return DisbursementById(Disbursement_Info);
    }*/

    //Get Disbursement Info from ID
    public Optional<Disbursement_Info>getDisbursementById(Long id) {
       try {
           Optional<Disbursement_Info> disbursementById = disbursement_repo.findById(id);
           disbursementById.ifPresentOrElse(
                   disbursementInfoById -> System.out.print("Found" + disbursementInfoById),
           () -> System.out.print("Not Found" + id + "ID"));


           return  disbursementById;
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    // update info by id
    public Optional<Disbursement_Info> Disbursement_Info(Long id, Disbursement_Info Disbursement_info) {

        try{
            return disbursement_repo.findById(id).map(existingDisbursement_info ->{
                existingDisbursement_info.setAccount_name(Disbursement_info.getAccount_name());
                existingDisbursement_info.setLoan_account_number(Disbursement_info.getLoan_account_number());
                existingDisbursement_info.setDisbursement_date(Disbursement_info.getDisbursement_date());
                existingDisbursement_info.setAmount(Disbursement_info.getAmount());
                existingDisbursement_info.setRate_of_interest(Disbursement_info.getRate_of_interest());
                existingDisbursement_info.setTenure(Disbursement_info.getTenure());
                existingDisbursement_info.setType_of_loan(Disbursement_info.getType_of_loan());
                existingDisbursement_info.setEligible_security_value(Disbursement_info.getEligible_security_value());
                existingDisbursement_info.setSecurity_coverage(Disbursement_info.getSecurity_coverage());
                existingDisbursement_info.setSecurity_details_as_per_sanction(Disbursement_info.getSecurity_details_as_per_sanction());
                existingDisbursement_info.setClient_identification_done_with_varification(Disbursement_info.isClient_identification_done_with_varification());
                existingDisbursement_info.setGuarantor_identification_done_with_verification(Disbursement_info.isGuarantor_identification_done_with_verification());
                existingDisbursement_info.setFund_utilization_ensured(Disbursement_info.isFund_utilization_ensured());
                existingDisbursement_info.setSignal_borrower_exposure_limit(Disbursement_info.getSignal_borrower_exposure_limit());
                existingDisbursement_info.setCompliance_with_credit_policy(Disbursement_info.isCompliance_with_credit_policy());
                existingDisbursement_info.setComment(Disbursement_info.getComment());

                return disbursement_repo.save(existingDisbursement_info);

        });} catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


    public Disbursement_Info DeleteById(Long id) {
        Optional<Disbursement_Info> deleteById = disbursement_repo.findById(id);

        if (deleteById.isPresent()){
             disbursement_repo.deleteById(id);
            return deleteById.get();
        }else {

            throw new RuntimeException("Incorrect ID");
        }
    }
}
