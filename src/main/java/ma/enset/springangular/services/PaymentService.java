package ma.enset.springangular.services;

import lombok.AllArgsConstructor;
import ma.enset.springangular.entities.*;
import ma.enset.springangular.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

@Service
@Transactional
@AllArgsConstructor
public class PaymentService {

    private PaymentRepository paymentRepository;
    private StudentRepository studentRepository;


    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    public Student getStudentByCode(String code) {
        return studentRepository.findByCode(code);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Student> studentsByProgram(String programId) {
        return studentRepository.findByProgramId(programId);
    }

    public List<Payment> paymentsByStudentCode(String code) {
        return paymentRepository.findByStudentCode(code);
    }

    public List<Payment> paymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    public List<Payment> paymentsByType(PaymentType type) {
        return paymentRepository.findByType(type);
    }

    public Payment savePayment(MultipartFile file, double amount, PaymentType type, LocalDate date, String studentCode) throws IOException {
        Path folderPath = Paths.get(System.getProperty("user.home"), "enset-data", "payments");
        if (!Files.exists(folderPath)) {
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "enset-students", "payments", fileName + ".pdf");
        Files.copy(file.getInputStream(), filePath);
        Student student = studentRepository.findByCode(studentCode);
        Payment payment = Payment
                .builder()
                .type(type)
                .status(PaymentStatus.CREATED)
                .date(date)
                .student(student)
                .amount(amount)
                .file(filePath.toUri().toString())
                .build();
        return paymentRepository.save(payment);

    }


    public Payment updatePaymentStatus(PaymentStatus status, Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId).get();
        payment.setStatus(status);
        return paymentRepository.save(payment);
    }

    public byte[] getPaymentFile(Long id) throws IOException {
        Payment payment = paymentRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }
}