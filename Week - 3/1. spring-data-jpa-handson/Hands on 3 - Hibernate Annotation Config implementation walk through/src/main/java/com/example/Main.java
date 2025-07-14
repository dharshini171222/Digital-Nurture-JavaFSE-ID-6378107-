package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // Load configuration and build session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // Open a session
        Session session = factory.openSession();

        try {
            // Create an employee object
            Employee emp = new Employee("Vineeth", 50000);

            // Begin transaction
            session.beginTransaction();

            // Save the object
            session.persist(emp);

            // Commit the transaction
            session.getTransaction().commit();

            System.out.println("Employee saved: " + emp);
        } finally {
            session.close();
            factory.close();
        }
    }
}
