package 教师;

import 学生.ChengJi;
import 登录_Main.LianJie;
import 登录_Main.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: JiaoShi
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/14  21:09
 */
public class JiaoShi {

    JFrame jf = new JFrame("教师系统");

    public void Jiaoshow() {
        jf.setBounds(400, 100, 800, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义网格布局
        GridLayout buju = new GridLayout(3, 3, 80, 80);
        JPanel jp = new JPanel(buju);

        //将学生的信息提取出来


        try {
            Login login = new Login();
            String zhanghao = login.zhanghaofin;
            LianJie lian = new LianJie();
            Connection conn = lian.lianjie();
            Statement stmt = conn.createStatement();
            String sql = " select  * from tea where 职工号 ='" + zhanghao + "';";
            ResultSet rs = stmt.executeQuery(sql);

            //获取老师数据
            String kehao1 = null;
            String kehao2 = null;
            String[] X = new String[10];
            if (rs.next()) {

                X[1] = rs.getString(1);
                X[3] = rs.getString(3);
                X[4] = rs.getString(4);
                kehao1 = rs.getString(5);
                kehao2 = rs.getString(6);

            }


            //对照老师教的什么科目
            sql = " select  * from cvk where 课号1 ='" + kehao1 + "' or 课号2 ='" + kehao1 + "' or 课号3 ='" + kehao1 + "'or 课号4 ='" + kehao1 + "';";
            rs = stmt.executeQuery(sql);
            String kechengming1 = null;
            if (rs.next()) {
                kechengming1 = rs.getString(1);

            }


            sql = " select  * from cvk where 课号1 ='" + kehao2 + "' or 课号2 ='" + kehao2 + "' or 课号3 ='" + kehao2 + "'or 课号4 ='" + kehao2 + "';";
            rs = stmt.executeQuery(sql);
            String kechengming2 = null;
            if (rs.next()) {
                kechengming2 = rs.getString(1);

            }

            X[1] = "职工号：" + X[1];
            X[3] = "姓名：" + X[3];
            X[4] = "性别：" + X[4];
            X[5] = "课号1：" + kehao1 +"   " +kechengming1 ;
            X[6] = "课号2：" + kehao2 +"   " +kechengming2;


//完成界面的组件
            JLabel L1 = new JLabel(X[1]);
            JLabel L2 = new JLabel(X[3]);
            JLabel L3 = new JLabel(X[4]);
            JLabel L4 = new JLabel("所教授课号：");
            JLabel L5 = new JLabel(X[5]);
            JLabel L6 = new JLabel(X[6]);
            JButton luchengji = new JButton("录所授成绩");  //按钮
            JButton kan = new JButton("看学生成绩");
            JButton gai = new JButton("修改密码");


            //字体改大一点
            Font zi = new Font("宋体", Font.TYPE1_FONT, 16);
            L1.setFont(zi);
            L2.setFont(zi);
            L3.setFont(zi);
            L4.setFont(zi);
            L5.setFont(zi);
            L6.setFont(zi);
            luchengji.setFont(zi);
            kan.setFont(zi);
            gai.setFont(zi);


            //添加进去
            jp.add(L1);
            jp.add(L2);
            jp.add(L3);
            jp.add(L4);
            jp.add(L5);
            jp.add(L6);

            jp.add(luchengji);
            jp.add(kan);
            jp.add(gai);

            jf.add(jp);


            //第二个窗口 确认是查第几个学期的成绩。
            JDialog jd = new JDialog(jf, "成绩");
            jd.setBounds(700, 400, 300, 200);


            //语句和按键  点击了录学生成绩就出现的窗口
            JPanel jp2 = new JPanel(new GridLayout(3, 1, 0, 0));
            JLabel xuanze = new JLabel("选择要查看学期的成绩：");
            JButton shang = new JButton("上学期");
            JButton xia = new JButton("下学期");


            //查成绩的按钮事件
            luchengji.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    jd.add(jp2);
                    jd.setVisible(true);
                }
            });


// 选课  （四选二）

            //点击上学期显示成绩
            ChengJi cha = new ChengJi();
            shang.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cha.chacheng(1);
                }
            });

            //点击下学期显示成绩
            ChengJi xiaxue = new ChengJi();
            xia.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xiaxue.chacheng(2);
                }
            });


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
