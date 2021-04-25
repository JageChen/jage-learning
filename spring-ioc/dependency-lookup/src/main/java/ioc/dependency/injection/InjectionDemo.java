package ioc.dependency.injection;

import ioc.dependency.demain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * description: LookUpDemo 依赖注入案例
 * date: 2021/4/22 23:48
 * author: Jage
 * version: 1.0
 */
public class InjectionDemo {
    public static void main(String[] args) {
        //这里做了两个事情 第一个 加载配置文件
        //第二个 启动应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/lookup-context.xml");
    }
}
