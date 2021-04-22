package ioc.dependency.lookup;

import ioc.dependency.demain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * description: LookUpDemo 依赖查找案例
 * date: 2021/4/22 23:48
 * author: Jage
 * version: 1.0
 */
public class LookUpDemo {
    public static void main(String[] args) {
        //这里做了两个事情 第一个 加载配置文件
        //第二个 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/lookup-context.xml");
        //实时查找
        lookupByRealTime(beanFactory);
    }

    private static void lookupByRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
