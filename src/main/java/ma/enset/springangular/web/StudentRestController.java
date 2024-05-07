package ma.enset.springangular.web;

import lombok.AllArgsConstructor;
import ma.enset.springangular.entities.*;
import ma.enset.springangular.services.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class StudentRestController {

    private PaymentService paymentService;

    @GetMapping(path = "/students")
    public List<Student> allStudents() {
        return paymentService.allStudents();
    }

    @GetMapping("/payments")
    public List<Payment> allPayments() {
        return paymentService.allPayments();
    }

    @GetMapping("/students/{code}")
    public Student getStudentByCode(@PathVariable String code) {
        return paymentService.getStudentByCode(code);
    }

    @GetMapping("/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }

    @GetMapping(path = "/studentsByProgram")
    public List<Student> studentsByProgram(@RequestParam String programId) {
        return paymentService.studentsByProgram(programId);
    }

    @GetMapping("/students/{code}/payments")
    public List<Payment> paymentsByStudentCode(@PathVariable String code) {
        return paymentService.paymentsByStudentCode(code);
    }

    @GetMapping("/payments/byStatus")
    public List<Payment> paymentsByStatus(@RequestParam PaymentStatus status) {
        return paymentService.paymentsByStatus(status);
    }

    @GetMapping("/payments/byType")
    public List<Payment> paymentsByType(@RequestParam PaymentType type) {
        return paymentService.paymentsByType(type);
    }

    @PutMapping("/payments/{id}/updateStatus")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id) {
        return paymentService.updatePaymentStatus(status, id);
    }

    @PostMapping(path = "/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam MultipartFile file, double amount, PaymentType type, LocalDate date, String studentCode) throws IOException {
        return paymentService.savePayment(file, amount, type, date, studentCode);

    }

    @GetMapping(path = "payments/{id}/file", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long id) throws IOException {
        return paymentService.getPaymentFile(id);
    }
}
