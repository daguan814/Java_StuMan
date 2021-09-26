package 教师;

/**
 * @ClassName: ChaCJ
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/26  12:50
 */


import 登录_Main.LianJie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ChaCJ extends JFrame {
    JFrame xb = new JFrame("成绩表");
    GridLayout db = new GridLayout(1, 1);
    JPanel dx = new JPanel(db);
    JTable table=new JTable();




    public ChaCJ(String x) throws ClassNotFoundException, SQLException {

        xb.setBounds(800, 400, 600, 500);
        xb.setResizable(false);
        xb.setVisible(true);


        LianJie lian = new LianJie();
        Connection conn = lian.lianjie();
        Statement stmt = conn.createStatement();
        String sql = " select  学号 , " + x + " from grade1 ";
        ResultSet rs = stmt.executeQuery(sql);

        String ss[] = new String[200];
        int y = 0;
        while (rs.next()){

            ss[y]  = rs.getString(1);
            ss[y+1] = rs.getString(2);

            y+=2;
        }

        Object[][] obj=new Object[100][8];
        String[] col={"学号","成绩","学号","成绩","学号","成绩","学号","成绩"};
        obj[0]=col;
        for (int i = 0, xx=1; xx <=y/8; xx++) {
            //obj[1][1]=list.get(0).get(0);
            //obj[1][2]=list.get(0).get(1);

            obj[xx][0] = ss[i] ;
            obj[xx][1] = ss[i+1] ;
            obj[xx][2] = ss[i+2] ;
            obj[xx][3] = ss[i+3] ;
            obj[xx][4] = ss[i+4] ;
            obj[xx][5] = ss[i+5] ;
            obj[xx][6] = ss[i+6] ;
            obj[xx][7] = ss[i+7] ;
            i+=8;


        }


        table.setModel(new DefaultTableModel(obj,col));



        dx.add(table);
        xb.add(dx);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new ChaCJ("数据结构");

    }

}





