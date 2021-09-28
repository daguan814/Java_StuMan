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
public class GaiPSW {//改密码的类
        public void xiugaimima(int xueORshi,String haoma ,String mima ){//传入参数
            LianJie lian = new LianJie();//连接数据库
            Connection conn = lian.lianjie();//连接数据库
            Statement stmt = null;//变量


                try {
                    stmt = conn.createStatement();//创建通道

                    if(xueORshi == 1 ){
                        String sql = "update stu set 密码  = '"+mima+"' where 学号 = '" + haoma+"';";//查询数据库学生
                        int rs = stmt.executeUpdate(sql);//执行更改
                    }else {
                        String sql = "update tea set 密码  = '"+mima+"' where 职工号 = '" + haoma+"';";//查询数据库老师
                        int rs = stmt.executeUpdate(sql);//执行更改
                    }



                } catch (SQLException e) {
                    e.printStackTrace();
                }







}}
