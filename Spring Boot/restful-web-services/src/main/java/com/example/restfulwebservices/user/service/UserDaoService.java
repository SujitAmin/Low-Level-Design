package com.example.restfulwebservices.user.service;

import com.example.restfulwebservices.user.dao.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService implements UserService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;

    /*
    * In Java, the static {} block is a static initialization block.
    * This block is used to initialize static fields of a class.
    * The code inside the static {} block is executed when the class is loaded into memory,
    * which happens only once per class, not per instance.
    * */
    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    @Override
    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User deleteById(int id) {
        //use stream
        //Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if (user.getId() == id) {
//                iterator.remove();
//                return user;
//            }
//        }
//        return null;
        Optional<User> userToRemove = users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
        userToRemove.ifPresent(users::remove);
        return userToRemove.orElse(null);
    }
}
