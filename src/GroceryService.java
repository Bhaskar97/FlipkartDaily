import java.util.*;

public class GroceryService {
    Map<Integer,User> userMap=new HashMap<>();
    Map<String,Integer> nameMap=new HashMap<>();
    Map<Integer,Item> itemMap=new HashMap<>();
    Map<String,Integer> brandMap=new HashMap<>();

    private UserIdGenerator userIdGenerator=UserIdGenerator.getInstance();

    private ItemIdGenerator itemIdGenerator=ItemIdGenerator.getInstance();

    private static GroceryService groceryService=new GroceryService();

    public static GroceryService getInstance(){
        return groceryService;
    }

    public User addUser(String name,String address,Float number){
        if(!nameMap.containsKey(name)) {
            User user=new User();
            user.setId(userIdGenerator.getId());
            user.setName(name);
            user.setNumber(number);
            user.setAddress(address);
            user.setCart(new ArrayList<>());
            userMap.put(user.getId(),user);
            nameMap.put(name,user.getId());
            System.out.println("User added with name - "+name+ ", userId - "+user.getId());
            return user;
        }
        System.out.println("User already present for this name");
        return null;
    }

    public Item addItem(String brand,Float price,String category){
        String key=brand+"_"+category;
        if(brandMap.containsKey(key)){
            System.out.println("An item with brand "+brand+" and category "+category+" already exists ..");
            return null;
        }
        else{
            Item item=new Item();
            item.setBrand(brand);
            item.setCategory(category);
            item.setPrice(price);
            item.setId(itemIdGenerator.getId());
            String id=brand+"_"+category;
            brandMap.put(id,item.getId());
            itemMap.put(item.getId(),item);
            System.out.println("Item with brand - "+ brand+" and  category - "+ category +" added ...");
            return item;
        }
    }

    public void setPrice(String category,String brand, Float price){
        String key=brand+"_"+category;
        if(brandMap.containsKey(key)){
            Integer id=brandMap.get(key);
            Item item=itemMap.get(id);
            Float p=item.getPrice();
            item.setPrice(price);
            System.out.print(" Price for item "+key+" is updated from "+p+" to "+price);
        }
        else{
            System.out.println("No item present for the given category and brand ...");
        }
    }

    public void addInventory(String category,String brand, Integer quantity){
        String key=brand+"_"+category;
        if(brandMap.containsKey(key)){
            Integer id=brandMap.get(key);
            Item item=itemMap.get(id);
            Integer q=item.getQuantity();
            item.setQuantity(item.getQuantity()+quantity);
            itemMap.put(item.getId(),item);
            System.out.println("Quantity for item "+key.split("_")[0]+" "+key.split("_")[0]+" is updated from "+q+" to "+quantity+" ...");
        }
        else{
            System.out.println("No item present for the given category and brand ...");
        }
    }

    public void addToCart(String name,String category,String brand,Integer quantity){
        if(nameMap.containsKey(name)){
            Integer userId=nameMap.get(name);
            User user=userMap.get(userId);
            String key=brand+"_"+category;
            if(brandMap.containsKey(key)){
                Integer id=brandMap.get(key);
                Item item=itemMap.get(id);
                if(item.getQuantity()>=quantity){
                    Item item1=new Item();
                    item1.setBrand(item.getBrand());
                    item1.setCategory(item.getCategory());
                    item1.setPrice(item.getPrice());
                    item1.setId(itemIdGenerator.getId());
                    item1.setQuantity(quantity);
                    user.getCart().add(item1);
                    userMap.put(user.getId(),user);
                    System.out.println("Item added in the cart for user "+name+" ....");
                }
                else{
                    System.out.println("The required quantity of teh item is not present currently ..");
                    System.out.println("You can currently order - "+item.getQuantity()+" many items ...");
                }
            }
            else{
                System.out.println("No item present for this category and brand ...");
            }
        }
        else{
            System.out.println("User not present for name - "+name);
        }
    }

    public void checkout(String name) throws Exception {
        if(nameMap.containsKey(name)){
            Integer userId=nameMap.get(name);
            User user=userMap.get(userId);
            List<Item> cart=user.getCart();
            Float total= Float.valueOf(0);
            for(Item item: cart){
                String key=item.getBrand()+"_"+item.getCategory();
                Integer id=brandMap.get(key);
                Item inventoryItem=itemMap.get(id);
                if(inventoryItem.getPrice()==item.getPrice()){
                    if(inventoryItem.getQuantity()>=item.getQuantity()){
                        inventoryItem.setQuantity(inventoryItem.getQuantity()-item.getQuantity());
                        total+=item.getPrice()*item.getQuantity();
                    }
                    else{
                        user.setCart(new ArrayList<>());
                        throw new Exception("Your inventory has expired please add items again ...");
                    }
                }
                else{
                    user.setCart(new ArrayList<>());
                    throw new Exception("Your inventory has expired please add items again ...");
                }
            }
            if(user.getNumber()>=total) {
                System.out.println("Your total for the items in inventory is - " + total + " thank you for shopping with us ...");
                user.setNumber(user.getNumber()-total);
            }
            else{
                System.out.println("Your wallet balance is low i.e - "+user.getNumber());
            }
        }
        else{
            System.out.println("User not present for name - "+name);
        }
    }

    public void display(){
        for(Map.Entry<String,Integer> entry: brandMap.entrySet()){
            Integer id=brandMap.get(entry.getKey());
            System.out.println(entry.getKey().split("_")[0]+" -> "+entry.getKey().split("_")[1]+" -> "+itemMap.get(id).getQuantity());
        }
    }

    public void updateItem(String brand,String category,Integer quantity){
        String key=brand+"_"+category;
        if(brandMap.containsKey(key)){
            Integer id=brandMap.get(key);
            Item item=itemMap.get(id);
            item.setQuantity(item.getQuantity()+quantity);
            itemMap.put(item.getId(),item);
            System.out.println("Item updated "+key+" with quantity "+quantity+" ...");
        }
        else{
            System.out.println("Item not present with these fields");
        }
    }


}
