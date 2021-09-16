package 登录_Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: YanZheng
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/12  14:12
 */
public class YanZheng {
    LianJie lian = new LianJie();
    Connection conn = lian.lianjie();
    Login login = new Login();

    Statement stmt;

    public String yanzheng() {
        String jieguo = null;

        String zhanghao = login.zhanghaofin;
        String mima = login.mimafin;
        try {

            stmt = conn.createStatement();
            String sql = " select  * from stu where 学号='"+zhanghao+"';";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()){
                String mimazhen = rs.getString(2);
                if (mimazhen.equals(mima)){
                    jieguo = "登录成功，身份是：学生";
                    return  jieguo;
                }else {
                    jieguo = "密码错误！";
                }


            }else {
                sql = " select  * from tea where 职工号='"  +zhanghao+ "';";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    String zhadmin = rs.getString(1);
                    String mimazhen = rs.getString(2);

                    if (mimazhen.equals(mima)) {
                        if (zhadmin.equals("001")) {
                            jieguo = "系统管理员，欢迎登录！";
                            return jieguo;
                        }
                        jieguo = "登录成功，身份是：教师";
                        return jieguo;

                    }else{ jieguo = "密码错误！";
                        return jieguo;}
                }
                jieguo = "该账号不存在！";
                return jieguo;
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();


        }

        return jieguo;
    }
}
