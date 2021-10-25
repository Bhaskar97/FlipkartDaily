public class UserIdGenerator {
    private static UserIdGenerator userIdGenerator=new UserIdGenerator();
    private static Integer id=1;
    public Integer getId(){
        return id++;
    }
    public static UserIdGenerator getInstance(){
        return userIdGenerator;
    }
}
