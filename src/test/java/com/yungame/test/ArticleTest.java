package com.yungame.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleTest {

	@Test
    public void testSave(){
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");//获取SPRING上下文
        SessionFactory sessionFactory=(SessionFactory)act.getBean("sessionFactory");//取得商品DAO
        sessionFactory.openSession();
        System.out.println(sessionFactory);
    }
}
