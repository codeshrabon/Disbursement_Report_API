package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.DTO.Disbursement_DTO;
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

    @Autowired
    private final Disbursement_DTO disbursement_dto;


    public Disbursement_Controller(Disbursement_Service disbursementService, Disbursement_DTO disbursementDto) {
        disbursement_service = disbursementService;
        disbursement_dto = disbursementDto;
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
    public ResponseEntity<Disbursement_DTO> AddedDisbursementData(@RequestBody Disbursement_DTO disbursementDto){

        System.out.println("Incoming data: ");
        Disbursement_DTO saveData = disbursement_service.addedDisbursement(disbursementDto);

        return  new ResponseEntity<>(saveData, HttpStatus.ACCEPTED);

    }

   @GetMapping("getById/{id}")
   public ResponseEntity<Optional<Disbursement_Info>>GetDisbursementById( @PathVariable Long id){
        System.out.print("User looking for " + id +"ID ");
        Optional<Disbursement_Info> findDisbursById = disbursement_service.getDisbursementById(id);
        return new ResponseEntity<>(findDisbursById,HttpStatus.FOUND);

   }

    /*@PutMapping("updateInfo/{id}")
    public ResponseEntity<Optional<Disbursement_DTO>> UpdateDisbursInfoByid(@PathVariable Long id, @RequestBody Disbursement_DTO dto){
        System.out.print("User looking for " + id + "ID");
        Optional<Disbursement_DTO> upadateDisburs = disbursement_service.updateDisburseDTO(id);
        return  new ResponseEntity<>(upadateDisburs, HttpStatus.FOUND);
    }*/


}
