/**
 * @ClassName: ${NAME}
 * @Description: 实现登录的操作
 * @author: 登录
 * @date: 9：35 9月12日
 */
package 登录_Main;

import 学生.XueSheng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Login {

    public static String zhanghaofin;
    public static String mimafin;

    public static void main(String[] args) {
        JFrame jf = new JFrame("教务系统_登录");
        jf.setBounds(600, 300, 600, 500);
        GridLayout wangge = new GridLayout(4, 2, 1, 100);

        JPanel jp = new JPanel(wangge);


        //首行
        JLabel null1 = new JLabel("                登");
        JLabel denglu1 = new JLabel("录");
        Font zi = new Font("宋体", Font.TYPE1_FONT, 30);
        denglu1.setFont(zi);
        null1.setFont(zi);


        //第二行
        JLabel zhanghaolabel = new JLabel(" (提示：账号是学号)   账号：");
        Font xi = new Font("宋体", Font.TYPE1_FONT, 20);
        zhanghaolabel.setFont(xi);
        JTextField username = new JTextField();

        //第三行
        JLabel mimalabel2 = new JLabel(" (初始密码：123123)  密码：");

        mimalabel2.setFont(xi);
        JPasswordField pwd = new JPasswordField();


        // 第四行    两个按钮 登录和注册
        JButton jbdeng = new JButton("登录");
        JButton qingkong = new JButton("清空");


        //将按钮添加到Jpanel

        jp.add(null1);
        jp.add(denglu1);
        jp.add(zhanghaolabel);
        jp.add(username);
        jp.add(mimalabel2);
        jp.add(pwd);
        jp.add(jbdeng);
        jp.add(qingkong);
        jf.add(jp);

        zhanghaofin=  username.getText();
        System.out.println(zhanghaofin);

        jf.setResizable(false);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //第二个窗口
        JDialog jd = new JDialog(jf, "确认登录？");
        jd.setBounds(700, 400, 300, 200);
        LianJie Con = new LianJie();

        //语句和按键
        JPanel jp2 = new JPanel(new GridLayout(4, 1, 0, 0));
        Con.lianjie();
        JLabel lianjietip = new JLabel(Con.chenggong);
        JLabel lab = new JLabel();
        JButton queren = new JButton("确定");

        //添加进组件里
        jp2.add(lianjietip);
        jp2.add(lab);
        jp2.add(queren);
        jd.add(jp2);


        //验证登录的账号密码是否错误
        YanZheng yan = new YanZheng();
        //登录按键的事件触发
        jbdeng.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               zhanghaofin=  username.getText();
               mimafin = pwd.getText();
               lab.setText(yan.yanzheng());
                jd.setVisible(true);

            }
        });


        //清空输入的东西
        qingkong.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                pwd.setText("");
            }
        });


        //跳转到各个不同用户的界面
        XueSheng xueSheng = new XueSheng();


        queren.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(yan.yanzheng().equals("密码错误！")){
                    jd.setVisible(false);
                }else if(yan.yanzheng().equals("该账号不存在！")){
                    jd.setVisible(false);
                }else if(yan.yanzheng().equals("登录成功，身份是：教师")){
                    //教师登录


                }else if(yan.yanzheng().equals("登录成功，身份是：学生")){
                    //学生登录
                    xueSheng.showStu();

                }
                else{
                    //管理员登录

                }

            }
        });



        jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
