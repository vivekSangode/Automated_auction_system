package usecases;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import DTO.Product;
import DTO.ProductImpl;

public class CreateProductListUseCase {
    public static void main(String[] args) {
        createProductList();
    }
    public static void createProductList(){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("_ _ _ _ _ _ Enter the number of products you want to insert in auction list _ _ _ _ _ _ ");
            int N = sc.nextInt();
            List<Product> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                System.out.println("Enter Details of Product-" + (i + 1));
                Product products = new ProductImpl();
                System.out.println("Enter Product Name-");
                String name = sc.next();
                products.setProductName(name);
                System.out.println("Enter Category ID-");
                int cid = sc.nextInt();
                products.setCategoryId(cid);
                System.out.println("Enter Seller ID-");
                int sid = sc.nextInt();
                products.setSellerId(sid);
                System.out.println("Enter Price-");
                int price = sc.nextInt();
                products.setPrice(price);
                list.add(products);
                System.out.println("---------------------------------------------------------------------------------");
            }

           DAO.SellerDao dao = new DAO.SellerDaoImpl();
            String result;
            try {
                result = dao.CreateListofProductstoSell(list);
                System.out.println(result);
            } catch (Exception e) {
                result = e.getMessage();
                System.out.println(result);
            }
        }catch (InputMismatchException i){
            System.out.println("Exception : Invalid Input Data Type");
        }


    }
}
