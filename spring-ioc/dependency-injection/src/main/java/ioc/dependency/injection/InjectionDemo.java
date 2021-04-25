package ioc.dependency.injection;

import ioc.dependency.domain.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/injection-context.xml");
        //根据名称注入
        injectionByName(beanFactory);
        //根据类型注入单个实例
        injectionSingleByType(beanFactory);
        //构建内建对象及内建非bean对象
        //injectionBuiltInObjects(beanFactory);
        //延时注入
        injectionInLazy(beanFactory);
    }

    /**
     * 延时注入这里跟上一篇依赖查找的延时查找一样
     **/
    private static void injectionInLazy(BeanFactory beanFactory) {
        UserRepository user = (UserRepository) beanFactory.getBean("userRepositoryByUtil");
        //内建对象
        System.out.println(user.getObjectFactory().getObject());
    }

    /**
     * 构建内建对象及内建非bean对象（后续会详细讲解,此处只讲实现）
     **/
    private static void injectionBuiltInObjects(BeanFactory beanFactory) {
        UserRepository user = (UserRepository) beanFactory.getBean("userRepositoryByUtil");
        //内建对象
        System.out.println(user.getBeanFactory());
        //非 Bean 对象
        System.out.println(beanFactory.getBean(BeanFactory.class));
    }

    /**
     * 根据类型注入实例,重点在xml配置中
     **/
    private static void injectionSingleByType(BeanFactory beanFactory) {
        UserRepository user = (UserRepository) beanFactory.getBean("userRepositoryByUtil");
        System.out.println(user.getUsers());
    }

    /**
    * 根据名称注入比较简单这里不详细说明
    **/
    private static void injectionByName(BeanFactory beanFactory) {
        UserRepository user = (UserRepository) beanFactory.getBean("userRepository");
        System.out.println(user.getUsers());
    }
}
