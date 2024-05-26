package com.bank.backoffice.transactions.infrastructure.persistence;

import com.bank.backoffice.transactions.domain.Transaction;
import com.bank.backoffice.transactions.domain.TransactionId;
import com.bank.backoffice.transactions.domain.TransactionRepository;
import com.bank.shared.domain.Service;
import com.bank.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("backoffice-transaction_manager")
public class PostgrestTransactionRepository extends HibernateRepository<Transaction> implements TransactionRepository {

    public PostgrestTransactionRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Transaction.class);
    }

    @Override
    public void save(Transaction transaction) {
        persist(transaction);
    }

    @Override
    public Optional<Transaction> search(TransactionId id) {
        return byId(id);
    }
}
