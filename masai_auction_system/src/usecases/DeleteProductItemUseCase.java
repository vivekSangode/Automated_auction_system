package usecases;


import java.util.Scanner;

import DAO.SellerDao;
import DAO.SellerDaoImpl;
import Exception.SellerException;

public class DeleteProductItemUseCase {
    public static void main(String[] args) {
        deleteProductitem();
    }

    public static void deleteProductitem(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to delete");
        int productId=sc.nextInt();

        String result;
        SellerDao dao=new SellerDaoImpl();
        try {
            result= dao.DeleteProductItems(productId);
            System.out.println(result);
        } catch (SellerException e) {
            result=e.getMessage();
            System.out.println(result);
        }

    }
}
