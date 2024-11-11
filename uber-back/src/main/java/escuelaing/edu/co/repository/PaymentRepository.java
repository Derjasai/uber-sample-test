package escuelaing.edu.co.repository;

import escuelaing.edu.co.model.Payment;
import escuelaing.edu.co.types.PaymentType;
import escuelaing.edu.co.utils.RepositoryUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaymentRepository {

    private static PaymentRepository instance;
    private final List<Payment> payments = new ArrayList<>();

    private PaymentRepository() {
        Payment payment1 = new Payment(
                RepositoryUtils.generateNewId(payments, Payment::getId),
                5000L,
                "USD",
                PaymentType.CREDIT_CARD
        );

        Payment payment2 = new Payment(
                RepositoryUtils.generateNewId(payments, Payment::getId),
                7500L,
                "USD",
                PaymentType.CASH
        );

        payments.add(payment1);
        payments.add(payment2);
    }

    public static PaymentRepository getInstance() {
        if (instance == null) {
            synchronized (PaymentRepository.class) {
                if (instance == null) {
                    instance = new PaymentRepository();
                }
            }
        }
        return instance;
    }

    public Optional<Payment> findById(Long id) {
        return payments.stream()
                .filter(payment -> payment.getId().equals(id))
                .findFirst();
    }

    public List<Payment> findAll() {
        return new ArrayList<>(payments);
    }

    public Payment save(Payment payment) {
        payment.setId(RepositoryUtils.generateNewId(payments, Payment::getId));
        payments.add(payment);
        return payment;
    }

    public Optional<Payment> updateById(Long id, Payment updatedPayment) {
        return findById(id).map(existingPayment -> {
            int index = payments.indexOf(existingPayment);
            updatedPayment.setId(id);
            payments.set(index, updatedPayment);
            return updatedPayment;
        });
    }

    public boolean deleteById(Long id) {
        return payments.removeIf(payment -> payment.getId().equals(id));
    }
}
