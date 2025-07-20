package com.Bank.Disbursement_Report._API.Service;

import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Repository.Disbursement_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Disbursement_Service {

    @Autowired
    private final Disbursement_Repository disbursement_repo;

    public Disbursement_Service(Disbursement_Repository disbursementRepo) {
        disbursement_repo = disbursementRepo;
    }


    public List<Disbursement_Info> getAllDisbursementInfo() {
        List<Disbursement_Info> disbursement_infoList = disbursement_repo.findAll();
        System.out.println(disbursement_infoList);
        return disbursement_infoList;
    }



    public Disbursement_Info createDisbursementData(Disbursement_Info disbursementInfo) {
        //System.out.println("New Data Added");


        System.out.print("New Data Processing: ");
        Disbursement_Info addedDisburs = disbursement_repo.save(disbursementInfo);
        try{
            return addedDisburs;
        } catch (Exception e) {
            System.out.print("Not done");

            return null;
        }

    }


    public Optional<Disbursement_Info> getDisbursementById(Long id) {


        Optional<Disbursement_Info> disbursementById;
        try {
            disbursementById = disbursement_repo.findById(id);
            disbursementById.ifPresentOrElse(
                    disbursementInfoById -> System.out.print("Found" + disbursementInfoById),
                    () -> System.out.print("Not Found" + id + "ID"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return disbursementById;
    }

}
