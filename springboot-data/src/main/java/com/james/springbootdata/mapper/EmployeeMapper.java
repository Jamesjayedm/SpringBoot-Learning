package com.james.springbootdata.mapper;

import com.james.springbootdata.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    void insertEmp(Employee employee);
}
