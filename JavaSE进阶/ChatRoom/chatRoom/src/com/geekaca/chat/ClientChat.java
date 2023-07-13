package com.geekaca.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientChat implements ActionListener {
    /**
     * 1.设计界面  ,窗口
     */
    private JFrame win = new JFrame();
    /**
     * 2.消息内容框架  多行输入框
     * 用于显示 当前聊天内容列表
     */
    public JTextArea smsContent = new JTextArea(23,50);
    /**
     * 3.发送消息的框
     */
    private JTextArea smsSend = new JTextArea(4,40);
    /**
     * 展示在线人数 昵称的窗口
     */
    public JList<String> onLineUsersList = new JList<>();
    //消息按钮
    private JButton sendBn = new JButton("发送");
    // 是否私聊按钮
    private JCheckBox isPrivateBn = new JCheckBox("私聊");
    // 登录界面
    private JFrame loginView;
    //登陆界面 的ip输入，昵称输入
    private JTextField ipEt, nameEt;

    public static void main(String[] args) {
        ClientChat clientChat = new ClientChat();
        clientChat.initView();
    }

    private void initView() {
        /** 初始化聊天窗口的界面 */
        win.setSize(650, 600);

        /** 展示登录界面  */
        displayLoginView();

        /** 展示聊天界面 */
        //displayChatView();
    }

    /**
     * 显示登陆界面
     */
    private void displayLoginView() {
        /** 先让用户进行登录
         *  服务端ip
         *  用户名
         *  id
         *  */
        /** 显示一个qq的登录框     */
        loginView = new JFrame("登录");
        //布局方式，表格布局，三行一列
        loginView.setLayout(new GridLayout(3, 1));
        loginView.setSize(400, 230);
        //面板
        JPanel ip = new JPanel();
        JLabel label = new JLabel("   IP:");
        ip.add(label);
        //输入框
        ipEt = new JTextField(20);
        ip.add(ipEt);
        loginView.add(ip);
        //放名字的面板panel
        JPanel name = new JPanel();
        JLabel label1 = new JLabel("姓名:");
        name.add(label1);
        nameEt = new JTextField(20);
        name.add(nameEt);
        loginView.add(name);

        JPanel btnView = new JPanel();
        JButton login = new JButton("登陆");
        btnView.add(login);
        JButton cancle = new JButton("取消");
        btnView.add(cancle);
        loginView.add(btnView);
        // 关闭窗口退出当前程序
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setWindowCenter(loginView, 400, 260, true);

        /**
         * 给登录和取消绑定点击事件
         * 点击按钮后 谁负责处理
         * */
        login.addActionListener(this);
        cancle.addActionListener(this);
    }
    private static void setWindowCenter(JFrame frame, int width, int height, boolean flag) {
        /** 得到所在系统所在屏幕的宽高 */
        Dimension ds = frame.getToolkit().getScreenSize();

        /** 拿到电脑的宽 */
        int width1 = ds.width;
        /** 高 */
        int height1 = ds.height;

        System.out.println(width1 + "*" + height1);
        /** 设置窗口的左上角坐标 */
        frame.setLocation(width1 / 2 - width / 2, height1 / 2 - height / 2);
        frame.setVisible(flag);
    }

    //按钮点击后 会被调用的函数
    @Override
    public void actionPerformed(ActionEvent e) {
        /** 得到点击的事件 ActionEvent
         * 判断点击的哪个按钮
         * */
        JButton btn = (JButton) e.getSource();//触发事件的源头
        switch (btn.getText()) {
            case "登陆":
                /**
                 * 从输入框拿到输入的信息
                 */
                String ipStr = ipEt.getText().toString();
                String name = nameEt.getText().toString();//昵称
                //连接serversocket
                /**
                 * todo: 验证 服务器的ip地址是否符合要求   校验IP地址格式 最多3位数字（最少1位）.3位数字.3位数字.3位数字
                 * \\d{1,3}
                 * 昵称  不能为空，不能全是空格
                 *
                 * 如果都符合条件了
                 * 继续连接
                 */
                win.setTitle(name);
                try{
                    Socket socket = new Socket(ipStr, ChatConstants.PORT);
                    new Thread(new ClientReader(socket,this)).start();
                    //需要不断读取 来自server的信息 ，如果此处直接写while(true) 死循环
                    //读取server的数据，就会导致把cpu抱住不让走，
                    /**
                     * readme.txt  4
                     * 马上发送客户的昵称给server
                     * 消息类型： 登陆
                     */
                    DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataOutputStream.writeInt(ChatConstants.MSG_TYPE_LOGIN);
                    dataOutputStream.writeUTF(name);
                    dataOutputStream.flush();
                    // 关系当前窗口 弹出聊天界面
                    loginView.dispose(); // 登录窗口销毁
                    displayChatView(); // 展示了聊天窗口了
                } catch (UnknownHostException unknownHostException) {
                    unknownHostException.printStackTrace();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                break;
            case "取消":
                /** 退出系统, 退出整个程序 */
                System.exit(0);
                break;
        }
    }

    /**
     * 显示聊天UI界面
     */
    private void displayChatView() {

        JPanel bottomPanel = new JPanel(new BorderLayout());
        //-----------------------------------------------
        // 将消息框和按钮 添加到窗口的底端
        win.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(smsSend);
        JPanel btns = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btns.add(sendBn);
        btns.add(isPrivateBn);
        bottomPanel.add(btns, BorderLayout.EAST);
        //-----------------------------------------------
        // 给发送消息按钮绑定点击事件监听器
        // 将展示消息区centerPanel添加到窗口的中间
        smsContent.setBackground(new Color(0xdd, 0xdd, 0xdd));
        // 让展示消息区可以滚动。
        win.add(new JScrollPane(smsContent), BorderLayout.CENTER);
        smsContent.setEditable(false);
        //-----------------------------------------------
        // 用户列表和是否私聊放到窗口的最右边
        Box rightBox = new Box(BoxLayout.Y_AXIS);
        onLineUsersList.setFixedCellWidth(120);
        onLineUsersList.setVisibleRowCount(13);
        rightBox.add(new JScrollPane(onLineUsersList));
        win.add(rightBox, BorderLayout.EAST);
        //-----------------------------------------------
        // 关闭窗口退出当前程序
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.pack();  // swing 加上这句 就可以拥有关闭窗口的功能
        /** 设置窗口居中,显示出来  */
        setWindowCenter(win, 650, 600, true);
        // 发送按钮绑定点击事件
        sendBn.addActionListener(this);
    }
}
