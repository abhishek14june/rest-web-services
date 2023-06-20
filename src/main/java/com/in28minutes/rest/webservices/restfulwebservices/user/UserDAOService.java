package com.in28minutes.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDAOService {
    private static List<User> users = new ArrayList<>();
    static int usercount =0;
    static {
        users.add(new User(++usercount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usercount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usercount,"Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return  users;
    }

    public User findOne(int id) {
        return users.stream().filter(user -> user.getId().equals(id))
                .findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++usercount);
        users.add(user);
        return user;
    }
}
