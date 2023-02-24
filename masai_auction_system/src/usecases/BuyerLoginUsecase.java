package usecases;



import java.util.Scanner;

import DTO.Buyer;
import Exception.CredentialException;

public class BuyerLoginUsecase {
    public static boolean BuyerLogin() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        DAO.BuyerDao blogindao =new DAO.BuyerDaoImpl();
        try {
            Buyer buyer=blogindao.BuyerLogin(email,password);
            int buyerId=buyer.getBuyerId();
            String buyerName=buyer.getBuyerName();
            String buyerEmail=buyer.getEmail();
            String buyerPassword=buyer.getPassword();
            String buyerLocation=buyer.getLocation();
            System.out.println("Welcome to Buyer Dashboard- "+buyerName);
            return true;

        } catch (CredentialException e) {
            result = e.getMessage();
			System.out.println( result );
			return false;
        }
    }
    public static void main(String[] args) {
        boolean result = BuyerLogin();
    }

}
