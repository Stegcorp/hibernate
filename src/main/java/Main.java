import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriveLicense.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        List<Car>cars = new ArrayList<>();
        List<Car> cars1 =new ArrayList<>();
        cars.add(new Car("megane",Type.UNIVERSAL,110,7000,2010));
        cars1.add(new Car("megane",Type.UNIVERSAL,130,8000,2012));
        Owner owner = new Owner("Ivan",cars,new DriveLicense("fsdfsdf"));
        Owner owner1 = new Owner("Petro",cars1,new DriveLicense("sdasdsad"));
        session.getTransaction().commit();
        session.save(owner);
        session.save(owner1);
        session.close();
        sessionFactory.close();


    }
}
