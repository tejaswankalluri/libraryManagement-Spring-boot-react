package me.tejaswan.LibraryManagement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
@ToString(exclude = "loans")
public class Member {

    @Id
    @GeneratedValue
    private UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    // @OneToMany(mappedBy = "member")
    // @JsonManagedReference
    // private List<Loan> loans;
}
