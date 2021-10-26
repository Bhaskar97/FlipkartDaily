public class Driver {
    public static void main(String[] args) throws Exception {
        UserService userService=UserService.getInstance();
        InventoryService inventoryService=InventoryService.getInstance();
        GroceryService groceryService=GroceryService.getInstance();
        userService.addUser("Jhonny", "Flipkart Bellandur, Bangalore 560068",  5.0f);
        userService.addUser("Naruto", "BTM Layout, Bengaluru, 560042", 500.0f);
        userService.addUser("Goku", "Vijay Nagar, Indore, MP",  3000.0f);
        inventoryService.addItem("Milk", "Amul", 100.0f);
        inventoryService.addItem("Curd", "Amul", 50.0f);
        inventoryService.addItem("Milk", "Nestle", 60.0f);
        inventoryService.addItem("Curd", "Nestle", 90.0f);
        inventoryService.addInventory( "Milk","Amul", 1);
        inventoryService.addInventory( "Milk","Nestle", 11);
        inventoryService.addInventory("Curd", "Nestle", 10);
        inventoryService.addInventory("Milk", "Amul", 10);
        inventoryService.addInventory("Curd", "Amul", 5);
        groceryService.addToCart("Jhonny", "Milk", "Nestle", 1);
        groceryService.addToCart("Jhonny","Curd","Amul",5);
        groceryService.display();
        groceryService.addToCart("Goku", "Milk", "Nestle", 10);
        groceryService.addToCart("Goku","Curd","Amul",5);
        groceryService.display();
        groceryService.updateItem("Amul", "Curd", 5);
        groceryService.display();
        groceryService.checkout("Jhonny");
        groceryService.checkout("Goku");
        groceryService.display();
    }
}
