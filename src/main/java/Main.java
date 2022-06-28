import models.Car;
import models.Owner;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new Owner("Stepan", new Car("tesla", Type.ELECTRICALCAR, 450, 50000, 2014)));
        session.save(new Owner("Ivan", new Car("BMW", Type.SEDAN, 450, 24000, 2014)));
        session.save(new Owner("Petro", new Car("tesla", Type.ELECTRICALCAR, 450, 50000, 2014)));
        session.save(new Owner("Taras", new Car("tesla", Type.ELECTRICALCAR, 450, 50000, 2014)));
        session.save(new Owner("Oleg", new Car("tesla", Type.ELECTRICALCAR, 450, 50000, 2014)));
        session.getTransaction().commit();
        session.createQuery("select o from Owner o ", Owner.class).getResultList().forEach(owner -> {
            System.out.println(owner);
            System.out.println(owner.getCar());
        });
        session.close();
        sessionFactory.close();


    }
}
