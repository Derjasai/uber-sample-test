package escuelaing.edu.co.repository;

import escuelaing.edu.co.model.Position;
import escuelaing.edu.co.model.Ride;
import escuelaing.edu.co.types.RideStateType;
import escuelaing.edu.co.utils.RepositoryUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RideRepository {

    private static RideRepository instance;
    private final List<Ride> rides = new ArrayList<>();

    private RideRepository() {
        Ride ride1 = new Ride(
                RepositoryUtils.generateNewId(rides, Ride::getId),
                null,
                null,
                null,
                new Position("0", "0"),
                new Position("40", "35"),
                RideStateType.IN_PROGRESS
        );

        Ride ride2 = new Ride(
                RepositoryUtils.generateNewId(rides, Ride::getId),
                null,
                null,
                null,
                new Position("0", "0"),
                new Position("40", "35"),
                RideStateType.COMPLETED
        );

        rides.add(ride1);
        rides.add(ride2);
    }

    public static RideRepository getInstance() {
        if (instance == null) {
            synchronized (RideRepository.class) {
                if (instance == null) {
                    instance = new RideRepository();
                }
            }
        }
        return instance;
    }

    public Optional<Ride> findById(Long id) {
        return rides.stream()
                .filter(ride -> ride.getId().equals(id))
                .findFirst();
    }

    public List<Ride> findAll() {
        return new ArrayList<>(rides);
    }

    public Ride save(Ride ride) {
        ride.setId(RepositoryUtils.generateNewId(rides, Ride::getId));
        rides.add(ride);
        return ride;
    }

    public Optional<Ride> updateById(Long id, Ride updatedRide) {
        return findById(id).map(existingRide -> {
            int index = rides.indexOf(existingRide);
            updatedRide.setId(id);
            rides.set(index, updatedRide);
            return updatedRide;
        });
    }

    public boolean deleteById(Long id) {
        return rides.removeIf(ride -> ride.getId().equals(id));
    }
}
