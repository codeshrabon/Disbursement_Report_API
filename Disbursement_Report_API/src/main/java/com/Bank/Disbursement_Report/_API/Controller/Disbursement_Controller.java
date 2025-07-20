package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Service.Disbursement_Service;
//import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public List<Disbursement_Info> GetAllDisbursementInfo(){

        // showing on terminal
        /*List<Disbursement_Info> disbursement_infoList;
        List<Disbursement_Info> disbursement_infoLists;*/
        System.out.print("User get all the data: ");
//        for (disbursement_infoLists :disbursement_infoList){
//            System.out.println(disbursement_infoLists);
//        }
        return disbursement_service.getAllDisbursementInfo();
    }

    @PostMapping("/addedInfo")
    public ResponseEntity<Disbursement_Info> AddedDisbursementData(@RequestBody Disbursement_Info disbursementInfo){

        System.out.println("Incoming data: ");
        Disbursement_Info saveData = disbursement_service.addedDisbursementData(disbursementInfo);

        return  new ResponseEntity<>(saveData, HttpStatus.ACCEPTED);

    }

   @GetMapping("getById/{id}")
   public ResponseEntity<Optional<Disbursement_Info>>GetDisbursementById( @PathVariable Long id){
        System.out.print("User looking for " + id +"ID ");
        Optional<Disbursement_Info> findDisbursById = disbursement_service.getDisbursementById(id);
        return new ResponseEntity<>(findDisbursById,HttpStatus.FOUND);


    }

    @PutMapping("updateInfo/{id}")
    public ResponseEntity<Optional<Disbursement_Info>> UpdateDisbursInfoByid(@RequestBody Disbursement_Info disbursementInfo, @PathVariable Long id){
        System.out.print("User looking for " + id + "ID");
        Optional<Disbursement_Info> upadateDisburs = disbursement_service.updateDisburseInfo();
        return  new ResponseEntity<>(upadateDisburs, HttpStatus.FOUND);
    }

}
