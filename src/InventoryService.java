public class InventoryService {
    private static InventoryService inventoryService=new InventoryService();
    private GroceryService groceryService=GroceryService.getInstance();

    public static InventoryService getInstance(){
        return inventoryService;
    }

    public Item addItem(String category,String brand,Float price){
        if(brand==null || category==null || price <=0){
            System.out.println("Invalid item fields ...");
            return null;
        }
        return groceryService.addItem(brand, price,category);
    }

    public void setPrice(String category,String brand, Float price){
        if(brand!=null || category!=null || price<=0){
            groceryService.setPrice(category, brand, price);
        }
        else{
            System.out.println("Invalid input provided...");
        }
    }

    public void addInventory(String category,String brand, Integer quantity){
        if(brand!=null || category!=null || quantity<=0){
            groceryService.addInventory(category, brand, quantity);
        }
        else{
            System.out.println("Invalid input provided...");
        }
    }

}
