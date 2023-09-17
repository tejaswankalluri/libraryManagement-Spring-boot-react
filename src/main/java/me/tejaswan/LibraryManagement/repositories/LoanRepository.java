package me.tejaswan.LibraryManagement.repositories;

import me.tejaswan.LibraryManagement.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {
    Loan findByMemberIdAndId(UUID memberId, UUID loanId);
}
