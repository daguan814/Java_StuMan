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
public class XueSheng {//创建学生类
    JFrame jf = new JFrame("学生信息");//窗口

    public void showStu() {//函数
        jf.setBounds(400, 100, 800, 600);//设定窗口大小
        jf.setResizable(false);//设定不可调整大小
        jf.setVisible(true);//设定可见
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式

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
//创建组件

            JLabel L1 = new JLabel(X[1]);
            JLabel L2 = new JLabel(X[3]);
            JLabel L3 = new JLabel(X[8]);
            JLabel L4 = new JLabel("");
            JLabel L5 = new JLabel(X[4]);
            JLabel L6 = new JLabel(X[5]);
            JLabel L7 = new JLabel(X[6]);

//设定组件要显示的值
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



            //把组件添加进去
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
            JPanel jp2 = new JPanel(new GridLayout(3, 1, 0, 0));//继承第一个窗口
            JLabel xuanze = new JLabel("选择要查看学期的成绩：");//语句
            JButton shang = new JButton("上学期");//按键
            JButton xia = new JButton("下学期");//按键


            //查成绩的按钮事件
            chachengji.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {  //查成绩的按钮事件
                    if (X[7].equals("账号状态：可用")) {//判断账号是否可用
                        jp2.add(xuanze);//显示
                        jp2.add(shang);//显示
                        jp2.add(xia);//显示

                    } else {
                        xuanze.setText("您已毕业或者被管理员禁用故无法进行任何操作！");//毕业显示
                        jp2.add(xuanze);
                    }

                    jd.add(jp2);
                    jd.setVisible(true);
                }
            });




           //点击上学期显示成绩
            ChengJi cha = new ChengJi();//查询成绩
            shang.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                cha.chacheng(1);
                }
            });//点击上学期成绩然后显示

            //点击下学期显示成绩
            ChengJi xiaxue = new ChengJi();//查询成绩
            xia.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    xiaxue.chacheng(2);
                }
            });//点击下学期成绩然后显示


            //修改密码
            JDialog jd1 = new JDialog(jf, "修改密码");    //修改密码
            jd1.setBounds(400, 400, 300, 200);//设置窗口大小

            JPanel jp5 = new JPanel(new GridLayout(2, 1, 90, 90));//表格布局 2行 1列 间隔90
            JTextField mima = new JTextField("请输入新密码");//输入新密码
            JButton ok = new JButton("确认");//确认按钮
            jp5.add(mima);//嵌套到布局
            jp5.add(ok);//嵌套到布局
            jd1.add(jp5);//嵌套到布局

            gai.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {//改密码的点击事件

                    jd1.setVisible(true);//设定可视化

                    ok.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {//确定的按钮事件 命名为 欧克
                            GaiPSW ga = new GaiPSW();//更改密码的对象
                            ga.xiugaimima(1,temp,mima.getText());//传参
                            ok.setText("修改成功");//显示修改成功
                        }
                    });

                }
            });



//刷新页面
            tui.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {//重新加载整个页面
                    jf.setVisible(false);//重新加载整个页面
                    XueSheng xue = new XueSheng();//重新加载整个页面
                    xue.showStu();//重新加载整个页面
                }
            });


            //选课

            JDialog jd9 = new JDialog(jf, "选本学期课程");//继承第一个窗口
            jd9.setBounds(700, 400, 300, 200);//设定窗口

            JPanel jp3 = new JPanel(new GridLayout(2, 1, 60, 60));//网格布局
            JTextField jf1 = new JTextField("");//文本框
            JButton  jb11= new JButton("确认");//确认按钮
            jp3.add(jf1);//添加进布局
            jp3.add(jb11);//添加进布局
            jd9.add(jp3);//添加进布局

            //选课
            Xuan.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {//选课
                    jf1.setText("请输入课名");//输入课名

                    jb11.setText("确认");//确认按钮
                    jd9.setVisible(true);//设定窗口可视
                    ChaCun cha = new ChaCun();//查找课名是否存在

                    jb11.addActionListener(new AbstractAction() {
                        @Override
                        public void actionPerformed(ActionEvent e) {//选课
                            if(cha.ChaXue(temp)){//查找是否存在

                                if(jf1.getText().equals("市场营销")||jf1.getText().equals("企业管理")){//看看选的是那门课程
                                    LianJie lian = new LianJie();//连接数据库
                                    Connection conn = lian.lianjie();//连接数据库
                                    Statement stmt = null;//连接数据库

                                    try {
                                        stmt = conn.createStatement();//创建通道
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
