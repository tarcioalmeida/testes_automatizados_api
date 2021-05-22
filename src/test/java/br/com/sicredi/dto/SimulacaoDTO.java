package br.com.sicredi.dto;

import com.google.gson.Gson;
import java.math.BigDecimal;

public class SimulacaoDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String email;

    private BigDecimal valor;

    private Integer parcelas;

    private Boolean seguro;

    public SimulacaoDTO() {
        this.id = null;
        this.nome = null;
        this.cpf = null;
        this.email = null;
        this.valor = null;
        this.parcelas = null;
        this.seguro = null;
    }

    public SimulacaoDTO(Long id, String nome, String cpf, String email, BigDecimal valor, Integer parcelas, boolean seguro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.parcelas = parcelas;
        this.seguro = seguro;
    }

    public SimulacaoDTO(String nome, String cpf, String email, BigDecimal valor, Integer parcelas, boolean seguro) {
        this.id = null;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.valor = valor;
        this.parcelas = parcelas;
        this.seguro = seguro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public boolean isSeguro() {
        return seguro;
    }

    public void setSeguro(boolean seguro) {
        this.seguro = seguro;
    }

    @Override
    public String toString() {
        return "SimulacaoDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", valor=" + valor +
                ", parcelas=" + parcelas +
                ", seguro=" + seguro +
                '}';
    }

    public String converterParaJson(){
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
