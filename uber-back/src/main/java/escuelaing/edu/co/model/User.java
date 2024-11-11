package escuelaing.edu.co.model;

public class User extends GenericUser {
    private String cardNumber;

    public User(Long id, String externalId, String firstName, String lastName, String documentNumber, String phoneNumber, Position position, String cardNumber) {
        super(id, externalId, firstName, lastName, documentNumber, phoneNumber, position);
        this.cardNumber = cardNumber;
    }
}
