package escuelaing.edu.co.repository;

import escuelaing.edu.co.model.Driver;
import escuelaing.edu.co.model.Position;
import escuelaing.edu.co.utils.RepositoryUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverRepository {

    private static DriverRepository instance;
    private final List<Driver> drivers = new ArrayList<>();

    private DriverRepository() {
        Driver driver1 = new Driver(
                RepositoryUtils.generateNewId(drivers, Driver::getId),
                RepositoryUtils.generateUniqueExternalId(),
                "John",
                "Doe",
                "12345678",
                "123-456-7890",
                new Position("0", "0"),
                "ABC123",
                "red",
                "Sedan"
        );

        Driver driver2 = new Driver(
                RepositoryUtils.generateNewId(drivers, Driver::getId),
                RepositoryUtils.generateUniqueExternalId(),
                "Jane",
                "Doe",
                "87654321",
                "123-456-7890",
                new Position("0", "0"),
                "DEF456",
                "Blue",
                "Sedan"
        );

        drivers.add(driver1);
        drivers.add(driver2);
    }

    public static DriverRepository getInstance() {
        if (instance == null) {
            synchronized (DriverRepository.class) {
                if (instance == null) {
                    instance = new DriverRepository();
                }
            }
        }
        return instance;
    }

    public Optional<Driver> findById(Long id) {
        return drivers.stream()
                .filter(driver -> driver.getId().equals(id))
                .findFirst();
    }

    public List<Driver> findAll() {
        return new ArrayList<>(drivers);
    }

    public Driver save(Driver driver) {
        driver.setId(RepositoryUtils.generateNewId(drivers, Driver::getId));
        driver.setExternalId(RepositoryUtils.generateUniqueExternalId());
        drivers.add(driver);
        return driver;
    }

    public Optional<Driver> updateById(Long id, Driver updatedDriver) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getId().equals(id)) {
                updatedDriver.setId(id);
                drivers.set(i, updatedDriver);
                return Optional.of(updatedDriver);
            }
        }
        return Optional.empty();
    }

    public boolean deleteById(Long id) {
        return drivers.removeIf(driver -> driver.getId().equals(id));
    }
}
