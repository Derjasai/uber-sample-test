package escuelaing.edu.co.repository;

import escuelaing.edu.co.model.Position;
import escuelaing.edu.co.model.User;
import escuelaing.edu.co.utils.RepositoryUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private static UserRepository instance;
    private final List<User> users = new ArrayList<>();

    private UserRepository() {
        User user1 = new User(
                RepositoryUtils.generateNewId(users, User::getId),
                RepositoryUtils.generateUniqueExternalId(),
                "Ellen",
                "Joe",
                "123456789",
                "123-456-789",
                new Position("0", "0"),
                "123456789"
        );

        User user2 = new User(
                RepositoryUtils.generateNewId(users, User::getId),
                RepositoryUtils.generateUniqueExternalId(),
                "Nicole",
                "Demara",
                "12345678",
                "123-456-789",
                new Position("0", "0"),
                "1234567899654"
        );

        users.add(user1);
        users.add(user2);
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public User save(User user) {
        user.setId(RepositoryUtils.generateNewId(users, User::getId));
        user.setExternalId(RepositoryUtils.generateUniqueExternalId());
        users.add(user);
        return user;
    }

    public Optional<User> updateById(Long id, User updatedUser) {
        return findById(id).map(existingUser -> {
            int index = users.indexOf(existingUser);
            updatedUser.setId(id);
            users.set(index, updatedUser);
            return updatedUser;
        });
    }

    public boolean deleteById(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
