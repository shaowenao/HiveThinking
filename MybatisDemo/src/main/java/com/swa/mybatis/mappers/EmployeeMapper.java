package com.swa.mybatis.mappers;

import com.swa.mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    //增删改查
    Employee getEmployeeById(Integer id);

    //增加传入表名和id
    Employee getEmployeeById2(@Param("name") String name,@Param("empId")Integer id);

    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Integer id);
    //查询所有
    List<Employee> getAll();
}
