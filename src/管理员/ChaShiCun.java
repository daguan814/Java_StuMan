package 管理员;

import loginmain.LianJie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: ChaXueCun
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/16  22:16
 */
public class ChaShiCun {
    public boolean ChaCun(String haoma){


        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String sql = " select  * from tea where 职工号 ='" + haoma + "';";
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
