package loginmain;

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
    LianJie lian = new LianJie();//连接
    Connection conn = lian.lianjie();//连接
    Login login = new Login();//创建登录窗口的对象

    Statement stmt;//通道变量

    public String yanzheng() {//验证函数
        String jieguo = null;//验证结果

        String zhanghao = login.zhanghaofin;//获取登陆的账号
        String mima = login.mimafin;//获取登陆的密码
        try {

            stmt = conn.createStatement();//创建通道
            String sql = " select  * from stu where 学号='"+zhanghao+"';";//查询语句 学号
            ResultSet rs = stmt.executeQuery(sql);//执行

            if (rs.next()){
                String mimazhen = rs.getString(2);//将第二列的数值给密码
                if (mimazhen.equals(mima)){//判断密码是否正确
                    jieguo = "登录成功，身份是：学生";
                    return  jieguo;
                }else {
                    jieguo = "密码错误！";
                }


            }else {
                sql = " select  * from tea where 职工号='"  +zhanghao+ "';";//查询语句 老师
                rs = stmt.executeQuery(sql);//执行
                if (rs.next()) {
                    String zhadmin = rs.getString(1);//将第一列的数值给密码
                    String mimazhen = rs.getString(2);//将第二列的数值给密码

                    if (mimazhen.equals(mima)) {//判断密码是否正确
                        if (zhadmin.equals("admin")) {
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
