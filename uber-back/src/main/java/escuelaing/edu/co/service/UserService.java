package escuelaing.edu.co.service;

import escuelaing.edu.co.model.User;
import escuelaing.edu.co.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {

    private static UserService instance;
    private final UserRepository repository;

    private UserService() {
        this.repository = UserRepository.getInstance();
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User getById(Long id) throws Exception {
        Optional<User> optUser = repository.findById(id);

        if (optUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return optUser.get();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public User updateById(Long id, User updatedUser) throws Exception {
        Optional<User> optUser = repository.updateById(id, updatedUser);

        if (optUser.isEmpty()) {
            throw new Exception("User not found");
        }

        return optUser.get();
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
