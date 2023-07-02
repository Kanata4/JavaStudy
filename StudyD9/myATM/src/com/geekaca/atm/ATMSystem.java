package com.geekaca.atm;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static com.geekaca.atm.AccountSys.ACC_INSTANCE;

public class ATMSystem {
    private static final int MAIN_MENU_LOGIN = 1;
    private static final int MAIN_MENU_REGISTER = 2;
    private static final int MAIN_MENU_EXIT = 3;

    private static final int USER_MENU_QUERY = 1;
    private static final int USER_MENU_SAVEMONEY = 2;
    private static final int USER_MENU_GETMONEY = 3;
    private static final int USER_MEMU_TRANSFORMONEY = 4;
    private static final int USER_MEMU_REWRITEPASSWD = 5;
    private static final int USER_MEMU_EXIT = 6;
    private static final int USER_MEMU_DELETE = 7;


    public static void main(String[] args) {
//        String str = "张维";
//        str.startsWith("张");
//        System.out.println(str.startsWith("张"));
//        System.out.println(str.startsWith("zhou"));
        /**
         * 保存系统中的所有账户
         *
         * 整个系统只有一份
         */
        //获取唯一的对象
        initAccounts(ACC_INSTANCE.accountsMap);
        System.out.println("======================欢迎您进入ATM系统===================");
        while (true) {
            //系统主菜单
            System.out.println("1登陆账户");
            System.out.println("2注册账户");
            System.out.println("3退出");
            System.out.println("请您选择操作：");
            Scanner sc = new Scanner(System.in);
            //命令
            int command = sc.nextInt();
            ArrayList accountList = ACC_INSTANCE.accounts;
            switch (command) {
                case MAIN_MENU_LOGIN:
                    //登录
                    login(sc);
                    break;
                case MAIN_MENU_REGISTER:
                    //注册（拓展）
                    register(sc);
                    break;
                case MAIN_MENU_EXIT:
                    //退出
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    private static void register(Scanner sc) {

    }

    /**
     * 登录
     *
     * @param
     * @param sc           键盘录入
     */
    public static void login(Scanner sc) {
        System.out.println("=======================欢迎来到登陆界面==================");
        /**
         * 当用户名密码输入正确，那么继续下一环节，下一个菜单
         * 选择 取款，存款。。。
         *
         * 如果用户名或者密码错误 那么要继续提示用户输入
         */
        while (true) {
            System.out.println("请输入卡号：");
            String cardNum = sc.next();
            System.out.println("请输入密码：");
            String passwd = sc.next();
            /**
             *  判断卡号和密码是否正确
             *  对集合进行循环 访问每一个
             */
            //保存是否登录成功
            boolean isLoginOk = false;
            //定义一个变量指向 单一实例的属性
            Map<String,Account> accountsMap = ACC_INSTANCE.accountsMap;
            //卡号是否存在
            boolean isExsistCardId = accountsMap.containsKey(cardNum);
            if (isExsistCardId){
                Account account = accountsMap.get(cardNum);
                if (passwd.equals(account.getPassWord())){
                    //说明登陆成功
                    System.out.println("登陆成功");
                    showUserMenu(sc, account);
                    return;//直接退出方法
                }else {
                    //说明密码错误
                    System.out.println("登陆失败");
                }
            }else {
                //说明卡号错误
            }
            /**
             * 现根据卡号找到账户 然后判断密码是否正确
             */
            //到这里 如果没有找到能够匹配的对象，则说明 登录失败
            if (!isLoginOk) {
                System.out.println("登录失败");
            }
        }
    }

    /**
     * 展示用户主菜单
     *
     * @param sc           键盘录入
     * @param acc          你的账户
     */
    private static void showUserMenu(Scanner sc, Account acc) {
        while (true) {
            System.out.println("==================欢迎您进入到操作界面======================");
            System.out.println("1、查询");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("请您输入操作命令：");
            int command = sc.nextInt();
            ArrayList<Account> accountsList = ACC_INSTANCE.accounts;
            switch (command) {
                case USER_MENU_QUERY:
                    //查询
                    showAccount(acc);
                    break;
                case USER_MENU_SAVEMONEY:
                    //存款
                    saveMoney(acc, sc);
                    break;
                case USER_MENU_GETMONEY:
                    //取款
                    drawMoney(acc, sc);
                    break;
                case USER_MEMU_TRANSFORMONEY:
                    //转账
                    transferMoney(acc,sc);
                    break;
                case USER_MEMU_REWRITEPASSWD:
                    //修改密码
                    rewritePasswd(acc, sc);
                case USER_MEMU_EXIT:
                    //退出
                    return;
                case USER_MEMU_DELETE:
                    //注销账户
                    deleteAccount(acc, sc);
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }

    /**
     *
     * @param acc
     * @param sc
     */
    private static void deleteAccount(Account acc, Scanner sc) {
        System.out.println("---用户注销---");
        System.out.println("警告：再次输入密码注销用户");
        ArrayList<Account> accountsList = ACC_INSTANCE.accounts;
        while (true) {
            String Passwd = sc.next();
            if (Passwd.equals(acc.getPassWord())) {
                accountsList.remove(acc);
                System.out.println("已注销！");
                return;
            } else {
                System.out.println("密码错误！");
            }
        }
    }

    /**
     *
     * @param acc
     * @param sc
     */
    private static void rewritePasswd(Account acc, Scanner sc) {
        System.out.println("请输入旧密码");
        String oldPasswd = sc.next();
        //判断密码是否正确
        if (oldPasswd.equals(acc.getPassWord())) {
            while (true) {
                System.out.println("请输入新密码：");
                String newPasswd = sc.next();
                System.out.println("请确认新密码：");
                String okPasswd = sc.next();
                if (newPasswd.equals(okPasswd)) {
                    acc.setPassWord(newPasswd);
                    System.out.println("密码修改成功！");
                    return;
                } else {
                    System.out.println("您两次输入的密码不一致！");
                }
            }
        } else {
            System.out.println("密码错误！");
        }
    }

    /**
     * 转账
     * @param acc 你的账户 对象
     * @param sc 键盘录入 对象
     */
    private static void transferMoney(Account acc, Scanner sc) {
        //判断系统中账户数量＞2
        //防御式编程， 先把所有不合理的情况拦截
        Map<String, Account> accountsMap = AccountSys.ACC_INSTANCE.accountsMap;
        if (accountsMap.size() < 2) {
            System.out.println("系统中没有其他账户，无法转账！");
            return;
        }
        //判断自己账户余额是否有钱
        if (acc.getMoney() == 0.0){
            System.out.println("账户没钱，无法转账！");
            return;
        }

        System.out.println("请输入对方的卡号：");
        String hisCardId = sc.next();
        /**
         * 伪代码
         * 去系统中查找卡号是否存在
         * 存在 则返回对方的账户对象
         * 不存在，则提示
         */
        Account accountByCardId = getAccountByCardId(accountsMap, hisCardId);
        if (accountByCardId == null) {
            System.out.println("没有这个卡号" + hisCardId);
            return;
        }
        //说明找到了卡号的账户
        //下一步：要确认对方的姓氏
        /**
         * 拿到 账号的 账户名，比如：宋小宝
         *
         * 把首字符替换成* 变成 *小宝 （并不是修改账户，只是显示）
         * 还要把对方的姓氏第一个字取出来，用作判定
         * 判断输入的和对方姓名首字符是否相等
         */
        String userName = accountByCardId.getUserName();
        String maskName = "*" + userName.substring(1);
//        char firstChar = userName.charAt(0);
        System.out.println("请您确认【"+ maskName + "】的姓氏：");
        String inputXing = sc.next();
        if (userName.startsWith(inputXing)){
            //进入转账流程
            System.out.println("输入正确");
            System.out.println("请输入转账金额：");
            double moneyToTrans = sc.nextDouble();
            accountByCardId.setMoney(accountByCardId.getMoney() + moneyToTrans);
            acc.setMoney(acc.getMoney() - moneyToTrans);
            System.out.println("转账成功！");
            showAccount(acc);
            return;
        }else {
            System.out.println("姓氏输入错误！");
            return;
        }
    }

    /**
     * 在系统（集合）中查找 指定的卡号
     * @param cardId
     * @return 账户对象
     */
    private static Account getAccountByCardId(Map<String, Account> accountMap, String cardId) {
        return  accountMap.get(cardId);
    }

    /**
     * @param acc
     * @param sc
     */
    private static void drawMoney(Account acc, Scanner sc) {
        System.out.println("--欢饮进入取款操作");
        while (true) {
            //检查小于0
            System.out.println("请输入取款金额：");
            double moneyDraw = sc.nextDouble();
            if (moneyDraw <= 0) {
                System.out.println("输入有误！");
                //死循环
            } else if (moneyDraw > acc.getQuotaMoney()) {
                System.out.println("取现额度不够！");
            } else if (moneyDraw > acc.getMoney()) {
                System.out.println("余额不足！");
            } else {
                double finalMoney = acc.getMoney() - moneyDraw;
                System.out.println("取款成功");
                acc.setMoney(finalMoney);
                showAccount(acc);
                //循环结束
                break;
            }
        }
    }

    /**
     *
     * @param acc
     * @param sc
     */
    private static void saveMoney(Account acc, Scanner sc) {
        System.out.println("--欢迎进入存款操作--");
        while (true) {
            // 检查 小于0
            System.out.println("请输入存款金额：");
            double moneySave = sc.nextDouble();
            if (moneySave <= 0) {
                System.out.println("输入有误！");
                //再给一次机会
            } else {
                double finalMoney = acc.getMoney() + moneySave;
                acc.setMoney(finalMoney);
                System.out.println("存款成功！");
                showAccount(acc);
                //循环结束
                break;
            }
        }

    }

    /**
     * 显示账户的信息
     *
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("---您的账户信息：----");
        System.out.println("账户名：" + acc.getUserName());
        System.out.println("卡号：" + acc.getCardId());
        System.out.println("余额：" + acc.getMoney());
        System.out.println("取现额度：" + acc.getQuotaMoney());
    }

    public static void initAccounts(Map<String, Account> accountMap) {
        Account account = new Account();
        account.setUserName("zhangsan");
        account.setPassWord("abc123");
        account.setCardId("ICBC987654321");
        account.setMoney(30000);
        account.setQuotaMoney(4000);
        accountMap.put(account.getCardId(),account);

        Account account2 = new Account();
        account2.setUserName("zhangwei");
        account2.setPassWord("abc123");
        account2.setCardId("54321");
        account2.setMoney(1000);
        account2.setQuotaMoney(4000);
        accountMap.put(account2.getCardId(),account2);

        Account account3 = new Account();
        account3.setUserName("qiudaoyu");
        account3.setPassWord("abc123");
        account3.setCardId("98765");
        account3.setMoney(1000);
        account3.setQuotaMoney(4000);
        accountMap.put(account3.getCardId(),account3);
    }

}
