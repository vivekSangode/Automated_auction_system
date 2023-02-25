package usecases;



import java.time.LocalDate;
import java.util.Scanner;

import DAO.BuyerDao;
import DAO.BuyerDaoImpl;
import Exception.BuyerException;

public class BuyItemUseCase {
    public static void main(String[] args) {
        buyitem();
    }

    public static void buyitem(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter your BuyerId");
        int buyerId=sc.nextInt();
        System.out.println("Enter productName you want to buy");
        String productName=sc.next();
        LocalDate date= LocalDate.now();

        String result;
        BuyerDao dao=new BuyerDaoImpl();
        try {
            result= dao.BuyItem(buyerId,date,productName);
            System.out.println(result);
        } catch (BuyerException e) {
            result=e.getMessage();
            System.out.println(result);
        }

    }
}
