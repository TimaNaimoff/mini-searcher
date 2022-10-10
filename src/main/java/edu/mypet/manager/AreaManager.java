package edu.mypet.manager;


import edu.mypet.domain.AreaFuller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

public class AreaManager {
    private static final Logger logger= LoggerFactory.getLogger(AreaManager.class);
    private static Map<String,String> map=new HashMap<>();
    public static void main(String[] args) {
        map.put("+998","Uzbekistan");
        SessionFactory sessionFactory=buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        AreaFuller fuller;
        for(Map.Entry<String,String>map:map.entrySet()) {
            fuller=new AreaFuller();
            fuller.setAreaCode(map.getKey());
            fuller.setAreaName(map.getValue());
            session.save(fuller);
        }
        session.close();
    }
    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed."+e);
            throw new ExceptionInInitializerError(e);
        }

    }
}
