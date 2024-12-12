package com.pierremaurand.book.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookTransactionHistoryRepository extends JpaRepository<BookTransactionHistory, Integer>{
    @Query("""
            SELECT h
            FROM BookTransactionHistory h
            WHERE h.user.id = :userId
            """)
    Page<BookTransactionHistory> findAllBorrowedBooks(Pageable pageable,Integer userId);

    @Query("""
            SELECT h
            FROM BookTransactionHistory h
            WHERE h.book.createdBy= :userId
            """)
    Page<BookTransactionHistory> findAllReturnedBooks(Pageable pageable, Integer userId);

    @Query("""
            SELECT
            (COUNT (h) > 0) AS isBorrowed
            FROM BookTransactionHistory h
            WHERE h.book.id = :bookId
            AND h.createdBy = :userId
            AND h.returnApproved = false
            """)
    boolean isAlreadyBorrowedByUser(@Param("bookId") Integer bookId, @Param("userId") Integer userId);

    @Query("""
            SELECT
            (COUNT (h) > 0) AS isBorrowed
            FROM BookTransactionHistory h
            WHERE h.book.id = :bookId
            AND h.returnApproved = false
            """)
    boolean isAlreadyBorrowed(@Param("bookId") Integer bookId);

    @Query("""
            SELECT h
            FROM BookTransactionHistory h
            WHERE h.book.id = :bookId
            AND h.user.id = :userId
            AND h.returned = false
            AND h.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndUserId(@Param("bookId") Integer bookId, @Param("userId") Integer userId);

    @Query("""
            SELECT h
            FROM BookTransactionHistory h
            WHERE h.book.id = :bookId
            AND h.book.createdBy = :userId
            AND h.returned = true
            AND h.returnApproved = false
            """)
    Optional<BookTransactionHistory> findByBookIdAndOwnerId(@Param("bookId") Integer bookId, @Param("userId") Integer userId);
}
