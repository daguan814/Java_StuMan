package 登录_Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: GaiPSW
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/17  21:04
 */
public class GaiPSW {
        public void xiugaimima(int xueORshi,String haoma ,String mima ){
            LianJie lian = new LianJie();
            Connection conn = lian.lianjie();
            Statement stmt = null;


                try {
                    stmt = conn.createStatement();

                    if(xueORshi == 1 ){
                        String sql = "update stu set 密码  = '"+mima+"' where 学号 = '" + haoma+"';";
                        int rs = stmt.executeUpdate(sql);
                    }else {
                        String sql = "update tea set 密码  = '"+mima+"' where 职工号 = '" + haoma+"';";
                        int rs = stmt.executeUpdate(sql);
                    }



                } catch (SQLException e) {
                    e.printStackTrace();
                }







}}
