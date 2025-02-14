package br.com.richard.domain.bitcoin;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bitcoin {

    private Long id;
    private BigDecimal preco;
    private String tipo;
    private LocalDate data;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

}
