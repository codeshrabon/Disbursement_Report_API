package com.Bank.Disbursement_Report._API.Controller;

import com.Bank.Disbursement_Report._API.Model.Disbursement_Info;
import com.Bank.Disbursement_Report._API.Service.Disbursement_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLineUser implements CommandLineRunner {

    @Autowired
    private final Disbursement_Service service;

    public CommandLineUser(Disbursement_Service service) {
        this.service = service;
    }

   /* public void updateFromUser(Long id,Disbursement_Info info){

    }*/

    public void inputFromUser(Disbursement_Info info){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account Name: ");
        info.setAccount_name(scanner.nextLine());

        System.out.print("Enter Loan Account Number: ");
        info.setLoan_account_number(scanner.nextLine());

        System.out.print("Enter Disbursement Date (yyyy-MM-dd): ");
        String dateStr = scanner.nextLine();
        try {
            Date disbursementDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            info.setDisbursement_date(disbursementDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
            return;
        }

        System.out.print("Enter Amount: ");
        info.setAmount(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter Rate of Interest: ");
        info.setRate_of_interest(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter Tenure: ");
        info.setTenure(scanner.nextLine());

        System.out.print("Enter Type of Loan: ");
        info.setType_of_loan(scanner.nextLine());

        System.out.print("Enter Eligible Security Value: ");
        info.setEligible_security_value(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter Security Coverage: ");
        info.setSecurity_coverage(Double.parseDouble(scanner.nextLine()));

        System.out.print("Enter Security Details As Per Sanction: ");
        info.setSecurity_details_as_per_sanction(scanner.nextLine());

        System.out.print("Client Identification Done With Verification (true/false): ");
        info.setClient_identification_done_with_varification(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Guarantor Identification Done With Verification (true/false): ");
        info.setGuarantor_identification_done_with_verification(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Fund Utilization Ensured (true/false): ");
        info.setFund_utilization_ensured(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Enter Signal Borrower Exposure Limit: ");
        info.setSignal_borrower_exposure_limit(Double.parseDouble(scanner.nextLine()));

        System.out.print("Compliance With Credit Policy (true/false): ");
        info.setCompliance_with_credit_policy(Boolean.parseBoolean(scanner.nextLine()));

        System.out.print("Enter Comment: ");
        info.setComment(scanner.nextLine());

        // Save the filled object
        Disbursement_Info saved = service.addedDisbursement(info);
        System.out.println("Saved Successfully: " + saved);
    }

    @Override
    public void run(String... args) throws Exception {


        Scanner scanner = new Scanner(System.in);



        //For System
        System.out.print("====Welcome to Disbursement Info System====");
        /*int choice = scanner.nextInt();*/
        while (true){
            System.out.println("\nChoose an option");
            System.out.println("1. Get all the data");
            System.out.println("2. Add new info");
            System.out.println("3. Get User by ID");
            System.out.println("4. Update a User");
            System.out.println("5. Delete");
            System.out.println("6. Exist");
            System.out.print("Your choice is: ");


            int choice = scanner.nextInt();

            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("User get's all the DATA");
                    service.getAllDisbursementInfo();
                break;


                case 2:
                    System.out.print("Added new Info to Disbursement");
                    inputFromUser(new Disbursement_Info());
                break;

                case 3:
                    System.out.print("User looking for specific ID");
                    System.out.print("Enter the ID: ");
                Long specificID = scanner.nextLong();
                scanner.nextLine();
                service.getDisbursementById(specificID) ;
                break;

                case 4: System.out.print("User want to update from Disbursement Info table");
                System.out.print("Which ID you like to edit: ");
                long idToEdit = scanner.nextLong();
                scanner.nextLine();
                /*service.getDisbursementById(idToEdit);
                System.out.println("Now edit : " );
                service.updateDisbursement_Info(idToEdit,Disbursement_Info);*/

                    Optional<Disbursement_Info> infoToupdate = service.getDisbursementById(idToEdit);
                    if (infoToupdate.isPresent()){
                        Disbursement_Info existingDisburs = infoToupdate.get();
                        System.out.print("Current info: " + existingDisburs);

                        //now time to update
                        System.out.print("Enter new data to update: ");
                        inputFromUser(existingDisburs);

                        //updateInfo to save
                        Optional<Disbursement_Info> updateInfo = service.updateDisbursement_Info(idToEdit,existingDisburs);

                        if (updateInfo.isPresent()){
                            System.out.print("Successfully Updated" + updateInfo);
                        }else {
                            System.out.print("Update fail");
                        }

                    }else {
                        System.out.print("There is no record you are looking for : " + idToEdit);
                    }
                    break;

                case 5: System.out.print("User want to delete");
                System.out.print("Enter the ID ");
                Long idToDelete = scanner.nextLong();
                scanner.nextLine();
                service.DeleteById(idToDelete);
                break;

                case 6:

                    System.out.print("User Leaving");
                    System.out.print("Good bye");
                    System.exit(0);

                default:
                    System.out.print("Invalid option. DO IT AGAIN");

            }
        }
    }
}
