package usecases;


import java.util.List;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import DTO.Buyer;
import Exception.AdminException;

public class ViewBuyerListUseCase {
    public static void main(String[] args) {
        viewBuyerList();
    }
    public static void viewBuyerList(){
        AdminDao dao=new AdminDaoImpl();
        try {
            List<Buyer> list=dao.ViewBuyers();
            System.out.println("-------------------------------Table of all the Buyers----------------------------------");

            System.out.println("------------------------------------------------------------------------------------");

            System.out.printf("%7s %14s %20s %25s", "BuyerId", "BuyerName","Email", "Location" );
            System.out.println();
            System.out.print("--------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%7s %14s %20s %25s",li.getBuyerId(),li.getBuyerName(),li.getEmail(),li.getLocation());
                System.out.println();

            });
            System.out.println("-------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println( e.getMessage() );
        }
    }
}
