import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Word.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

        Session session = sessionFactory
                .openSession();

        session.beginTransaction();

        session.save(new Word("tomato"));
        session.save(new Word("sun"));
        session.save(new Word("alcohol"));
        session.save(new Word("panda"));
        session.save(new Word("car"));
        session.save(new Word("water"));
        session.save(new Word("window"));






        session.getTransaction().commit();

        List<Word> list = session.createQuery("select u from Word u ", Word.class).getResultList();
        System.out.println(list);


        session.close();
        sessionFactory.close();
    }
}
