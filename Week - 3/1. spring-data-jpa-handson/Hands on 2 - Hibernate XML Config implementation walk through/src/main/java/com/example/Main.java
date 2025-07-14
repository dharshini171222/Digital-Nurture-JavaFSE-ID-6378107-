package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Load config and mapping
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            // Save a new Employee
            Employee emp = new Employee();
            emp.setName("John Doe");
            emp.setDepartment("HR");
            emp.setSalary(55000);
            session.save(emp);

            // Fetch all Employees
            List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
            for (Employee e : employees) {
                System.out.println(e);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
