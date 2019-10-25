package person;

import utils.enums.PersonType;
import utils.info.ConstantTable;
import store.message.Mediator;
import java.util.Scanner;
import store.message.CustomerMessageBoard;


/**
 * @className: Customer
 * @author: Wenyue Li
 * @description: 顾客 具体类
 * @designPattern: AbstractFactory
 * @date: 7:09 下午 2019/10/22
 * @version: v1.1
 */
public class Customer extends Person {
    private int expense;

    private int cash;
    private int balanceInAlipay;
    private int balanceInWeChat;



    /** @update: 更新了构造器的形式 - Shidan Cheng */
    public Customer(String name) {
        super(name,PersonType.Customer);
        this.cash = ConstantTable.CUSTOMER_CASH_BALANCE;
        this.balanceInAlipay = ConstantTable.CUSTOMER_ALIPAY_BALANCE;
        this.balanceInWeChat = ConstantTable.CUSTOMER_WECHAT_BALANCE;
    }

    public int getCash() {
        return cash;
    }

    public int getBalanceInAlipay() {
        return balanceInAlipay;
    }

    public int getBalanceInWeChat() {
        return balanceInWeChat;
    }

    /** @update: 重载了另一种Customer的构造函数，以处理FilterDemo - Yinan Cheng */
    public Customer(String name,int expense){
        this(name);
        this.expense=expense;
    }

    /** @update: 获得某个客户的年花销 - Yinan Cheng */
    public int getExpense() {
        return expense;
    }
  
    public void setCash(int cash){
        this.cash = cash;
    }

    public void setBalanceInAlipay(int balanceInAlipay) {
        this.balanceInAlipay = balanceInAlipay;
    }

    public void setBalanceInWeChat(int balanceInWeChat) {
        this.balanceInWeChat = balanceInWeChat;
    }

    /**
     * 用来测试责任链模式的辅助方法
     *
     * @methodName: printBalanceInfo
     * @return: void
     */
    public void printBalanceInfo(){
        System.out.printf("%s\n",this.name);
        System.out.printf("现金    :%d元;\n",this.cash);
        System.out.printf("支付宝  :%d元;\n",this.balanceInAlipay);
        System.out.printf("微信    :%d元;\n",this.balanceInWeChat);
        System.out.println("--------------------");

    }

    /**
     *此人通过该方法写下留言
     *
     * @methodName: sendMessage
     * @author: Xian Zhou
     * @date:2019/10/25
     * @param:Mediator
     * @return:void
     */
    public void sendMessage(String message) {

        Scanner s = new Scanner(System.in);
        System.out.println(this.name+"你好！请在留言板中记下您的留言");

        message = s.nextLine();

        System.out.println("正在将留言录入留言板");

        this.getMediator().getMessage(message, this.name);

        System.out.println("留言成功");
    }

}
