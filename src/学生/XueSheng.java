package 学生;

import 登录_Main.LianJie;
import 登录_Main.Login;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: XueSheng
 * @Description: 学生的主窗口
 * @author: 达观
 * @date: 2021/9/13  9:13
 */
public class XueSheng {
    JFrame jf = new JFrame("教务系统_登录");
    GridLayout wangge = new GridLayout(4, 2, 1, 100);

    public void showStu() {
        jf.setBounds(400, 100, 800, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义网格布局
        GridLayout buju = new GridLayout(4, 4, 1, 1);
        JPanel jp = new JPanel(buju);

        //将学生的信息提取出来
        Login login = new Login();
        String zhanghao = login.zhanghaofin;
        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();


        try {
            Statement stmt = conn.createStatement();
            String sql = " select  * from stu where 学号='" + zhanghao + "';";
            ResultSet rs = stmt.executeQuery(sql);
            //获取学生数据
            String[] X = new String[10];
            X[1] = rs.getString(1);
            X[3] = rs.getString(3);
            X[4] = rs.getString(4);
            X[5] = rs.getString(5);
            X[6] = rs.getString(6);
            X[7] = rs.getString(7);
            X[8] = rs.getString(8);

            X[1] = "学号：" + X[1];
            X[3] = "班级：" + X[3];
            X[4] = "姓名：" + X[3];
            X[5] = "性别：" + X[3];
            X[6] = "年龄：" + X[3];
            X[7] = "账号状态：" + X[3];



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        JLabel L1 = new JLabel("");


    }


}
