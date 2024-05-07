package ma.enset.springangular.repositories;

import ma.enset.springangular.entities.Payment;
import ma.enset.springangular.entities.PaymentStatus;
import ma.enset.springangular.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByType(PaymentType type);
}
