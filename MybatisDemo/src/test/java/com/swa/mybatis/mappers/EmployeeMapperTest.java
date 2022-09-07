package com.swa.mybatis.mappers;

import com.swa.mybatis.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;
/**
 * Created by Smexy on 2022/9/6
 *
 *      接口式无法直接实例化的！
 *          Mybatis可以通过动态代理机制，自动为接口提供一个实现对象
 *       查询： 不涉及事务
 *       增删改： 涉及事务。必须提交事务！
 */
public class EmployeeMapperTest {
    SqlSessionFactory sqlSessionFactory;

    {
        String resource = "mybatis_config.xml";
        InputStream inputStream = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void getEmployeeById() {
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(1);
            System.out.println(employee);


        }finally {
            sqlSession.close();
        }


    }

    @Test
    public void getEmployeeById2() {
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById2("employee",1);
            System.out.println(employee);


        }finally {
            sqlSession.close();
        }


    }



    @Test
    public void insertEmployee() {
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null,"jackma","male","jj@qq.com");
            mapper.insertEmployee(employee);
        }finally{
            sqlSession.close();
        }

    }

    @Test
    public void updateEmployee() {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeById(4);
            employee.setLastName("pony");
            mapper.updateEmployee(employee);
        }finally{
            sqlSession.close();
        }


    }

    @Test
    public void deleteEmployeeById() {
        SqlSession sqlSession = null;

        try{
            sqlSession = sqlSessionFactory.openSession(true);
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmployeeById(1);
        }
        finally{
            sqlSession.close();
        }


    }

    @Test
    public void getAll() {
        SqlSession sqlSession = null;
        try{
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> all = mapper.getAll();
            System.out.println(all);

        }finally{
            sqlSession.close();
        }


    }
}