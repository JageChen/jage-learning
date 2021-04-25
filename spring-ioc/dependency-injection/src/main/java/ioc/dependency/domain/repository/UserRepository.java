package ioc.dependency.domain.repository;

import ioc.dependency.domain.SuperUser;
import ioc.dependency.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;

import java.util.Collection;

/**
 * description: UserRepository 用户仓库
 * date: 2021/4/25 22:04
 * author: Jage
 * version: 1.0
 */
public class UserRepository {
    private Collection<User> users;
    private BeanFactory beanFactory;

    //省略的延迟注入
    private ObjectFactory<SuperUser> objectFactory;

    public ObjectFactory<SuperUser> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<SuperUser> objectFactory) {
        this.objectFactory = objectFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
