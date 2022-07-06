import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(SuperHero.class)
                .addAnnotatedClass(Car.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();
       List<Car>cars = new ArrayList<>();
       cars.add(new Car("tesla"));
       cars.add(new Car("BMW"));
        session.beginTransaction();
        session.save(new User("vasia", new SuperHero("superman", Side.DC), cars));
        session.save(new User("Vova", new SuperHero("spider-man", Side.MARVEL),cars));

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();


    }
}
