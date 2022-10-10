package edu.mypet.manager;

import edu.mypet.domain.AreaFuller;
import edu.mypet.domain.DistrictFuller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DistrictManager {
    private static Map<String,String>map=new HashMap<>();
    private static final Logger logger= LoggerFactory.getLogger(AreaManager.class);

    public static void main(String[] args) {
        map.put("99","Uzbectelecom");
        map.put("97","UMS");
        map.put("98","Perfectum Mobile");
        map.put("33","HUMANS");
        map.put("93","Ucell(Coscom)");
        map.put("88","UMS");
        map.put("94","Ucell");
        map.put("90","Beeline");
        map.put("91","Beeline");
        SessionFactory sessionFactory=buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        DistrictFuller fuller;
        for(Map.Entry<String,String>map:map.entrySet()) {
            fuller=new DistrictFuller();
            fuller.setDistrictCode(map.getKey());
            fuller.setDistrictName(map.getValue());
            session.save(fuller);
        }
        session.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate2.cfg.xml").build();
            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
            return metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed."+e);
            throw new ExceptionInInitializerError(e);
        }

    }
}
