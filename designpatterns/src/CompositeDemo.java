import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 部分整体，类似树形结构
 * 公司CEO，管理TeamLeader，TeamLeader 有对应管理对应的部门。
 * http://www.tutorialspoint.com/design_pattern/composite_pattern.htm
 * Created by Tikitoo on 2015/12/6.
 */
public class CompositeDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("Joho", "CEO", "30000");
        Employee headSales = new Employee("Robert", "Head Sales", "20000");
        Employee headMarket = new Employee("Michel", "Head Market", "20000");
        Employee sale1 = new Employee("Lau", "sale", "5000");
        Employee sale2 = new Employee("bob", "sale", "5000");
        Employee market1 = new Employee("Richard", "market", "5000");
        Employee market2 = new Employee("Rob", "market", "5000");
        CEO.add(headSales);
        CEO.add(headMarket);

        headSales.add(sale1);
        headSales.add(sale2);

        headMarket.add(market1);
        headMarket.add(market2);

        System.out.println(CEO);

        for(Employee headEmployee: CEO.getEmployeeList()) {
            System.out.println(headEmployee);
            for(Employee employee : headEmployee.getEmployeeList()) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private String dept;
    private String salary;
    private List<Employee> mEmployeeList;

    public Employee(String name, String dept, String salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        mEmployeeList = new ArrayList<Employee>();
    }

    public void add(Employee employee) {
        mEmployeeList.add(employee);
    }


    public void remote(Employee employee) {
        mEmployeeList.remove(employee);
    }

    public List<Employee> getEmployeeList() {
        return mEmployeeList;
    }

    @Override
    public String toString() {
        return ("Employee: ["
                + "Name: " + name
                + "dept: " + dept
                + "salary: " + salary
                + "]");
    }
}
