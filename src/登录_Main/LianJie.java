package 登录_Main;//导入包

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//
// Statement stmt = con.createStatement();
//         String sql = " update grade set C语言 = 20 where 学号=10309; ";
//         int rs = stmt.executeUpdate(sql);
/*
 * 数据库连接
 */
public class LianJie {

    public String chenggong;

    public Connection  lianjie() {

        Connection con = null;
        //jdbc驱动
        String driver = "com.mysql.cj.jdbc.Driver";
        //这里我的数据库
        String url = "jdbc:mysql://localhost:3306/Stu_Sx?&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "134652";
        try {
            //注册JDBC驱动程序
            Class.forName(driver);
            //建立连接
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()) {
             chenggong =   "数据库连接成功！";
                return con;
            }


        } catch (ClassNotFoundException e) {
            chenggong =   "数据库驱动没有安装！";
            return con;

        } catch (SQLException e) {
            e.printStackTrace();
            chenggong = "数据库连接失败！";
            return con;
        }
        return con;
    }}
