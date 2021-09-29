package 教师;

/**
 * @ClassName: ChaCJ   最核心的功能
 * @Description: TODO
 * @author: 达观
 * @date: 2021/9/26  12:50
 */


import loginmain.LianJie;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ChaCJ extends JFrame {
    JFrame xb = new JFrame("成绩表");
    BorderLayout db = new BorderLayout();
    JPanel dx = new JPanel(db);
    JTable table=new JTable();
    JLabel lb = new JLabel("         查看修改成绩");
    JButton jb = new JButton("提交成绩");
     Font zi = new Font("宋体", Font.TYPE1_FONT, 40);




    public ChaCJ(String x) throws ClassNotFoundException, SQLException {

        xb.setBounds(800, 400, 600, 500);
        xb.setResizable(false);
        xb.setVisible(true);
        lb.setFont(zi);
        dx.add(jb,BorderLayout.SOUTH);
        dx.add(lb,BorderLayout.NORTH);
        dx.add(table,BorderLayout.CENTER);

        xb.add(dx);

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

        String[][] obj=new String[100][8];
        String[] col={"学号","成绩","学号","成绩","学号","成绩","学号","成绩"};
        obj[0]=col;
        for (int i = 0, xx=1; xx <=(y+1)/8; xx++) {
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



        String xuehao[] = new String[100];  //第一位没有用过
        String chegnji[] = new String[100];

        int finalY = y;
        jb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a ,b,i=1;  //a表示行 b表示列 i表示一维数组的序号
            for(a=1;a<=(finalY +1)/8;a++){
                for(b=0;b<=6;b+=2){
                    xuehao[i]= (String) table.getValueAt(a,b);  //提取出学号
                    i++;

                }
            }

                int g ,h,u=1;     //主要提取成绩
                for(g=1;g<=(finalY +1)/8;g++){
                    for(h=1;h<=7;h+=2){
                        chegnji[u]= (String) table.getValueAt(g,h);  //提取出成绩
                        u++;

                    }
                }


                for(int p =1;p<=72;p++){
                    String sql = "update grade1 set " +x+ " = " +chegnji[p]+ " where 学号 = '" + xuehao[p]+"';";
                    try {
                        int rs = stmt.executeUpdate(sql);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                jb.setText("录入成功！");
            }
        });

    }

}





