package 管理员;

import 教师.ChaCun;
import loginmain.LianJie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: Admin
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/14  21:12
 */
public class Admin {
    JFrame jf = new JFrame("管理员操作台");

    public void Adminshow() {
        jf.setBounds(400, 100, 800, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义网格布局
        GridLayout buju = new GridLayout(3, 3, 80, 80);
        JPanel jp = new JPanel(buju);

        //布局
        JLabel L1 = new JLabel("");
        JLabel L2 = new JLabel("管理员控制台");
        JLabel L3 = new JLabel("");
        JLabel L4 = new JLabel("          重置密码");
        JButton jb1 = new JButton("重置教师");
        JButton jb2 = new JButton("重置学生");
        JLabel L5 = new JLabel("          配置课程");
        JButton jb3 = new JButton("为老师配课");
        JButton jb4 = new JButton("为学生选课");


        Font zi = new Font("宋体", Font.TYPE1_FONT, 30);

        L2.setFont(zi);

        Font xi = new Font("宋体", Font.TYPE1_FONT, 20);
        L4.setFont(xi);
        L5.setFont(xi);


        jp.add(L1);
        jp.add(L2);
        jp.add(L3);
        jp.add(L4);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(L5);
        jp.add(jb3);
        jp.add(jb4);


        jf.add(jp);


        //教师的重置界面
        JDialog jdj = new JDialog(jf, "重置教师密码");
        jdj.setBounds(700, 400, 300, 200);
        //语句和按键 重置密码操作

        JPanel jpj = new JPanel(new GridLayout(2, 1, 40, 70));
        JTextField jtj = new JTextField("请输入职工号");
        JButton jbj = new JButton("确认");
        jpj.add(jtj);
        jpj.add(jbj);
        jdj.add(jpj);


        //学生的重置界面
        JDialog jdx = new JDialog(jf, "重置学生密码");
        jdx.setBounds(700, 400, 300, 200);
        //语句和按键 重置密码操作

        JPanel jpx = new JPanel(new GridLayout(2, 1, 40, 70));
        JTextField jtx = new JTextField("请输入学号");
        JButton jbx = new JButton("确认");
        jpx.add(jtx);
        jpx.add(jbx);
        jdx.add(jpx);


        //重置教师密码
        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {


                jdj.setVisible(true);
                ChaShiCun cha = new ChaShiCun();


                jbj.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cha.ChaCun(jtj.getText())) {
                            jbj.setText("重置成功!");
                            ChongZhi chong = new ChongZhi();
                            chong.Chong(jtj.getText(), "123456", "职工号", "tea");
                        } else {
                            jbj.setText("该老师不存在!");
                        }
                    }


                });

            }
        });

        //重置学生的密码
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jdx.setVisible(true);
                ChaCun cha = new ChaCun();


                //为二级菜单添加确认

                jbx.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cha.ChaXue(jtx.getText())) {
                            jbx.setText("重置成功!");
                            ChongZhi chong = new ChongZhi();
                            chong.Chong(jtx.getText(), "123123", "学号", "stu");
                        } else {
                            jbx.setText("该学生不存在!");
                        }
                    }


                });

            }
        });


// 配置课程
//配置教师课程的界面
        JDialog jdo = new JDialog(jf, "配置课程");
        jdo.setBounds(700, 400, 300, 200);

        JPanel jpo = new JPanel(new GridLayout(3, 1, 0, 0));
        JTextField jfo1 = new JTextField("请输入教师职工号");
        JTextField jfo2 = new JTextField("请输入课号");
        JButton jbo = new JButton("确认");
        jpo.add(jfo1);
        jpo.add(jfo2);
        jpo.add(jbo);
        jdo.add(jpo);

        //配置学生课程的界面
        JDialog jdp = new JDialog(jf, "配置课程");
        jdp.setBounds(700, 400, 300, 200);

        JPanel jpp = new JPanel(new GridLayout(3, 1, 0, 0));
        JTextField jfp1 = new JTextField("请输入学号");
        JTextField jfp2 = new JTextField("请输入课程名");
        JButton jbp = new JButton("确认");
        jpp.add(jfp1);
        jpp.add(jfp2);
        jpp.add(jbp);
        jdp.add(jpp);


        //为老师配置课程
        jb3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdo.setVisible(true);
                ChaShiCun cha = new ChaShiCun();

                jbo.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cha.ChaCun(jfo1.getText())) {


                            LianJie lian = new LianJie();
                            Connection conn = lian.lianjie();
                            Statement stmt = null;

                            try {
                                stmt = conn.createStatement();

                                String sql = "update tea set 课号2  = '" + jfo2.getText() + "' where 职工号 = '" + jfo1.getText() + "';";
                                int rs = stmt.executeUpdate(sql);
                                jbo.setText("配课成功!");

                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }


                            //重置密码


                        } else {
                            jbo.setText("该老师不存在!");
                        }
                    }


                });
            }
        });


        //为学生选课
        jb4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jdp.setVisible(true);
                ChaCun cha = new ChaCun();

                jbp.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cha.ChaXue(jfp1.getText())) {

                            if (jfp2.getText().equals("市场营销") || jfp2.getText().equals("企业管理")) {
                                LianJie lian = new LianJie();
                                Connection conn = lian.lianjie();
                                Statement stmt = null;

                                try {
                                    stmt = conn.createStatement();
                                    //学生表 增加一个数据
                                    String sql = "update stu set 选修  = '" + jfp2.getText() + "' where 学号 = '" + jfp1.getText() + "';";
                                    int rs = stmt.executeUpdate(sql);
                                    //成绩表 增加一个成绩
                                    sql = "update grade1 set " + jfp2.getText() + " = '0'  where 学号 = '" + jfp1.getText() + "';";
                                    rs = stmt.executeUpdate(sql);

                                    jbp.setText("选课成功!");

                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }


                            } else {
                                jbp.setText("本学期不可选此课");
                            }

                        } else {
                            jbp.setText("该学生不存在!");
                        }
                    }


                });
            }
        });


    }
}
