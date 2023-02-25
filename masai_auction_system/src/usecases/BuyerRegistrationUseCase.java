package usecases;

import java.util.InputMismatchException;
import java.util.Scanner;

import DAO.BuyerDao;
import DAO.BuyerDaoImpl;
import DTO.Buyer;
import DTO.BuyerImpl;
import Exception.BuyerException;

public class BuyerRegistrationUseCase {
    public static void main(String[] args) {
        BuyerRegistraion();
    }

    public static void BuyerRegistraion(){
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter Name");
            String n=sc.next();
            System.out.println("Enter Email");
            String e=sc.next();
            System.out.println("Enter Password");
            String p=sc.next();
            System.out.println("Enter Location");
            String l=sc.next();

            String result;
            BuyerDao dao =new BuyerDaoImpl();

            Buyer buyer =new BuyerImpl();

            buyer.setBuyerName(n);
            buyer.setEmail(e);
            buyer.setPassword(p);
            buyer.setLocation(l);

            try {
                result=dao.RegisterBuyer(buyer);
                System.out.println(result);
            } catch (BuyerException ex) {
                result=ex.getMessage();
                System.out.println(result);
            }

        }catch (InputMismatchException i){
            System.out.println( "Exception : Invalid Input Data Type" );
        }

    }
}
