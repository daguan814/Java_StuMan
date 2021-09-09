
import java.awt.*;//导入awt包（GUI程序包）
public class ChuangKou {
    public static void main(String[] args){
        //创建窗口
        Frame frame=new Frame("我的第一个窗口!");

        //设置窗口可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(500,500);

        //设置背景颜色
        frame.setBackground(new Color(156, 62, 47));

        //设置窗口初始位置
        frame.setLocation(200,200);

        //设置窗口大小是否可改变
        frame.setResizable(false);
    }
}
