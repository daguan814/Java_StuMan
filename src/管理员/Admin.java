package 管理员;

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
        GridLayout buju = new GridLayout(5, 3, 80, 80);
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
        JLabel L6 = new JLabel("          增加人员");
        JButton jb5 = new JButton("增加一个老师");
        JButton jb6 = new JButton("增加一个学生");
        JLabel L7 = new JLabel("          删除人员");
        JButton jb8 = new JButton("删除一个老师");
        JButton jb9 = new JButton("删除一个学生");

        Font zi = new Font("宋体", Font.TYPE1_FONT, 30);

        L2.setFont(zi);

        Font xi = new Font("宋体", Font.TYPE1_FONT, 20);
        L4.setFont(xi);
        L5.setFont(xi);
        L6.setFont(xi);
        L7.setFont(xi);




        jp.add(L1);
        jp.add(L2);
        jp.add(L3);
        jp.add(L4);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(L5);
        jp.add(jb3);
        jp.add(jb4);
        jp.add(L6);
        jp.add(jb5);
        jp.add(jb6);
        jp.add(L7);
        jp.add(jb8);
        jp.add(jb9);

        jf.add(jp);



            JDialog jd = new JDialog(jf, "重置密码");
            jd.setBounds(700, 400, 300, 200);


            //语句和按键  选择上学期或下学期
            JPanel jp2 = new JPanel(new GridLayout(2, 1, 40, 0));
            JTextField jt = new JTextField("请输入职工号或学号");
            JButton jb = new JButton("确认");
            jp2.add(jt);
            jp2.add(jb);
            jd.add(jp2);

            jb1.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    jd.setVisible(true);
                    ChaShiCun cha = new ChaShiCun();

                    //为二级菜单添加确认

                    jb.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(cha.ChaXue(jt.getText())){
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



// 选课  （四选二）




    }}
