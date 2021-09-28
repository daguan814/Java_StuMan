/**
 * @ClassName: ${NAME}
 * @Description: 实现登录的操作
 * @author: 登录
 * @date: 9：35 9月12日
 */
package 登录_Main;

import 学生.XueSheng;
import 教师.JiaoShi;
import 管理员.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;  //导包

public class Login {//类

    public static String zhanghaofin;//账号变量
    public static String mimafin;//密码变量

    public static void main(String[] args) { //主函数
        JFrame jf = new JFrame("教务系统_登录");//新建一个窗口
        jf.setBounds(600, 300, 600, 500);//窗口的大小和位置
        GridLayout wangge = new GridLayout(4, 2, 1, 100);//网格布局

        JPanel jp = new JPanel(wangge);//把布局嵌套在窗口上面


        //首行
        JLabel null1 = new JLabel("                登");//文本标签
        JLabel denglu1 = new JLabel("录");//文本标签
        Font zi = new Font("宋体", Font.TYPE1_FONT, 30);//设定字体
        denglu1.setFont(zi);//设置字体
        null1.setFont(zi);//设置字体


        //第二行
        JLabel zhanghaolabel = new JLabel(" (提示：账号是学号)   账号：");//文本标签
        Font xi = new Font("宋体", Font.TYPE1_FONT, 20);//设定字体
        zhanghaolabel.setFont(xi);//设置字体
        JTextField username = new JTextField();//文本输入框

        //第三行
        JLabel mimalabel2 = new JLabel(" (初始密码：123123)  密码：");//文本标签

        mimalabel2.setFont(xi);//设定字体
        JPasswordField pwd = new JPasswordField();//密码框


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

        zhanghaofin=  username.getText();//从42文本框中获取账号
        System.out.println(zhanghaofin);//输出账号信息

        jf.setResizable(false);//使窗口不可调整大小
        jf.setVisible(true);//使窗口可见
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设定窗口关闭


        //第二个窗口
        JDialog jd = new JDialog(jf, "确认登录？");//继承第一个窗口
        jd.setBounds(700, 400, 300, 200);//设定大小
        LianJie Con = new LianJie();//连接数据库

        //语句和按键
        JPanel jp2 = new JPanel(new GridLayout(4, 1, 0, 0));//第二个布局
        Con.lianjie();//79使用上面的函数连接数据库
        JLabel lianjietip = new JLabel(Con.chenggong);//文本标签
        JLabel lab = new JLabel();//标签
        JButton queren = new JButton("确定");//按钮

        //添加进第二个布局里
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
               zhanghaofin=  username.getText();//获取账号
               mimafin = pwd.getText();//获取密码
               lab.setText(yan.yanzheng());//设定文本
                jd.setVisible(true);//使第二个窗口可见

            }
        });


        //清空输入的东西
        qingkong.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {//设定文本框内容为空
                username.setText("");//设定文本框内容为空
                pwd.setText("");//设定文本框内容为空
            }
        });


        //跳转到各个不同用户的界面
        XueSheng xueSheng = new XueSheng();
        JiaoShi jiao = new JiaoShi();
        Admin ad = new Admin();

        queren.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {//判断密码正误
                if(yan.yanzheng().equals("密码错误！")){
                    jd.setVisible(false);
                }else if(yan.yanzheng().equals("该账号不存在！")){
                    jd.setVisible(false);
                }else if(yan.yanzheng().equals("登录成功，身份是：教师")){
                    //教师登录
                    jiao.Jiaoshow();

                }else if(yan.yanzheng().equals("登录成功，身份是：学生")){
                    //学生登录
                    xueSheng.showStu();

                }
                else{
                    //管理员登录
                    ad.Adminshow();
                }

            }
        });



        jd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
