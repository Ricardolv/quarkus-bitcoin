package br.com.richard.infrastructure.persistence.ordem;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

}
