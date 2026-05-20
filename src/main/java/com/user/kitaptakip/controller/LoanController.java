package com.user.kitaptakip.controller;

import com.user.kitaptakip.entity.Loan;
import com.user.kitaptakip.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/{bookId}/{memberId}")
    public ResponseEntity<Loan> createLoan(@PathVariable Long bookId, @PathVariable Long memberId) {
        return ResponseEntity.ok(loanService.createLoan(bookId, memberId));
    }
    @PatchMapping("/{loanId}/return")
    public ResponseEntity<Loan> returnBook(@PathVariable Long loanId) {
        return ResponseEntity.ok(loanService.returnBook(loanId));
    }
    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }
}