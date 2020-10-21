package br.com.richard.domain.ordem;

import br.com.richard.infrastructure.persistences.ordem.Ordem;
import br.com.richard.infrastructure.persistences.ordem.OrdemRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class OrdemService {

    OrdemRepository ordemRepository;

    public OrdemService(OrdemRepository ordemRepository) {
        this.ordemRepository = ordemRepository;
    }

    @Transactional
    public void insert(Ordem ordem) {

        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);

    }

}
