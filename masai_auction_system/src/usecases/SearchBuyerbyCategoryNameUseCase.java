package usecases;


import java.util.List;
import java.util.Scanner;

import DAO.BuyerDao;
import DAO.BuyerDaoImpl;
import DTO.SearchBuyer;
import Exception.BuyerException;

public class SearchBuyerbyCategoryNameUseCase {
    public static void main(String[] args) {
        searchBuyerItembyCategory();
    }
    public static void searchBuyerItembyCategory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the category name to want to find list of bought items by buyers -\n" +
                "|       1001 | Bikes                 |\n" +
                "|       1002 | Cars                  |\n" +
                "|       1003 | Watches               |\n" +
                "|       1004 | Shoes                 |\n" +
                "|       1005 | Antique collection    |\n" +
                "|       1006 | Paintings             |\n" +
                "|       1007 | Alcohols              |\n" +
                "|       1008 | Swords                |\n" +
                "------------------------------------------");
        String category =sc.next();
        BuyerDao dao=new BuyerDaoImpl();
        try {
            List<SearchBuyer> list= dao.ViewAllBuyersDetails(category);
            System.out.println("-------------------------------------Search Buyer By Category Name----------------------------------------");

            System.out.println("---------------------------------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %20s %20s %13s %13s %10s","Id","BuyerName","email","ProductName","CategoryName","SellerId","Price");
            System.out.println();
            System.out.print("-------------------------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%7s %13s %20s %20s %13s %13s %10s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getProductName(),li.getCategoryName(), li.getSellerId(),li.getPrice());
                System.out.println();

            });
            System.out.println("------------------------------------------------------------------------------------------------------------");

        } catch (BuyerException e) {
            System.out.println( e.getMessage());
        }
    }
}
