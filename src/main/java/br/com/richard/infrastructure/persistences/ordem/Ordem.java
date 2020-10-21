package br.com.richard.infrastructure.persistences.ordem;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ordem")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal preco;
    private String tipo;
    private LocalDate data;
    private String status;

    @Column(name = "user_id")
    private Long userId;


    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getUserId() {
        return userId;
    }
}
