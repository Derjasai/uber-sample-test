package escuelaing.edu.co.service;

import escuelaing.edu.co.model.Driver;
import escuelaing.edu.co.repository.DriverRepository;

import java.util.List;
import java.util.Optional;

public class DriverService {

    private static DriverService instance;
    private final DriverRepository repository;

    private DriverService() {
        this.repository = DriverRepository.getInstance();
    }

    public static DriverService getInstance() {
        if (instance == null) {
            synchronized (DriverService.class) {
                if (instance == null) {
                    instance = new DriverService();
                }
            }
        }
        return instance;
    }

    public List<Driver> getAll() {
        return repository.findAll();
    }

    public Driver getById(Long id) throws Exception {
        Optional<Driver> optDriver = repository.findById(id);

        if (optDriver.isEmpty()) {
            throw new Exception("Driver not found");
        }

        return optDriver.get();
    }

    public Driver save(Driver driver) {
        return repository.save(driver);
    }

    public Driver updateById(Long id, Driver driverUpdated) throws Exception {
        Optional<Driver> optDriver = repository.updateById(id, driverUpdated);

        if (optDriver.isEmpty()) {
            throw new Exception("Driver not found");
        }

        return optDriver.get();
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
