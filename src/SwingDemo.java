//图形化界面
import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("用户信息输入");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1)); // 2行1列

        // 创建第一个面板（姓名）
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // 左对齐
        namePanel.add(new JLabel("姓名:"));
        JTextField nameField = new JTextField(15);
        namePanel.add(nameField);
        nameField.setPreferredSize(new Dimension(200,30));


        // 创建第二个面板（年龄）
        JPanel agePanel = new JPanel();
        agePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        agePanel.add(new JLabel("年龄:"));
        JTextField ageField = new JTextField(15);
        agePanel.add(ageField);
        ageField.setPreferredSize(new Dimension(200,30));

        //创建第三个面板(确认与取消)
        JPanel SwitchPanel = new JPanel();
        SwitchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        SwitchPanel.add(new JButton("确认"));
        SwitchPanel.add(new JButton("取消"));

        // 添加面板到主窗口
        frame.add(namePanel);
        frame.add(agePanel);
        frame.add(SwitchPanel);

        frame.setVisible(true);
    }
}
