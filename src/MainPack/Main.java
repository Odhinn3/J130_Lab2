
package MainPack;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
        //создаем динамический массив позиций в заказе
        //массив и карта очищаются в конце работы метода regOrder
        ArrayList<String> articuls = new ArrayList<>();
        Map<String, Integer> orderpos = new HashMap<String, Integer>();
        //добавляем одну позицию
        orderpos.clear();
        articuls.clear();
        orderpos.put("3261615", 8);
        articuls.add("3251615");
        //регистрируем заказ с одной позицией
        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", articuls, orderpos);
        //добавляем две позиции
        orderpos.put("3251616", 10);
        articuls.add("3251616");
        orderpos.put("3251619", 10);
        articuls.add("3251619");
        //регистрируем заказ с двумя позициями
        repo.regOrder("TEST", "(921)000-00-00", "test@test.com", "TEST", articuls, orderpos);
        
    }
}
