package Main;

import usecases.BuyItemUseCase;
import usecases.BuyerLoginUsecase;
import usecases.BuyerRegistrationUseCase;
import usecases.SearchBuyerbyCategoryNameUseCase;
import usecases.SearchItembyCategoryListUseCase;

public class BuyerMain {
	public static boolean BuyerLogin(){
        BuyerLoginUsecase login=new BuyerLoginUsecase();
        boolean result=login.BuyerLogin();
        return result;
    }
    public static void BuyerHomeWindow() {
        System.out.println("Press 1 to Search and view Items by category");
        System.out.println("Press 2 to Selects Items to buy");
        System.out.println("Press 3 to Select and view all the buyers and also their Items category wise");
        System.out.println("Press 4 to LOGOUT AND RETURN TO HOMEPAGE");
    }
    public static void BuyerRegistration(){
        BuyerRegistrationUseCase register=new BuyerRegistrationUseCase();
        register.BuyerRegistraion();
    }
    public static void SearchItemCategory(){
        SearchItembyCategoryListUseCase searchItembyCategoryListUseCase=new SearchItembyCategoryListUseCase();
        searchItembyCategoryListUseCase.searchItemCategory();
    }
    public static void BuyItem(){
        BuyItemUseCase buyItemUseCase=new BuyItemUseCase();
        buyItemUseCase.buyitem();
    }
    public static void BuyerByCategory(){
        SearchBuyerbyCategoryNameUseCase searchBuyerbyCategoryNameUseCase=new SearchBuyerbyCategoryNameUseCase();
        searchBuyerbyCategoryNameUseCase.searchBuyerItembyCategory();
    }
}
