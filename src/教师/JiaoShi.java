package 教师;

import 学生.ChengJi;
import 登录_Main.GaiPSW;
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
            String temp = X[1]; //给修改密码用
            X[1] = "职工号：" + X[1];
            X[3] = "姓名：" + X[3];
            X[4] = "性别：" + X[4];
            X[5] = "课号1：" + kehao1 + "   " + kechengming1;
            X[6] = "课号2：" + kehao2 + "   " + kechengming2;


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


            // 第一窗口的组件添加进去
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

            //查看学生成绩窗口
            //第二个窗口 录成绩的窗口   语句和按键  点击了录学生成绩就出现的窗口
            JDialog chakan = new JDialog(jf, "查看学生成绩");
            chakan.setBounds(400, 400, 400, 200);

            JPanel jp3 = new JPanel(new GridLayout(2, 1, 80, 80));
            JTextField kan_ming = new JTextField("请输入所授课程名");
            JButton kan_bu = new JButton("确认");
            jp3.add(kan_ming);
            jp3.add(kan_bu);
//点击查看学生成绩后出现的输入窗口
            String finalKechengming1 = kechengming1;
            String finalKechengming3 = kechengming2;

            //唤起写课程名的窗口
            kan.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chakan.add(jp3);
                    chakan.setVisible(true);
                }
            });

            kan_bu.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (kan_ming.getText().equals(finalKechengming1)||kan_ming.getText().equals(finalKechengming3)){
                        //唤起一个只有文本域的窗口专门显示其成绩  按钮显示提示
                        kan_bu.setText("查询成功！");
                        KanJi kj =new KanJi();
                        kj.Kanchengji(kan_ming.getText());

                    }else{
                        kan_bu.setText("您还没有教授这门课！");
                    }
                }
            });






            //第二个窗口 录成绩的窗口   语句和按键  点击了录学生成绩就出现的窗口
            JDialog jd = new JDialog(jf, "录入学生成绩");
            jd.setBounds(400, 400, 500, 400);

            JPanel jp2 = new JPanel(new GridLayout(4, 1, 80, 80));
            JTextField keming = new JTextField("请输入所授课程名");
            JTextField haoma = new JTextField("请输入该生学号");
            JTextField cheng = new JTextField("请输入该生成绩");
            JButton queren = new JButton("确认");

            jp2.add(keming);
            jp2.add(haoma);
            jp2.add(cheng);
            jp2.add(queren);


            //录入成绩的按钮事件
            luchengji.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jd.add(jp2);
                    jd.setVisible(true);


                }
            });

            //点击了确认就开始验证课程名 然后写成绩
//            教师不使用课号录入成绩的原因：1. 没有必要，会增加数据库的学生和课号的对照表。 2.如果管理员分配课号在 CVK中没有
//                    使用课号将会出现bug

            ChaCun cha = new ChaCun();
            sql = " select  * from tea where 职工号 ='" + zhanghao + "';";
            rs = stmt.executeQuery(sql);

            String finalKechengming2 = kechengming1;
            String finalKechengming = kechengming2;
            queren.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String km = keming.getText();  //点击了按钮再去验证

                    int flag = 1;
                    if (!km.equals(finalKechengming) && !km.equals(finalKechengming2)) {
                        keming.setText("您没有教授这门课！") ;
                    flag = 0;
                    }
                        ;

                     //判断这个人学号存不存在
                    if (!cha.ChaXue(haoma.getText())) {
                        //如果不存在
                        haoma.setText("没有这个学生！");
                        flag = 0;
                    }

                    if(flag == 1){   //通过所有验证 写入数据
                       int x =  Integer.parseInt(cheng.getText());

                        String sql = " update  grade1 set "  + km+  " = " + x + "  where 学号 = '"+haoma.getText()+"';";
                        try {
                            int rs = stmt.executeUpdate(sql);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        queren.setText("录入成功！");
                    }


                }
            });

            //修改密码
            JDialog jd1 = new JDialog(jf, "修改密码");
            jd1.setBounds(400, 400, 300, 200);

            JPanel jp5 = new JPanel(new GridLayout(2, 1, 60, 60));
            JTextField mima = new JTextField("请输入新密码");
            JButton ok = new JButton("确认");
            jp5.add(mima);
            jp5.add(ok);
            jd1.add(jp5);



            gai.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jd1.setVisible(true);
                    ok.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            GaiPSW gai = new GaiPSW();
                            gai.xiugaimima(2,temp,mima.getText());
                            ok.setText("修改成功");
                        }
                    });

                }
            });


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
