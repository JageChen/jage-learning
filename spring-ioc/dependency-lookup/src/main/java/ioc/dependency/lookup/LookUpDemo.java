package ioc.dependency.lookup;

import ioc.dependency.annotation.Super;
import ioc.dependency.demain.SuperUser;
import ioc.dependency.demain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.stream.Stream;

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
        //延迟查找
        lookupInLazy(beanFactory);
        //根据类型查找（单个实例）
        lookupByType(beanFactory);
        //根据类型查找(集合)
        lookupMapByType(beanFactory);
        //根据类型+名称查找
        lookupByNameOrType(beanFactory);
        //根据注解查找
        lookupByannotation(beanFactory);
    }

    /**
     * 注解查找单个依赖
    **/
    private static void lookupByannotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            //bean的名称作为keys 相关实例作为values
            Map<String, User> users =(Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(users);
        }
    }


    /**
     * 根据bean 类型，名称来查找依赖。简单不多阐述
     * @param beanFactory
     */
    private static void lookupByNameOrType(BeanFactory beanFactory) {
        User user = beanFactory.getBean("user",User.class);
        System.out.println(user);
    }

    /**
     *根据bean 类型来查找依赖返回多个同类型的bean实例
     * @param beanFactory
     */
    private static void lookupMapByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            //bean的名称作为keys 相关实例作为values
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println(users);
        }
    }

    /**
     * 根据bean 类型来查找依赖，无需过多解释调用容器API即可
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println(user);
    }

    /**
     * 延迟查找，通过ObjectFactory#getObject()
     * @param beanFactory
     */
    private static void lookupInLazy(BeanFactory beanFactory) {
        //延迟查找的原理指的是，获取的是个查找代理而不是直接获取到bean的实例，ObjectFactory就是一个查找代理.
        //ObjectFactory的getObject方法是从beanFactory中获取实例
        //所谓的延迟是指在注入时，不会马上注入目标对象，而是先弄一个句柄，当需要时，再次获取。(场景)
        ObjectFactory objectFactory = (ObjectFactory) beanFactory.getBean("objFactory");
        User user = (User) objectFactory.getObject();
        System.out.println(user);
    }


    /**
     * 根据beanNAME or ID 查找依赖（实时查找）
     * @param beanFactory
     */
    private static void lookupByRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println(user);
    }
}
