package 管理员;

import 学生.ChengJi;
import 教师.ChaCun;
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



            JDialog jd = new JDialog(jf, "重置密码");
            jd.setBounds(700, 400, 300, 200);


            //语句和按键 重置密码操作

            JPanel jp2 = new JPanel(new GridLayout(2, 1, 40, 70));
            JTextField jt = new JTextField("");
            JButton jb = new JButton("确认");
            jp2.add(jt);
            jp2.add(jb);
            jd.add(jp2);

            //重置教师密码
            jb1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    jt.setText("请输入职工号");
                    jb.setText("确认");
                    jd.setVisible(true);
                    ChaShiCun cha = new ChaShiCun();


                    jb.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(cha.ChaCun(jt.getText())){
                                jb.setText("重置成功!");
                                ChongZhi chong  = new ChongZhi();
                                chong.Chong(jt.getText(),"123456","职工号" , "tea");
                            }
                            else {
                                jb.setText("该老师不存在!");
                            }
                        }


                    });

                }
            });

            //重置学生的密码
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText("请输入学号");
                jb.setText("确认");
                jd.setVisible(true);
                ChaCun cha = new ChaCun();


                //为二级菜单添加确认

                jb.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cha.ChaXue(jt.getText())){
                            jb.setText("重置成功!");
                            ChongZhi chong  = new ChongZhi();
                            chong.Chong(jt.getText(),"123123","学号" , "stu");
                        }
                        else {
                            jb.setText("该学生不存在!");
                        }
                    }


                });

            }
        });



// 配置课程

        JDialog jd1 = new JDialog(jf, "配置课程");
        jd1.setBounds(700, 400, 300, 200);

        JPanel jp3 = new JPanel(new GridLayout(3, 1, 0, 0));
        JTextField jf1 = new JTextField("");
        JTextField jf2 = new JTextField("");
        JButton  jb11= new JButton("确认");
        jp3.add(jf1);
        jp3.add(jf2);
        jp3.add(jb11);
        jd1.add(jp3);

        //为老师配置课程
        jb3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf1.setText("请输入教师职工号");
                jf2.setText("请输入课号");
                jb11.setText("确认");
                jd1.setVisible(true);
                ChaShiCun cha = new ChaShiCun();

                jb11.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cha.ChaCun(jf1.getText())){


                            LianJie lian = new LianJie();
                            Connection conn = lian.lianjie();
                            Statement stmt = null;

                                try {
                                    stmt = conn.createStatement();

                                    String sql = "update tea set 课号2  = '"+jf2.getText()+"' where 职工号 = '" + jf1.getText()+"';";
                                    int rs = stmt.executeUpdate(sql);
                                    jb11.setText("配课成功!");

                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }


                                //重置密码


                            }
                        else {
                            jb11.setText("该老师不存在!");
                        }
                    }


                });
            }
        });


        //为学生选课
        jb4.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf1.setText("请输入学号");
                jf2.setText("请输入课名");
                jb11.setText("确认");
                jd1.setVisible(true);
               ChaCun cha = new ChaCun();

                jb11.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cha.ChaXue(jf1.getText())){

                            if(jf2.getText().equals("市场营销")||jf2.getText().equals("企业管理")){
                                LianJie lian = new LianJie();
                                Connection conn = lian.lianjie();
                                Statement stmt = null;

                                try {
                                    stmt = conn.createStatement();
                                                            //学生表 增加一个数据
                                    String sql = "update stu set 选修  = '"+jf2.getText()+"' where 学号 = '" + jf1.getText()+"';";
                                    int rs = stmt.executeUpdate(sql);
                                                          //成绩表 增加一个成绩
                                     sql = "update grade1 set "+jf2.getText()+ " = '0'  where 学号 = '" + jf1.getText()+"';";
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





    }}
