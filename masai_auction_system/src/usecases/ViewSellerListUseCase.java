package usecases;



import java.util.List;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import DTO.Seller;
import Exception.AdminException;

public class ViewSellerListUseCase {
    public static void main(String[] args) {
        viewSellerList();
    }
    public static void viewSellerList(){
        AdminDao dao=new AdminDaoImpl();
        try {
            List<Seller> list=dao.ViewSellers();
            System.out.println("-----------------------------Table of all the Sellers-------------------------------");

            System.out.println("------------------------------------------------------------------------------------");

            System.out.printf("%7s %12s %20s %25s","SellerId", "SellerName","Email", "Location" );
            System.out.println();
            System.out.print("---------------------------------------------------------------------------------------");

            System.out.println();
            list.forEach(li->{
                System.out.format("%7s %12s %20s %25s",li.getSellerId(),li.getSellerName(),li.getEmail(),li.getLocation());
                System.out.println();

            });
            System.out.println("---------------------------------------------------------------------------------------");

        } catch (AdminException e) {
            System.out.println(e.getMessage());
        }
    }
}
