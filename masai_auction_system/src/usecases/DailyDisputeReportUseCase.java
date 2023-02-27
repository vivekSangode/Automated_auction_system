package usecases;


import java.util.List;
import java.util.Scanner;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import DTO.Product;
import Exception.AdminException;

public class DailyDisputeReportUseCase {
    public static void main(String[] args) {
        dailyDisputeReport();
    }
    public static void dailyDisputeReport(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter date you want to find dispute list of");
        String date=sc.next();
        AdminDao dao=new AdminDaoImpl();
        try {
            List<Product> list= dao.DailyDisputeReport(date);
            System.out.println("------------------------------Date Wise Dispute Report----------------------------------");

            System.out.println("---------------------------------------------------------------------------------------------");

            System.out.printf("%7s %18s %7s %7s %12s","Id", "ProductName","SellerId","CategoryId","Price");
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%7s %18s %7s %7s %17s",li.getProductId(),li.getProductName(),li.getSellerId(),li.getCategoryId(),li.getPrice());
                System.out.println();

            });
            System.out.println("-------------------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println( e.getMessage() );
        }
    }
}
