//package com.tuzhi.dao;
//
//import com.tuzhi.pojo.Department;
//import com.tuzhi.pojo.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @program: SpringBoot-web
// * @description: 员工类
// * @author: 兔子
// * @create: 2021-12-11 14:13
// **/
//
//@Repository
//public class EmployeeDao {
//    private static Map<Integer, Employee> employeeMap = null;
//    @Autowired
//    private static DepartmentDao departmentDao;
//
//    static {
//        departmentDao = new DepartmentDao();
//        employeeMap = new HashMap<>();
//        employeeMap.put(101, new Employee(101, "小明", "542918096@qq.com", 1, departmentDao.getDepartmentById(1)));
//        employeeMap.put(102, new Employee(102, "小李", "54aaaaa@qq.com", 2, departmentDao.getDepartmentById(2)));
//    }
//
//    private static Integer initId = 103;
//
//    //    添加员工
//    public void addEmployee(Employee employee) {
//        int id = initId++;
//        employee.setId(id);
//        employeeMap.put(id, employee);
//    }
//
//    //    删除员工
//    public void deleteEmployee(int id) {
//        employeeMap.remove(id);
//    }
//
//    //    修改员工
//    public void updateEmployee(int id, Employee employee) {
//        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
//        employeeMap.put(id, employee);
//    }
//
//    //    查询全部员工
//    public Collection getEmployees() {
//        return employeeMap.values();
//    }
//
//    //    根据ID查询员工
//    public Employee getEmployeeById(int id) {
//        System.out.println("===============dao=============" + employeeMap.get(id));
//        return employeeMap.get(id);
//    }
//}
