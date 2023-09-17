package me.tejaswan.LibraryManagement.controllers;

import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import me.tejaswan.LibraryManagement.entities.Loan;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanConflictException;
import me.tejaswan.LibraryManagement.exceptions.loans.LoanNotFoundException;
import me.tejaswan.LibraryManagement.services.LoanService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

@Api(tags = "Loan")
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/loan")
public class LoanController {
    private LoanService service;

    @PostMapping
    public Loan postLoan(@RequestBody Loan loan) {
        return service.createLoan(loan);
    }

    @GetMapping("/count")
    public ResponseEntity<?> countLong() {
        Map<String, Long> Res = new HashMap<>();
        Res.put("count", service.countLoan());
        return ResponseEntity.ok(Res);
    }

    @PutMapping("/clearloan")
    public Loan postClearLoan(@RequestParam UUID memberId, @RequestParam UUID loanId)
            throws LoanNotFoundException, LoanConflictException {
        return service.clearLoan(memberId, loanId);
    }
}
