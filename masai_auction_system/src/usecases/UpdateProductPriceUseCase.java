package usecases;


import java.util.Scanner;

import DAO.SellerDao;
import DAO.SellerDaoImpl;
import Exception.SellerException;

public class UpdateProductPriceUseCase {
    public static void main(String[] args) {
        updateProductlist();
    }

    public static void updateProductlist(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to update");
        int productId=sc.nextInt();
        System.out.println("Enter the updated Price");
        int price=sc.nextInt();

        String result;
        SellerDao dao=new SellerDaoImpl();
        try {
            result=dao.UpdateProductPrice(productId,price);
            System.out.println(result);
        } catch (SellerException e) {
            result=e.getMessage();
            System.out.println(result);
        }

    }
}
