package 管理员;

import 登录_Main.LianJie;
import 登录_Main.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: ChongZhi
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/16  22:07
 */
public class ChongZhi {


    public void Chong(String haoma,String mima,String xueORshi,String biao) {

        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();


            //重置密码

            String sql = " update "+ biao+ " set  密码 =  " + mima + " where  " +xueORshi +  " = " + haoma + ";";
            int rs = stmt.executeUpdate(sql);




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
