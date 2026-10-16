package Middle.Middle1.Repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Middle.Middle1.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
       try (Session session = sessionFactory.openSession()) {
           Transaction trans = session.beginTransaction();

           session.save(user);
           session.flush();
           trans.commit();

       }
    }

    public User findByLogin(String login) {

        try (Session session = sessionFactory.openSession()) {

            String hql = "SELECT u FROM User u WHERE u.login = :login";
            Query<User> query = session.createQuery(hql, User.class);
            query.setParameter("login", login);

            List<User> users = query.getResultList();

            if (users.isEmpty()) {
                return null;
            }

            return users.get(0);
        }
    }

}
