package usecases;


import java.util.Scanner;

import DAO.SellerDao;
import DAO.SellerDaoImpl;
import DTO.Seller;
import Exception.SellerException;

public class SellerLoginUseCase {
    public static void main(String[] args) {
        boolean result=SellerLogin();
    }
    public static boolean SellerLogin() {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        SellerDao slogindao =new SellerDaoImpl();
        try {
            Seller seller=slogindao.SellerLogin(email,password);
            int sellerId=seller.getSellerId();
            String sellerName=seller.getSellerName();
            String sellerEmail=seller.getEmail();
            String sellerPassword=seller.getPassword();
            String sellerLocation=seller.getLocation();
            System.out.println("Welcome to Seller Dashboard- "+sellerName);
            return true;

        } catch (SellerException e) {
            result = e.getMessage();
            System.out.println( result );
            return false;
        }
    }
}
