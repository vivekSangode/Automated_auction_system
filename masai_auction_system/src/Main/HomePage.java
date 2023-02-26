package Main;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import custom.ConsoleColors;
public class HomePage {
	public static void appOpening() throws InputMismatchException{
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Automated Auction Application : "+ ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose Login/Register Option from Below According to your Designation  : " + ConsoleColors.RESET);
            System.out.println("Press 1 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " logIn as Admin"+ ConsoleColors.RESET);
            System.out.println("Press 2 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " Register as Buyer." + ConsoleColors.RESET);
            System.out.println("Press 3 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " logIn as Buyer."+ ConsoleColors.RESET);
            System.out.println("Press 4 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " Register as Seller." + ConsoleColors.RESET);
            System.out.println("Press 5 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " logIn as Seller."+ ConsoleColors.RESET);
            System.out.println("Press 6 to" +ConsoleColors.PURPLE_BOLD_BRIGHT +" EXIT"+ ConsoleColors.RESET);
            String choice = sc.nextLine();

            if(choice.equals("1")){
                AdminMain adminMain=new AdminMain();
                Boolean resulta=AdminMain.AdminLogin();

                int countadminLogin =1;

                while(!resulta) {
                    countadminLogin++;
                    System.out.println((4-countadminLogin) +" Attempts remaining");
                    resulta = adminMain.AdminLogin();

                    if(countadminLogin ==3 && resulta ==false) {
                        System.out.println("Maximum Limit Crossed : Try Again Later");
                        break;

                    }
                }
                if(resulta) {

                    while(true) {

                        adminMain.AdminHomeWindow();

                        String choiceAdmin = sc.nextLine();

                        if(choiceAdmin.equals("1")) {
                            adminMain.viewBuyers();
                        }else if(choiceAdmin.equals("2")) {
                            adminMain.viewSellers();
                        }else if (choiceAdmin.equals("3")) {
                            adminMain.dailySellingReport();
                        }else if(choiceAdmin.equals("4")){
                            adminMain.dailyDisputeReport();
                        }else if(choiceAdmin.equals("5")){
                            adminMain.solveDispute();
                        }else if(choiceAdmin.equals("6")){
                            System.out.println("LOGOUT SUCCESSFUL !");
                            break;
                        }else {
                            System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 6");
                        }
                    }
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                }else {
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
            }else if(choice.equals("2")){
                BuyerMain buyerMain=new BuyerMain();
                buyerMain.BuyerRegistration();

                appOpening();
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------");

            }else if(choice.equals("3")){
                BuyerMain buyerMain=new BuyerMain();
                Boolean resultb=buyerMain.BuyerLogin();

                int countbuyerLogin =1;

                while(!resultb) {
                    countbuyerLogin++;
                    System.out.println((4-countbuyerLogin) +" Attempts remaining");
                    resultb = buyerMain.BuyerLogin();

                    if(countbuyerLogin ==3 && resultb ==false) {
                        System.out.println( "Maximum Limit Crossed : Try Again Later");
                        break;

                    }
                }
                if(resultb) {

                    while(true) {

                        buyerMain.BuyerHomeWindow();

                        String choiceAdmin = sc.nextLine();

                        if(choiceAdmin.equals("1")) {
                            buyerMain.SearchItemCategory();
                        }else if(choiceAdmin.equals("2")) {
                            buyerMain.BuyItem();
                        }else if (choiceAdmin.equals("3")) {
                            buyerMain.BuyerByCategory();
                        }else if(choiceAdmin.equals("4")){
                            System.out.println("LOGOUT SUCCESSFUL !");
                            break;
                        }else {
                            System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 4");
                        }
                    }
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                }else {
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
            }else if(choice.equals("4")){
                SellerMain sellerMain=new SellerMain();
                sellerMain.SellerRegistration();

                appOpening();
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------");

            }else if(choice.equals("5")){
                SellerMain sellerMain=new SellerMain();
                Boolean results=sellerMain.SellerLogin();

                int countsellerLogin =1;

                while(!results) {
                    countsellerLogin++;
                    System.out.println((4-countsellerLogin) +" Attempts remaining");
                    results = sellerMain.SellerLogin();

                    if(countsellerLogin ==3 && results ==false) {
                        System.out.println("Maximum Limit Crossed : Try Again Later");
                        break;

                    }
                }
                if(results) {

                    while(true) {

                        sellerMain.SellerHomeWindow();

                        String choiceAdmin = sc.nextLine();

                        if(choiceAdmin.equals("1")) {
                            sellerMain.createListofProducts();
                        }else if(choiceAdmin.equals("2")) {
                            sellerMain.updateProductList();
                        }else if (choiceAdmin.equals("3")) {
                            sellerMain.deleteProductItem();
                        }else if (choiceAdmin.equals("4")) {
                            sellerMain.soldItemHistory();
                        }else if(choiceAdmin.equals("5")){
                            System.out.println( "LOGOUT SUCCESSFUL !");
                            break;
                        }else {
                            System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 5" );
                        }
                    }
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                }else {
                    appOpening();
                    System.out.println();
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                }
            }else if(choice.equals("6")) {
                System.out.println( "APPLICATION CLOSED : EXITED");
                System.exit(0);

            }else {
                System.out.println("CHOOSE CORRECT INPUT RANGE FROM 1 TO 6");
                appOpening();
            }



        }catch (InputMismatchException e){
            System.out.println( e.getMessage() );
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        appOpening();
    }
}
