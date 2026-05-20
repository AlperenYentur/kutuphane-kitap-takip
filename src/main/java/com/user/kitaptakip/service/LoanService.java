package com.user.kitaptakip.service;

import com.user.kitaptakip.entity.Book;
import com.user.kitaptakip.entity.Loan;
import com.user.kitaptakip.entity.Member;
import com.user.kitaptakip.repository.BookRepository;
import com.user.kitaptakip.repository.LoanRepository;
import com.user.kitaptakip.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Loan createLoan(Long bookId, Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        if (!book.isAvailable()) {
            throw new RuntimeException("Kitap zaten ödünç alınmış.");
        }

        book.setAvailable(false);
        bookRepository.save(book);

        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);

        return loanRepository.save(loan);
    }
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Ödünç kaydı bulunamadı!"));

        if (loan.isReturned()) {
            throw new RuntimeException("Bu kitap zaten iade edilmiş!");
        }

        loan.setReturned(true);
        loan.setReturnDate(java.time.LocalDate.now());

        Book book = loan.getBook();
        book.setAvailable(true);
        bookRepository.save(book);

        return loanRepository.save(loan);
    }
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public List<Loan> getActiveLoansByMember(Long memberId) {
        return loanRepository.findByMemberIdAndIsReturnedFalse(memberId);
    }
}