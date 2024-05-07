package ma.enset.springangular.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String code;
    private String programId;
    private String photo;

}
