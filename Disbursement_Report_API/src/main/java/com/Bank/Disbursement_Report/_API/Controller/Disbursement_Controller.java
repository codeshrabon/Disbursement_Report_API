package com.Bank.Disbursement_Report._API.Controller;

//import com.Bank.Disbursement_Report._API.DTO.Disbursement_DTO;
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

    /*@Autowired
    private final Disbursement_DTO disbursement_dto;*/


    public Disbursement_Controller(Disbursement_Service disbursementService) {
        disbursement_service = disbursementService;
//        disbursement_dto = disbursementDto;
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
        Disbursement_Info saveData = disbursement_service.addedDisbursement(disbursementInfo);

        return ResponseEntity.ok(saveData);

    }

   @GetMapping("getById/{id}")
   public ResponseEntity<Optional<Disbursement_Info>>GetDisbursementById( @PathVariable Long id){
        System.out.print("User looking for " + id +"ID ");
        Optional<Disbursement_Info> findDisbursById = disbursement_service.getDisbursementById(id);
        return new ResponseEntity<>(findDisbursById,HttpStatus.FOUND);

   }

    @PutMapping("updateInfo/{id}")
    public ResponseEntity<Optional<Disbursement_Info>> UpdateDisbursInfoByid(@PathVariable Long id, @RequestBody Disbursement_Info disbursement_info){
        System.out.print("User looking for " + id + " ID and About to UPDATE ");
        Optional<Disbursement_Info> upadateDisburs = disbursement_service.Disbursement_Info(id,disbursement_info);
        System.out.print(id+ " ID is Updated");
        return  new ResponseEntity<>(upadateDisburs, HttpStatus.ACCEPTED);
    }


    //Delete item by ID
    @DeleteMapping("deleteId/{id}")
    public ResponseEntity<Disbursement_Info> deleteById(@PathVariable Long id){
        System.out.print("User want to delete: " + id + " ID ");
        Disbursement_Info deleteDisburse = disbursement_service.DeleteById(id);

        return new ResponseEntity<>(null, HttpStatus.ACCEPTED);

    }




}
