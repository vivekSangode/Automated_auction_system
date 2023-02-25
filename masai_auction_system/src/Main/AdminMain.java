package Main;

import usecases.AdminLoginUseCase;
import usecases.DailyDisputeReportUseCase;
import usecases.DailySellingReportUsecase;
import usecases.ResolveDisputeUseCase;
import usecases.ViewBuyerListUseCase;
import usecases.ViewSellerListUseCase;

public class AdminMain {
	public static boolean AdminLogin(){
        AdminLoginUseCase login=new AdminLoginUseCase();
        boolean result=login.adminLogin();
        return result;
    }
    public static void AdminHomeWindow() {
        System.out.println("Press 1 to View the registered buyer list");
        System.out.println("Press 2 to View the registered Seller list");
        System.out.println("Press 3 to View the daily selling report");
        System.out.println("Press 4 to View the daily dispute report");
        System.out.println("Press 5 to Solve the dispute report");
        System.out.println("Press 6 to LOGOUT AND RETURN TO HOMEPAGE");
    }
    public static void viewBuyers(){
        ViewBuyerListUseCase viewBuyerListUseCase=new ViewBuyerListUseCase();
        viewBuyerListUseCase.viewBuyerList();
    }
    public static void viewSellers(){
        ViewSellerListUseCase viewSellerListUseCase=new ViewSellerListUseCase();
        viewSellerListUseCase.viewSellerList();
    }
    public static void dailySellingReport(){
        DailySellingReportUsecase dailySellingReportUsecase=new DailySellingReportUsecase();
        dailySellingReportUsecase.dailySellingReport();
    }
    public static void dailyDisputeReport(){
        DailyDisputeReportUseCase dailyDisputeReportUseCase=new DailyDisputeReportUseCase();
        dailyDisputeReportUseCase.dailyDisputeReport();
    }
    public static void solveDispute(){
        ResolveDisputeUseCase resolveDisputeUseCase =new ResolveDisputeUseCase();
        resolveDisputeUseCase.disputeResolve();
    }

}
