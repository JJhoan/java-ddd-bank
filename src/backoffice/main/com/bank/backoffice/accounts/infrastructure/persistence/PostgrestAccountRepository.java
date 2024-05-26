package com.bank.backoffice.accounts.infrastructure.persistence;

import com.bank.backoffice.accounts.domain.Account;
import com.bank.backoffice.accounts.domain.AccountId;
import com.bank.backoffice.accounts.domain.AccountRepository;
import com.bank.shared.domain.Service;
import com.bank.shared.infrastructure.hibernate.HibernateRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional("backoffice-transaction_manager")
public class PostgrestAccountRepository extends HibernateRepository<Account> implements AccountRepository {

    public PostgrestAccountRepository(@Qualifier("backoffice-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Account.class);
    }

    @Override
    public void save(Account account) {
        persist(account);
    }

    @Override
    public Optional<Account> search(AccountId id) {
        return byId(id);
    }
}
