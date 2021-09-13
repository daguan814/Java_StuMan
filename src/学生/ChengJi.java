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
 * @ClassName: ChengJi
 * @Description: 查成绩
 * @author: 达观
 * @date: 2021/9/13  19:09
 */

public class ChengJi {
    static JFrame jf = new JFrame("本学期成绩表");

    public void chashang(int xueqi) {
        jf.setBounds(800, 400, 500, 400);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GridLayout buju = new GridLayout(7, 2, 80, 80);
        JPanel jp = new JPanel(buju);
        Login login = new Login();
        String zhanghao = login.zhanghaofin;
        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = null;

        try {

            //获取学生成绩数据
            stmt = conn.createStatement();
            String[] X = new String[10];
            String[] ke = new String[10];
            String sql;
            String diyi;

            //判断学期，然后进行操作
            if (xueqi == 1) {
                sql = " select  * from grade1 where 学号='" + zhanghao + "';";
                diyi = "当前学期：上学期";
                ke[1] = "C语言 ";
                ke[2] = "Python程序设计 ";
                ke[3] = "人工智能 ";
                ke[4] = "数据结构 ";
                ke[5] = "软件工程导论 ";
                ke[6] = "市场营销 ";
                ke[7] = "企业管理 ";


            } else {
                sql = " select  * from grade2 where 学号='" + zhanghao + "';";
                diyi = "当前学期：下学期";
                ke[1] = "高等数学1 ";
                ke[2] = "高等数学2 ";
                ke[3] = "概率论 ";
                ke[4] = "线性代数 ";
                ke[5] = "离散结构 ";
                ke[6] = "离散数学 ";
                ke[7] = "傅里叶级数 ";
            }
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {
                //是成绩表中的8个数据
                X[1] = rs.getString(1);
                X[2] = rs.getString(2);
                X[3] = rs.getString(3);
                X[4] = rs.getString(4);
                X[5] = rs.getString(5);
                X[6] = rs.getString(6);
                X[7] = rs.getString(7);
                X[8] = rs.getString(8);
            }


            String xuehao = "当前登录学号：" + X[1];

            //判断选修课选了没有或者考试了没有
            if (X[7].equals(null)) {
                X[7] = " 未选";
            } else if (X[7].equals(0)) {
                X[7] = "旷考";
            }
            if (X[8].equals(null)) {
                X[8] = " 未选";
            } else if (X[8].equals(0)) {
                X[8] = "旷考";
            }


            //将组件定义
            JLabel L1 = new JLabel(diyi);
            JLabel L2 = new JLabel(xuehao);
            JLabel L3 = new JLabel("必修课成绩");
            JLabel L4 = new JLabel("选修课成绩");
            JLabel L5 = new JLabel("C语言" + X[2]);
            JLabel L6 = new JLabel("市场营销" + X[7]);
            JLabel L7 = new JLabel(X[6]);
            JLabel L8 = new JLabel(X[7]);
            JButton chachengji = new JButton("查看成绩");
            JLabel L10 = new JLabel("");
            JLabel L11 = new JLabel("");
            JLabel L12 = new JLabel("");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {
        jf.setBounds(800, 400, 500, 400);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
