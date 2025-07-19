package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Service.Disbursement_Service;
//import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/disbursement")
public class Disbursement_Controller {

    @Autowired
    private final Disbursement_Service disbursement_service;


    public Disbursement_Controller(Disbursement_Service disbursementService) {
        disbursement_service = disbursementService;
    }


    @GetMapping("/getAll")
    public List<Disbursement_Info> GetAllDisbursementInfo(){

        return disbursement_service.getAllDisbursementInfo();
    }

    @PostMapping("/createNew")
    public Disbursement_Info CreateDisbursementData(@RequestBody Disbursement_Info disbursementInfo){
        System.out.println("Incoming data: " + disbursementInfo);
        return  disbursement_service.createDisbursementData(disbursementInfo);
    }

    @GetMapping("getById/{id}")
    public Optional<Disbursement_Info> GetDisbursementById(@PathVariable Long id){
        return disbursement_service.getDisbursementById(id);


    }

}
