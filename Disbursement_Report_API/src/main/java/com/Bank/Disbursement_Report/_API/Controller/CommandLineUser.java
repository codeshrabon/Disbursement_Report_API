package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.Repository.Disbursement_Repository;
import com.Bank.Disbursement_Report._API.Service.Disbursement_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineUser implements CommandLineRunner {

    final Disbursement_Repository disbursement_repository;

    public CommandLineUser(Disbursement_Repository disbursementRepository) {
        disbursement_repository = disbursementRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Scanner scanner = new Scanner(System.in);
        System.out.print("====Welcome to Disbursement Info System====");
        int choice = scanner.nextInt();
        while (true){
            System.out.print("1. Get all the data");
            System.out.print("2. Add new info");
            System.out.print("3. Get User by ID");
            System.out.print("4. Update a User");
            System.out.print("5. Exist");

            switch (choice){
                case 1: ;
            }
        }
    }
}
