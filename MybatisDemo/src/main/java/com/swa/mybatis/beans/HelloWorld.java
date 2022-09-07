package com.swa.mybatis.beans;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class HelloWorld {
    //Mybatis使用sqlSecession
    public static void main(String[] args) throws IOException, IOException {

        String resource = "mybatis_config.xml"; //声明配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Object o = sqlSession.selectOne("feichangbang.sql1", 1);

        Employee employee = (Employee) o;
        System.out.println(employee);
        sqlSession.close();

    }
}
