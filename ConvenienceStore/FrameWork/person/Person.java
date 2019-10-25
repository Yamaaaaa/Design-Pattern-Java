package person;

import store.message.Mediator;
import utils.enums.PersonType;

/**
 * @className: Person
 * @author: Wenyue Li
 * @description: 人物 抽象类
 * @designPattern: AbstractFactory
 * @date: 8:42 下午 2019/10/21
 * @version: v1.1
 */
public abstract class Person {
    protected String name;      //人物名称
    protected PersonType type;  //人物类型，eg：顾客、店主、店员

    /** @update:  添加了中介者 Design-Pattern：Mediator - Xian Zhou */
    protected Mediator mediator ;

    /** @update: 更新了抽象构造器的形式 - Shidan Cheng */
    public Person(String name, PersonType type) {
        this.name = name;
        this.type = type;

        // 用于测试程序的输出

        System.out.printf(">>> 生成-人物-类型: %s\t姓名: %s;[√]\n", this.type.toString(), this.name);
    }


    /**
     *此人通过预备留言，加入留言板
     *
     * @methodName: addMessage
     * @author: Xian Zhou
     * @date:2019/10/25
     * @param:Mediator
     * @return:void
     */
    public  void addMediator(Mediator mediator){
        this.mediator = mediator;
        mediator.register(this.name, this);
    }

    public PersonType getPersonType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     *返回中介者
     *
     * @methodName: getMediator
     * @author: Xian Zhou
     * @date:2019/10/25
     * @param:Mediator
     * @return:void
     */
    public Mediator getMediator() { return this.mediator; }

}