package pl.adambaranowski.jparelations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.adambaranowski.jparelations.dao.UserDao;
import pl.adambaranowski.jparelations.dao.UserDetailsDao;
import pl.adambaranowski.jparelations.model.User;
import pl.adambaranowski.jparelations.model.UserDetails;

@SpringBootApplication
public class JpaRelationsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(JpaRelationsApplication.class, args);

        UserDao userDao = ctx.getBean(UserDao.class);
        User user = new User("johnny234", "strongPass", "johnny@gmail.com");
        //zapisujemy obiekt bez UserDetails
        userDao.save(user);

        //dodajemy szczegóły do obiektu
        UserDetails details = new UserDetails("John", "Kowalski", "Krakowska 55, Warszawa");
        user.setDetails(details);
        userDao.update(user);

        //aktualizujemy hasło oraz imię
        user.setPassword("passPass");
        user.getDetails().setFirstName("Piotr");
        userDao.update(user);


        //pobieramy aktualny stan obiektu z bazy i wyświetlamy
        User userFromDb = userDao.get(1L);
        System.out.println(userFromDb);
        System.out.println("###########");

        UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class);
        UserDetails getUserDetails = userDetailsDao.get(1L);
        System.out.println(getUserDetails.getUser());
        System.out.println("############");

        //usuwamy obiekt z bazy
        //userDao.delete(user);

        //ponownie pobieramy  aktualny stan obiektu z bazy i wyświetlamy
        userFromDb = userDao.get(1L);
        System.out.println(userFromDb);
    }

}
