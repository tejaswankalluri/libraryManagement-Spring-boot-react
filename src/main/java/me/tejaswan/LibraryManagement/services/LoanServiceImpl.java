package me.tejaswan.LibraryManagement.services;

import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Loan;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanConflictException;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanNotFoundException;
import me.tejaswan.LibraryManagement.repositories.LoanRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LoanServiceImpl implements LoanService {
    private LoanRepository repository;

    @Override
    public Loan createLoan(Loan loan) {
        return repository.save(loan);
    }

    @Override
    public Loan clearLoan(UUID memberId, UUID loanId) throws LoanNotFoundException, LoanConflictException {
        Loan loan = repository.findByMemberIdAndId(memberId, loanId);
        if (loan == null) {
            throw new LoanNotFoundException("Loan not Found");
        }
        if (loan.getReturnDate() != null) {
            throw new LoanConflictException("Loan is already cleared");
        }
        loan.setReturnDate(Calendar.getInstance().getTime());
        repository.save(loan);
        return loan;
    }

    @Override
    public long countLoan() {
        return repository.count();
    }
}