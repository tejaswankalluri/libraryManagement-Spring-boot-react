package me.tejaswan.LibraryManagement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class Loan {
    @Id
    @GeneratedValue
    private UUID id;

    private Date loanDate;
    private Date dueDate;
    private Date returnDate;


    @ManyToOne()
    @JoinColumn(name = "member_id")
    @JsonBackReference
    private Member member;

    @ManyToOne()
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;
}
