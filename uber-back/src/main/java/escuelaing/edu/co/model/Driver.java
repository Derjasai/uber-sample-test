package escuelaing.edu.co.model;

public class Driver extends GenericUser {
    private String carPlates;
    private String carColor;
    private String carType;

    public Driver(Long id, String externalId, String firstName, String lastName, String documentNumber, String phoneNumber, Position position, String carPlates, String carColor, String carType) {
        super(id, externalId, firstName, lastName, documentNumber, phoneNumber, position);
        this.carPlates = carPlates;
        this.carColor = carColor;
        this.carType = carType;
    }

    public String getCarPlates() {
        return carPlates;
    }

    public void setCarPlates(String carPlates) {
        this.carPlates = carPlates;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}
