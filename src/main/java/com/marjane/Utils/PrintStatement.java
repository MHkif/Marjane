package com.marjane.Utils;


import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;

public class PrintStatement {

    private static  Scanner scanner = new Scanner(System.in);

    public static void  opening(String text){
        System.out.println("\n\n");
        System.out.println("|-------------------------------------------|");
        System.out.println("\t\t\t"+ text +" \t\t\t\t ");
        System.out.println("|-------------------------------------------|\n");
    }

    public static void indexOptions(){
        System.out.println("\nYou want to :");
        System.out.println("1 - Log in as Admin .");
        System.out.println("2 - Continuer as a Guest .");
        System.out.println("0 - Quitter .");
        System.out.print("->  ");
    }

    public static void adminOptions(){
        System.out.println("1 - Create new flight .");
        System.out.println("2 - Update a flight .");
        System.out.println("3 - Find a flight .");
        System.out.println("4 - Get all flights .");
        System.out.println("5 - Deactivate a flight .");
        System.out.println("0 - Exit .");
        System.out.print("->  ");
    }

    public static void passengerOptions(){
        System.out.println("0 - Exit .");
        System.out.print("->  ");
    }

    public static void backToMenu(){
        System.out.println("\n-> Tap any key to back to menu .\n");
        String s = scanner.nextLine();
    }

    public static long comparingDates(Date depart_at){
            // Calculate the time difference in milliseconds
            long timeDifference = depart_at.getTime() - (new Date()).getTime();

            // Convert milliseconds to days
            long daysDifference = timeDifference / (1000 * 60 * 60 * 24);

            // Print the result
            System.out.println("The difference between the two dates is " + daysDifference + " days.");
            return daysDifference;

    }
    public  static Date parsingDate(String dateInput)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return sdf.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public  static Date parsingDateTime(String dateInput) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = inputFormat.parse(dateInput);
        String formattedDate = outputFormat.format(date);
        return outputFormat.parse(formattedDate);
    }

    public static void displayFlight(String flight){
        System.out.println("\n------------------------------------------\n");
       /*
        System.out.println("# Flight "+flight.getId()+" : ");
        System.out.println("  From : " + flight.getDepartureAirport().getName());
        System.out.println("  To : " + flight.getArrivalAirport().getName());
        System.out.println("  Departure : " + flight.getDepartAt());
        System.out.println("  Arrival : " + flight.getArrivedAt());
        System.out.println("  Type : " + flight.getFlightType());
        System.out.println("  Amount : " + flight.getAmount());
        System.out.println("\n------------------------------------------\n");

        */
    }

    public static void UpdateFlightOptions(String flight){

        boolean isRunning = true;
        while (isRunning){
            System.out.println("What do you want to update :");
            System.out.println("1 - Departure");
            System.out.println("2 - Arrival");
            System.out.println("3 - Departure Date");
            System.out.println("4 - Arrival Date");
            System.out.println("5 - Amount");
            System.out.println("6 - Type");
            System.out.println("7 - AirPlane");
            System.out.println("0 - Exit");
            System.out.println("\n");

            String option = scanner.nextLine();

            if(Validator.validInteger(option) && Integer.parseInt(option) < 8){
               /*
                switch (Integer.parseInt(option)) {
                    case 1 : System.out.print("-> Departure : ");
                             String departure = scanner.nextLine();
                             PrintStatement.validateNumberStatement(departure, "Departure");
                    case 2 : flight.setFlightType(String.valueOf(FlightType.ESCALE));
                    case 7 : System.out.print("-> AirPlane : ");
                             String airPlane = scanner.nextLine();
                             PrintStatement.validateNumberStatement(airPlane, "AirPlane");
                }

                */
                isRunning = false;
            }
            else{
                System.out.println("\nInvalid Entry , Choose one of the following options: ");
            }
        }

    }




    public  static void validateIdStatement(String id, String field){
        if(!Validator.validString(id)){
            boolean confirmName = true;
            while (confirmName){
                System.out.println("\nYou can't start by a numbers for this field - start by letters .");
                System.out.print("-> "+ field +" : ");
                id  = scanner.nextLine();
                if(Validator.validString(id)){
                    confirmName = false;
                }
            }
        }

    }

    public  static void validateNameStatement(String name, String field){
        if(!Validator.validName(name)){
            boolean confirmName = true;
            while (confirmName){
                System.out.println("\nYou can't use numbers for this field - use letters .");
                System.out.print("-> "+ field +" : ");
                name  = scanner.nextLine();
                if(Validator.validName(name)){
                    confirmName = false;
                }
            }
        }
    }

    public  static void validateDateStatement(String date, String field){
        if(!Validator.validDate(date)){
            boolean confirmName = true;
            while (confirmName){
                System.out.println("\nDate field requires a form like : YYYY-MM-DD .");
                System.out.print("-> "+ field +" : ");
                date  = scanner.nextLine();
                if(Validator.validDate(date)){
                    confirmName = false;
                }
            }
        }
    }

    public  static void validateNumberStatement(String num, String field){
        if(!Validator.validInteger(num)){
            boolean confirmName = true;
            while (confirmName){
                System.out.println("\nYou can't use letters for this field - use numbers .");
                System.out.print("-> "+ field +" : ");
                num  = scanner.nextLine();
                if(Validator.validInteger(num)){
                    confirmName = false;
                }
            }
        }
    }

    public  static void validateEmailStatement(String email){
        if(!Validator.validEmail(email)){
            boolean confirmEmail = true;
            while (confirmEmail){
                System.out.println("You have to provide a valid email ex: example@test.com .");
                System.out.print("-> Email : ");
                email  = scanner.nextLine();
                if(Validator.validEmail(email)){
                    confirmEmail = false;
                }
            }
        }
    }

    public  static void validatePasswordStatement(String password){
        if(!Validator.validString(password)){
            boolean confirmPassword = true;
            while (confirmPassword){
                System.out.println("\nInvalid Entry , Format not accepted, use numbers & letters only .");
                System.out.print("-> Password : ");
                password  = scanner.nextLine();
                if(Validator.validString(password)){
                    confirmPassword = false;
                }
            }
        }
    }
}