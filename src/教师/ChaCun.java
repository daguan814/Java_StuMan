package 教师;

import loginmain.LianJie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: ChaCun
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/15  23:44
 */
public class ChaCun {
    public boolean ChaXue(String xuehao){


        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = " select  * from Stu where 学号='" + xuehao + "';";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
