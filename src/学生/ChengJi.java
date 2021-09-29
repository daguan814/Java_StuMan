package 学生;

import loginmain.LianJie;
import loginmain.Login;

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

public class ChengJi {//成绩类


        JFrame jf = new JFrame("本学期成绩表");//创建窗口
        GridLayout buju = new GridLayout(7, 2, 0, 0);//设定布局大小
        JPanel jp = new JPanel(buju);//添加
        Login login = new Login();//调用登录的对象
        String zhanghao = login.zhanghaofin;//调用登录账号信息
        LianJie lian = new LianJie();//连接
        Connection conn = lian.lianjie();//连接
        Statement stmt = null;//通道


        public void chacheng(int xueqi) {
        jf.setBounds(800, 400, 500, 400);//设置窗口大小
        jf.setResizable(false);//不可调整
        jf.setVisible(true);//可见




        try {

            //获取数据库学生成绩数据
            stmt = conn.createStatement();
            String[] X = new String[10];
            String[] ke = new String[10];
            String sql;
            String diyi;

            //判断学期，然后进行操作
            if (xueqi == 1) {//上学期数据
                sql = " select  * from grade1 where 学号='" + zhanghao + "';";
                diyi = "当前学期：上学期";
                ke[1] = "C语言   ";
                ke[2] = "Python程序设计   ";
                ke[3] = "人工智能   ";
                ke[4] = "数据结构   ";
                ke[5] = "软件工程导论   ";
                ke[6] = "市场营销   ";
                ke[7] = "企业管理   ";


            } else {//下学期数据
                sql = " select  * from grade2 where 学号='" + zhanghao + "';";
                diyi = "当前学期：下学期";
                ke[1] = "高等数学1   ";
                ke[2] = "高等数学2   ";
                ke[3] = "概率论   ";
                ke[4] = "线性代数   ";
                ke[5] = "离散结构   ";
                ke[6] = "离散数学   ";
                ke[7] = "傅里叶级数   ";
            }
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {
                //是成绩表中的8个数据 对应上面
                X[1] = rs.getString(1);
                X[2] = rs.getString(2);
                X[3] = rs.getString(3);
                X[4] = rs.getString(4);
                X[5] = rs.getString(5);
                X[6] = rs.getString(6);
                X[7] = rs.getString(7);
                X[8] = rs.getString(8);
            }


            String xuehao = "当前登录学号：" + X[1];//当前登录学号

            //判断选修课选了没有或者考试了没有
            if (X[7]==null) {
                X[7] = " 未选";
            } else if (X[7].equals("0")) {
                X[7] = "未开始考试";
            }
            if (X[8]==null) {
                X[8] = " 未选";
            } else if (X[8].equals("0")) {
                X[8] = "未开始考试";
            }


            //创建组件并将组件定义 赋值
            JLabel L1 = new JLabel(diyi);
            JLabel L2 = new JLabel(xuehao);
            JLabel L3 = new JLabel("必修课成绩");
            JLabel L4 = new JLabel("选修课成绩");
            JLabel L5 = new JLabel(ke[1] + X[2]);
            JLabel L6 = new JLabel(ke[6] + X[7]);
            JLabel L7 = new JLabel(ke[2] + X[3]);
            JLabel L8 = new JLabel(ke[7] + X[8]);
            JLabel L9 = new JLabel(ke[3] + X[4]);
            JLabel L10 = new JLabel("");
            JLabel L11 = new JLabel(ke[4] + X[5]);
            JLabel L12 = new JLabel("");
            JLabel L13 = new JLabel(ke[5] + X[6]);
            JLabel L14 = new JLabel("");
//把组件添加进布局
            jp.add(L1);
            jp.add(L2);
            jp.add(L3);
            jp.add(L4);
            jp.add(L5);
            jp.add(L6);
            jp.add(L7);
            jp.add(L8);
            jp.add(L9);
            jp.add(L10);
            jp.add(L11);
            jp.add(L12);
            jp.add(L13);
            jp.add(L14);

            jf.add(jp);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    }

