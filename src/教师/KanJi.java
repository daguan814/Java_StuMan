package 教师;

import 登录_Main.LianJie;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName: KanJi
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/16  11:10
 */
public class KanJi {
    public void Kanchengji(String x) {
        JFrame jf = new JFrame("查看学生成绩");

        jf.setBounds(400, 100, 600, 400);
        jf.setResizable(true);
        jf.setVisible(true);

        GridLayout buju = new GridLayout(1, 1, 0, 0);
        JPanel jp = new JPanel(buju);

        JTextArea Ja = new JTextArea();

        jp.add(Ja);
        jf.add(jp);

        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String suoyou = "       学号      成绩  |   学号      成绩 |    学号      成绩  |   学号      成绩  |   学号      成绩  "+ '\n';
            String sql = " select  学号 , " + x + " from grade1 ";
            ResultSet rs = stmt.executeQuery(sql);
            int y=0;
            for (; rs.next();y++) {
                if(y==4){
                    suoyou = suoyou + "       "+rs.getString(1) +"    "+ rs.getString(2)+'\n';
                    y=0;
                }
                suoyou = suoyou + "       "+rs.getString(1) +"    "+ rs.getString(2);
            }


            Ja.setText(suoyou);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

