package usecases;


import java.util.InputMismatchException;
import java.util.Scanner;

import DAO.SellerDao;
import DAO.SellerDaoImpl;
import DTO.Seller;
import DTO.SellerImpl;
import Exception.SellerException;

public class SellerRegistrationUseCase {
    public static void main(String[] args) {
        SellerRegistraion();
    }

    public static void SellerRegistraion(){
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
            SellerDao dao =new SellerDaoImpl();

            Seller seller =new SellerImpl();

            seller.setSellerName(n);
            seller.setEmail(e);
            seller.setPassword(p);
            seller.setLocation(l);

            try {
                result=dao.RegisterSeller(seller);
                System.out.println(result);
            } catch (SellerException ex) {
                result=ex.getMessage();
                System.out.println(result);
            }

        }catch (InputMismatchException i){
            System.out.println("Exception : Invalid Input Data Type");
        }

    }
}
