package com.bank.shared.infrastructure.hibernate;

import com.bank.shared.domain.Identifier;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public abstract class HibernateRepository<T> {
    protected final SessionFactory sessionFactory;
    protected final Class<T> aggregateClass;

    public HibernateRepository( SessionFactory sessionFactory, Class<T> aggregateClass ) {
        this.sessionFactory = sessionFactory;
        this.aggregateClass = aggregateClass;
    }

    protected void persist( T entity ) {
        sessionFactory.getCurrentSession().saveOrUpdate( entity );
        sessionFactory.getCurrentSession().flush();
        sessionFactory.getCurrentSession().clear();
    }

    protected Optional<T> byId( Identifier id ) {
        return Optional.ofNullable( sessionFactory.getCurrentSession().byId( aggregateClass ).load( id ) );
    }

}
