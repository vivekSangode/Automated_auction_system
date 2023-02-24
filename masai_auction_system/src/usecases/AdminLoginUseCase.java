package usecases;

import java.util.Scanner;

import DAO.AdminDao;
import DAO.AdminDaoImpl;
import Exception.CredentialException;

public class AdminLoginUseCase {

    public static boolean adminLogin(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Email-");
        String email=sc.next();
        System.out.println("Enter Password-");
        String password=sc.next();

        String result;
        AdminDao dao=new AdminDaoImpl();
        try {
            result=dao.AdminLogin(email,password);
            System.out.println(result);
            return true;
        } catch (CredentialException e) {
            result = e.getMessage();
            System.out.println(result);
            return false;
        }
    }
}
