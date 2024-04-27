package com.bank.backoffice.account.persistence;

import com.bank.backoffice.account.domain.Account;
import com.bank.backoffice.account.domain.AccountId;
import com.bank.backoffice.account.domain.AccountRepository;
import com.bank.shared.domain.Service;
import com.bank.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;

import java.util.Optional;

@Service
public class MySqlAccountRepository extends HibernateRepository<Account> implements AccountRepository {

    public MySqlAccountRepository( SessionFactory sessionFactory ) {
        super(sessionFactory, Account.class);
    }

    @Override
    public void save( Account account ) {
        save( account );
    }

    @Override
    public Optional<Account> search( AccountId id ) {
        return search( id );
    }
}
