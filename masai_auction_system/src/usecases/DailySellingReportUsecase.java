package usecases;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import DTO.SearchBuyerImpl;
import Exception.AdminException;

public class DailySellingReportUsecase {
    public static void main(String[] args) {
        dailySellingReport();
    }
    public static void dailySellingReport(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter date you want to find list of sold items");
        String date=sc.next();
        AdminDao dao=new AdminDaoImpl();
        try {
            List<SearchBuyerImpl> list= dao.DailySellingReport(date);
            System.out.println("---------------------------------Daily Selling Report-------------------------------------");

            System.out.println("-------------------------------------------------------------------------------------------------------");

            System.out.printf("%7s %15s %20s %20s %15s %7s %12s", "Id", "BuyerName","email","ProductName","CategoryName","SellerID","Price");
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%7s %15s %20s %20s %15s %7s %15s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getProductName(),li.getCategoryName(),li.getSellerId(),li.getPrice());
                System.out.println();

            });
            System.out.println("------------------------------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println( e.getMessage() );
        }
    }
}
