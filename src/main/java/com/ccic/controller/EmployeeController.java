package com.ccic.controller;

import com.ccic.dao.DepartmentDao;
import com.ccic.dao.EmployeeDao;
import com.ccic.entities.Department;
import com.ccic.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author :hzs
 * @Date :Created in 10:23 2019/11/27
 * @Description :
 * Modified By   :
 * @Version ：
 **/
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        // 来到员工添加页面 获取部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }
    // 员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:emps";
    }

    // 去修改页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id ,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }
    @PutMapping("emp")
    public String updateEmp(Employee employee) {
        System.out.println(employee);
        return "redirect:/emps";
    }


    /**
     *删除emp
    * */
    @DeleteMapping(value = "/emp/{id}")
    public String delEmp(@PathVariable("id")Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
