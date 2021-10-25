public class UserService {
    private static UserService userService=new UserService();
    private GroceryService groceryService=GroceryService.getInstance();
    private static Integer id=1;
    private Integer getId(){
        return id++;
    }

    public static UserService getInstance(){
        return userService;
    }

    public User addUser(String name,String address,Integer number){
        return groceryService.addUser(name,address, number);
    }

}
