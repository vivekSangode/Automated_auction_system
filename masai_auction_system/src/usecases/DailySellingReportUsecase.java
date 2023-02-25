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
            System.out.println("---------------------Daily Selling Report--------------------------");

            System.out.println("---------------------------------------------------------------------------------------------");

            System.out.printf("%7s %13s %12s %15s %10s %13s %10s", "Id", "BuyerName","email","ProductName","CategoryName","SellerName","Price");
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%2s %10s %18s %12s %12s %11s %12s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getProductName(),li.getSellerId(),li.getPrice());
                System.out.println();

            });
            System.out.println("-------------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println( e.getMessage() );
        }
    }
}
