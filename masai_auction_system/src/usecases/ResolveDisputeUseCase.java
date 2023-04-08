package usecases;


import java.util.Scanner;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import Exception.AdminException;

public class ResolveDisputeUseCase {
    public static void main(String[] args) {
        disputeResolve();
    }

    public static void disputeResolve(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter productId of product you want to solve dispute of");
        int productId=sc.nextInt();
        System.out.println("Enter the correct category Id from the below table- \n"+
        		"|       1001 | Bikes                 |\n" +
                "|       1002 | Cars                  |\n" +
                "|       1003 | Watches               |\n" +
                "|       1004 | Shoes                 |\n" +
                "|       1005 | Antique collection    |\n" +
                "|       1006 | Paintings             |\n" +
                "|       1007 | Alcohols              |\n" +
                "|       1008 | Swords                |\n" +
                "------------------------------------------");
        int categoryId=sc.nextInt();

        String result;
        AdminDao dao=new AdminDaoImpl();
        try {
            result= dao.SolveDispute(categoryId, productId);
            System.out.println(result );
        } catch (AdminException e) {
            result=e.getMessage();
            System.out.println(result);
        }

    }
}
