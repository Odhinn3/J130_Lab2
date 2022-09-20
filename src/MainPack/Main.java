
package MainPack;
import gui.MainFrame;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author A.Konnov <github.com/Odhinn3>
 */
public class Main {
    public static void main(String[] args) throws SQLException{
        //в БД из J130_1 сейчас 6 заказов с 8 позициями
//        Repository repo = new Repository();
//        Map<String, Integer> orderpos = new HashMap<String, Integer>();
//        //добавляем одну позицию
//        orderpos.put("3251615", 8);
//        //регистрируем заказ с одной позицией
//        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", orderpos);
//        //добавляем две позиции
//        orderpos.put("3251616", 10);
//        orderpos.put("3251619", 10);
//        //регистрируем заказ с двумя позициями
//        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", orderpos);
//        System.out.println("-----");
//        repo.getModelList("javadev.orders").forEach(System.out::println);
//        System.out.println("-----");
//        repo.getModelByID(7);
//        repo.getModelByID(8);
        MainFrame fr = new MainFrame();
    }
}