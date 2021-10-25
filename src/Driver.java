public class Driver {
    public static void main(String[] args) throws Exception {
        UserService userService=UserService.getInstance();
        InventoryService inventoryService=InventoryService.getInstance();
        GroceryService groceryService=GroceryService.getInstance();
        userService.addUser("Jhonny", "Flipkart Bellandur, Bangalore 560068",  600);
        userService.addUser("Naruto", "BTM Layout, Bengaluru, 560042", 500);
        userService.addUser("Goku", "Vijay Nagar, Indore, MP",  3000);
        inventoryService.addItem("Amul", "Milk", 100.0f);
        inventoryService.addItem("Amul", "Curd", 50.0f);
        inventoryService.addItem("Nestle", "Milk", 60.0f);
        inventoryService.addItem("Nestle", "Curd", 90.0f);
        inventoryService.addInventory( "Milk","Amul", 10);
        inventoryService.addInventory( "Milk","Nestle", 15);
        inventoryService.addInventory("Nestle", "Curd", 10);
        inventoryService.addInventory("Amul", "Milk", 10);
        inventoryService.addInventory("Amul", "Curd", 5);
        groceryService.addToCart("Jhonny", "Milk", "Nestle", 5);
        groceryService.addToCart("Goku", "Milk", "Nestle", 10);
        groceryService.checkout("Jhonny");
        groceryService.checkout("Naruto");
    }
}
