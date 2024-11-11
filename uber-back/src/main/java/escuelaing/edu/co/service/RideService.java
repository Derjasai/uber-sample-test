package escuelaing.edu.co.service;

import escuelaing.edu.co.model.Driver;
import escuelaing.edu.co.model.Position;
import escuelaing.edu.co.model.Ride;
import escuelaing.edu.co.repository.RideRepository;

import java.util.List;
import java.util.Optional;

public class RideService {

    private static RideService instance;
    private final RideRepository repository;
    private final UserService userService;
    private final DriverService driverService;
    private final PositionService positionService;

    public RideService() {
        this.repository = RideRepository.getInstance();
        this.userService = UserService.getInstance();
        this.driverService = DriverService.getInstance();
        this.positionService = PositionService.getInstance();
    }

    public static RideService getInstance() {
        if (instance == null) {
            synchronized (RideService.class) {
                if (instance == null) {
                    instance = new RideService();
                }
            }
        }
        return instance;
    }

    public List<Ride> getAll() {
        return repository.findAll();
    }

    public Ride getById(Long id) throws Exception {
        Optional<Ride> optRide = repository.findById(id);

        if (optRide.isEmpty()) {
            throw new Exception("Ride not found");
        }

        return optRide.get();
    }

    public Ride save(Ride ride) {
        return repository.save(ride);
    }

    public Ride updateById(Long id, Ride updatedRide) throws Exception {
        Optional<Ride> optRide = repository.updateById(id, updatedRide);

        if (optRide.isEmpty()) {
            throw new Exception("Ride not found");
        }

        return optRide.get();
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }

    private Ride getMockRide() throws Exception {
        Ride ride = this.getById(1L);

        ride.setDriver(driverService.getById(1L));
        ride.setUser(userService.getById(1L));

        return ride;
    }

    public Ride startRide() {
        try {
            return this.getMockRide();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Ride updateLocationDriver(Position originalPosition) {
        try {
            Ride ride = this.getMockRide();

            Driver driver = ride.getDriver();
            Position position = driver.getPosition();
            position.setX(originalPosition.getX());
            position.setY(originalPosition.getY());
            position = this.positionService.updatePosition(position);
            driver.setPosition(position);

            ride.setDriver(driver);

            return ride;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
