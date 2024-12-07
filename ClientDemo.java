package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {
    public static void main(String[] args) {
        // Configure Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Open Session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        // Insert Device Record
        Device device = new Device();
        device.setBrand("Samsung");
        device.setModel("Galaxy");
        device.setPrice(500.00);
        session.save(device);

        // Insert Smartphone Record
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(1200.00);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution("12 MP");
        session.save(smartphone);

        // Insert Tablet Record
        Tablet tablet = new Tablet();
        tablet.setBrand("Lenovo");
        tablet.setModel("Tab P11");
        tablet.setPrice(300.00);
        tablet.setScreenSize("11 inches");
        tablet.setBatteryLife("15 hours");
        session.save(tablet);

        // Commit Transaction
        tx.commit();
        session.close();

        System.out.println("Records inserted successfully!");
    }
}
