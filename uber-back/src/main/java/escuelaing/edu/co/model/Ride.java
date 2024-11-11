package escuelaing.edu.co.model;

import escuelaing.edu.co.types.RideStateType;

public class Ride {
    private Long id;
    private Payment payment;
    private User user;
    private Driver driver;
    private Position origin;
    private Position destination;
    private RideStateType state;

    public Ride(Long id, Payment payment, User user, Driver driver, Position origin, Position destination, RideStateType state) {
        this.id = id;
        this.payment = payment;
        this.user = user;
        this.driver = driver;
        this.origin = origin;
        this.destination = destination;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Position getOrigin() {
        return origin;
    }

    public void setOrigin(Position origin) {
        this.origin = origin;
    }

    public Position getDestination() {
        return destination;
    }

    public void setDestination(Position destination) {
        this.destination = destination;
    }

    public RideStateType getState() {
        return state;
    }

    public void setState(RideStateType state) {
        this.state = state;
    }
}
