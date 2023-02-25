package Main;

import usecases.CreateProductListUseCase;
import usecases.DeleteProductItemUseCase;
import usecases.SellerLoginUseCase;
import usecases.SellerRegistrationUseCase;
import usecases.SoldItemHistoryListUseCase;
import usecases.UpdateProductPriceUseCase;

public class SellerMain {
	public static boolean SellerLogin(){
        SellerLoginUseCase login=new SellerLoginUseCase();
        boolean result=login.SellerLogin();
        return result;
    }
    public static void SellerHomeWindow() {
        System.out.println("Press 1 to Create list of items to sell");
        System.out.println("Press 2 to Update Item price");
        System.out.println("Press 3 to Remove items from the list");
        System.out.println("Press 4 to View the sold Item history" );
        System.out.println("Press 5 to LOGOUT AND RETURN TO HOMEPAGE");
    }
    public static void SellerRegistration(){
        SellerRegistrationUseCase register=new SellerRegistrationUseCase();
        register.SellerRegistraion();
    }
    public static void createListofProducts(){
        CreateProductListUseCase createProductListUseCase=new CreateProductListUseCase();
        createProductListUseCase.createProductList();
    }
    public static void updateProductList(){
        UpdateProductPriceUseCase updateProductPriceUseCase=new UpdateProductPriceUseCase();
        updateProductPriceUseCase.updateProductlist();
    }

    public static void deleteProductItem(){
        DeleteProductItemUseCase deleteProductItemUseCase=new DeleteProductItemUseCase();
        deleteProductItemUseCase.deleteProductitem();
    }
    public static void soldItemHistory(){
        SoldItemHistoryListUseCase soldItemHistoryListUseCase=new SoldItemHistoryListUseCase();
        soldItemHistoryListUseCase.soldItemHistory();
    }
}
