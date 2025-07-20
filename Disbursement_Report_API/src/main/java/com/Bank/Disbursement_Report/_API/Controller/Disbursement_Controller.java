package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Service.Disbursement_Service;
//import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Disbursement_Info>> GetAllDisbursementInfo(){
        List<Disbursement_Info> getAllDisburse = disbursement_service.getAllDisbursementInfo();

        return new ResponseEntity<>(getAllDisburse, HttpStatus.FOUND);
    }

    @PostMapping("/createNew")
    ResponseEntity<Disbursement_Info>CreateDisbursementData(@RequestBody Disbursement_Info disbursementInfo){
        System.out.println("Incoming data: " + disbursementInfo);
        Disbursement_Info createDisburseData = disbursement_service.createDisbursementData(disbursementInfo);
        return  new ResponseEntity<>(createDisburseData, HttpStatus.CREATED);
    }

    @GetMapping("getById/{id}")
    ResponseEntity<Optional<Disbursement_Info>> GetDisbursementById(@PathVariable Long id){
        System.out.print("User looking for " +id+ " ID ");
        Optional<Disbursement_Info> getDisburseById =  disbursement_service.getDisbursementById(id);

        return new ResponseEntity<>(getDisburseById,HttpStatus.FOUND);


    }

    /*@PutMapping("update/{id}")
    RequestBody<>*/
}
