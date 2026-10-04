package com.nit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 

public class EmployeeRecordManagement {

    static Scanner sc = new Scanner(System.in);

    // List = stores all employee records
    static List<Employee> employees = new ArrayList<>();

    // Set = stores unique employee IDs
    static Set<Integer> employeeIds = new HashSet<>();

    // Map = fast employee search using ID
    static Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EMPLOYEE RECORD MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    updateEmployee();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    searchEmployee();
                    break;

                case 5:
                    displayEmployees();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ADD EMPLOYEE
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (employeeIds.contains(id)) {
            System.out.println("Employee ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);

        employees.add(emp);
        employeeIds.add(id);
        employeeMap.put(id, emp);

        System.out.println("Employee added successfully!");
    }

    // UPDATE EMPLOYEE
    static void updateEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Employee emp = employeeMap.get(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.print("Enter New Name: ");
        emp.name = sc.nextLine();

        System.out.print("Enter New Department: ");
        emp.department = sc.nextLine();

        System.out.print("Enter New Salary: ");
        emp.salary = sc.nextDouble();

        System.out.println("Employee updated successfully!");
    }

    // DELETE EMPLOYEE
    static void deleteEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.get(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        employees.remove(emp);
        employeeIds.remove(id);
        employeeMap.remove(id);

        System.out.println("Employee deleted successfully!");
    }

    // SEARCH EMPLOYEE
    static void searchEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee emp = employeeMap.get(id);

        if (emp == null) {
            System.out.println("Employee not found!");
            return;
        }

        System.out.println("\n===== Employee Details =====");
        System.out.println("ID         : " + emp.id);
        System.out.println("Name       : " + emp.name);
        System.out.println("Department : " + emp.department);
        System.out.println("Salary     : " + emp.salary);
    }

    // DISPLAY ALL EMPLOYEES
    static void displayEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.println("\n===== ALL EMPLOYEES =====");

        for (Employee emp : employees) {

            System.out.println("ID         : " + emp.id);
            System.out.println("Name       : " + emp.name);
            System.out.println("Department : " + emp.department);
            System.out.println("Salary     : " + emp.salary);
            System.out.println("-------------------------");
        }
    }
}