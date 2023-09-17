package me.tejaswan.LibraryManagement.services;

import me.tejaswan.LibraryManagement.entities.Loan;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanConflictException;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanNotFoundException;

import java.util.UUID;

public interface LoanService {
    Loan createLoan(Loan loan);

    Loan clearLoan(UUID memberId, UUID loanId) throws LoanNotFoundException, LoanConflictException;

    long countLoan();
}
