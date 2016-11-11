import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Dawid on 11.11.2016 at 17:11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/hibernate.xml"})
public class ConnectionToDatabaseTest {
    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void isConnected() {
        Session session = sessionFactory.openSession();
        session.doWork(connection -> {
        });
    }
}