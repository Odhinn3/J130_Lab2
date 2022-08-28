
package MainPack;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        //в БД из J130_1 сейчас 6 заказов с 8 позициями
        Repository repo = new Repository();
        repo.getModelList().forEach(System.out::println);
        repo.getModelByID(3);
        ArrayList<String> articuls = new ArrayList<String>();
        articuls.add("3251615");
        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", articuls, 8);
        articuls.add("3251616");
        articuls.add("3251619");
        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", articuls, 8);
        
    }
}
