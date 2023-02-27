package usecases;



import java.util.List;
import java.util.Scanner;

import DAO.BuyerDao;
import DAO.BuyerDaoImpl;
import DTO.SoldItems;
import Exception.BuyerException;

public class SearchItembyCategoryListUseCase {
    public static void main(String[] args) {
        searchItemCategory();
    }
    public static void searchItemCategory(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Category Name from the below table to want to find list of products -\n" +
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
            List<SoldItems> list= dao.searchItemByCategory(category);
            System.out.println("-----------------------------Search Product By Category--------------------------");

            System.out.println("---------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %15s %15s %10s", "Id", "ProductName","SellerName","CategoryName","Price");
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %12s %12s %16s %13s",li.getProductId(),li.getProductName(),li.getSellerName(),li.getCategoryName(),li.getPrice());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------");

        } catch (BuyerException e) {
            System.out.println( e.getMessage());
        }
    }
}
