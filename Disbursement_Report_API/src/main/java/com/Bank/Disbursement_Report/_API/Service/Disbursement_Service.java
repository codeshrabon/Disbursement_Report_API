package com.Bank.Disbursement_Report._API.Service;

import com.Bank.Disbursement_Report._API.DTO.Disbursement_DTO;
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
    public Disbursement_DTO addedDisbursement(Disbursement_DTO disbursementDto) {
        //System.out.println("New Data Added");


        Disbursement_DTO addedDisburse = disbursement_repo.save(disbursementDto);

        try{
            return addedDisburse;
        } catch (Exception e) {
            System.out.print("Not done");

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

    /*public Optional<Disbursement_DTO> updateDisburseDTO(Long id, Disbursement_DTO dto) {
        Optional<Disbursement_DTO> updateDibuserInfo = disbursement_repo.findById(id);
    }*/


    //Update Disbursement info
    /*public Optional<Disbursement_DTO> updateDisburseInfo(Long id) {
        try{
            Optional<Disbursement_Info> updateDisburseInfo = disbursement_repo.findById(id);
            updateDisburseInfo.ifPresentOrElse(
                    disbursementInfo ->
                            disbursementInfo.setAccount_name(scanner.nextLine()




            );




        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/


}
