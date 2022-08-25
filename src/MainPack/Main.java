
package MainPack;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        Repository repo = new Repository();
        repo.getModelList().forEach(System.out::println);
        repo.getModelByID(3);
        String[] articuls = new String[] {"3251615"};
        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", articuls, 8);  
    }
}
