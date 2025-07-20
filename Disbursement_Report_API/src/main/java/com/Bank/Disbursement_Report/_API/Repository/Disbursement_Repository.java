package com.Bank.Disbursement_Report._API.Repository;

//import com.Bank.Disbursement_Report._API.DTO.Disbursement_DTO;
import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Disbursement_Repository extends JpaRepository<Disbursement_Info,Long> {


    Optional<Disbursement_Info> findAllById(Long id);
}
