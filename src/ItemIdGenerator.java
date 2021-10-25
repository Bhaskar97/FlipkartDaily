public class ItemIdGenerator {
    private static ItemIdGenerator itemIdGenerator=new ItemIdGenerator();
    private static Integer id=1;
    public Integer getId(){
        return id++;
    }
    public static ItemIdGenerator getInstance(){
        return itemIdGenerator;
    }
}
