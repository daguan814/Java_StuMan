package 学生;

import 教师.ChaCun;
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
 * @ClassName: XueSheng
 * @Description: 学生的主窗口
 * @author: 达观
 * @date: 2021/9/13  9:13
 */
public class XueSheng {
    JFrame jf = new JFrame("学生信息");

    public void showStu() {
        jf.setBounds(400, 100, 800, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义网格布局
        GridLayout buju = new GridLayout(3, 4, 80, 80);
        JPanel jp = new JPanel(buju);

        //将学生的信息提取出来


        try {
            Login login = new Login();
            String zhanghao = login.zhanghaofin;
            LianJie lian = new LianJie();
            Connection conn = lian.lianjie();
            Statement stmt = conn.createStatement();
            String sql = " select  * from stu where 学号='" + zhanghao + "';";
            ResultSet rs = stmt.executeQuery(sql);
            //获取学生数据
            String[] X = new String[10];
            if (rs.next()) {

                X[1] = rs.getString(1);
                X[3] = rs.getString(3);
                X[4] = rs.getString(4);
                X[5] = rs.getString(5);
                X[6] = rs.getString(6);
                X[7] = rs.getString(7);
                X[8] = rs.getString(8);
            }

            String temp = X[1];
            X[1] = "学号：" + X[1];
            X[3] = "班级：" + X[3];
            X[4] = "姓名：" + X[4];
            X[5] = "性别：" + X[5];
            X[6] = "年龄：" + X[6];
            X[7] = "账号状态：" + X[7];
            X[8] = "选修：" + X[8];


            JLabel L1 = new JLabel(X[1]);
            JLabel L2 = new JLabel(X[3]);
            JLabel L3 = new JLabel(X[8]);
            JLabel L4 = new JLabel("");
            JLabel L5 = new JLabel(X[4]);
            JLabel L6 = new JLabel(X[5]);
            JLabel L7 = new JLabel(X[6]);


            JLabel L8 = new JLabel(X[7]);
            JButton chachengji = new JButton("查看成绩");  //第一个按钮
            JButton Xuan = new JButton("选课");
            JButton tui = new JButton("刷新");
            JButton gai = new JButton("修改密码");


            //字体改大一点
            Font zi = new Font("宋体", Font.TYPE1_FONT, 16);
            L1.setFont(zi);
            L2.setFont(zi);
            L3.setFont(zi);
            L4.setFont(zi);
            L5.setFont(zi);
            L6.setFont(zi);
            L7.setFont(zi);
            L8.setFont(zi);
            gai.setFont(zi);
            tui.setFont(zi);
            Xuan.setFont(zi);
            chachengji.setFont(zi);



            //添加进去
            jp.add(L1);
            jp.add(L2);
            jp.add(L3);
            jp.add(L4);
            jp.add(L5);
            jp.add(L6);
            jp.add(L7);
            jp.add(L8);
            jp.add(chachengji);
            jp.add(Xuan);
            jp.add(gai);
            jp.add(tui);
            jf.add(jp);


            //第二个窗口 确认是查第几个学期的成绩。
            JDialog jd = new JDialog(jf, "成绩");
            jd.setBounds(800, 400, 300, 200);


            //语句和按键  选择上学期或下学期
            JPanel jp2 = new JPanel(new GridLayout(3, 1, 0, 0));
            JLabel xuanze = new JLabel("选择要查看学期的成绩：");
            JButton shang = new JButton("上学期");
            JButton xia = new JButton("下学期");


            //查成绩的按钮事件
            chachengji.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (X[7].equals("账号状态：可用")) {
                        jp2.add(xuanze);
                        jp2.add(shang);
                        jp2.add(xia);

                    } else {
                        xuanze.setText("您已毕业或者被管理员禁用故无法进行任何操作！");
                        jp2.add(xuanze);
                    }

                    jd.add(jp2);
                    jd.setVisible(true);
                }
            });




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
                            gai.xiugaimima(1,temp,mima.getText());
                            ok.setText("修改成功");
                        }
                    });

                }
            });



//刷新页面
            tui.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jf.setVisible(false);
                    XueSheng xue = new XueSheng();
                    xue.showStu();
                }
            });


            //选课

            JDialog jd9 = new JDialog(jf, "选本学期课程");
            jd1.setBounds(700, 400, 300, 200);

            JPanel jp3 = new JPanel(new GridLayout(2, 1, 60, 60));
            JTextField jf1 = new JTextField("");
            JButton  jb11= new JButton("确认");
            jp3.add(jf1);
            jp3.add(jb11);
            jd1.add(jp3);

            //选课
            Xuan.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jf1.setText("请输入课名");

                    jb11.setText("确认");
                    jd1.setVisible(true);
                    ChaCun cha = new ChaCun();

                    jb11.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(cha.ChaXue(temp)){

                                if(jf1.getText().equals("市场营销")||jf1.getText().equals("企业管理")){
                                    LianJie lian = new LianJie();
                                    Connection conn = lian.lianjie();
                                    Statement stmt = null;

                                    try {
                                        stmt = conn.createStatement();
                                        //学生表 增加一个数据
                                        String sql = "update stu set 选修  = '"+jf1.getText()+"' where 学号 = '" + temp+"';";
                                        int rs = stmt.executeUpdate(sql);
                                        //成绩表 增加一个成绩
                                        sql = "update grade1 set "+jf1.getText()+ " = '0'  where 学号 = '" + temp+"';";
                                        rs = stmt.executeUpdate(sql);

                                        jb11.setText("选课成功!");

                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }


                                }else{jb11.setText("本学期不可选此课"); }

                            }
                            else {
                                jb11.setText("该学生不存在!");
                            }
                        }


                    });
                }
            });






        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }


}
