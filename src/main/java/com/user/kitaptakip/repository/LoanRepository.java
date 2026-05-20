package com.user.kitaptakip.repository;

import com.user.kitaptakip.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMemberIdAndIsReturnedFalse(Long memberId);
}