package escuelaing.edu.co.service;

import escuelaing.edu.co.model.Payment;
import escuelaing.edu.co.repository.PaymentRepository;

import java.util.List;
import java.util.Optional;

public class PaymentService {

    private static PaymentService instance;
    private final PaymentRepository repository;

    private PaymentService() {
        this.repository = PaymentRepository.getInstance();
    }

    public static PaymentService getInstance() {
        if (instance == null) {
            synchronized (PaymentService.class) {
                if (instance == null) {
                    instance = new PaymentService();
                }
            }
        }
        return instance;
    }

    public List<Payment> getAll() {
        return repository.findAll();
    }

    public Payment getById(Long id) throws Exception {
        Optional<Payment> optPayment = repository.findById(id);

        if (optPayment.isEmpty()) {
            throw new Exception("Payment not found");
        }

        return optPayment.get();
    }

    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    public Payment updateById(Long id, Payment updatedPayment) throws Exception {
        Optional<Payment> optPayment = repository.updateById(id, updatedPayment);

        if (optPayment.isEmpty()) {
            throw new Exception("Payment not found");
        }

        return optPayment.get();
    }

    public boolean deleteById(Long id) {
        return repository.deleteById(id);
    }
}
