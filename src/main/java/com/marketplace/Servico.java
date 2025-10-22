package com.marketplace;

/**
 * Representa um serviço no marketplace (ex: entrega, instalação).
 */
public class Servico extends ItemVenda {
    private int duracaoEstimada; // em minutos
    private String tipo; // ex: "entrega", "instalação", "manutenção"

    public Servico(String id, String nome, String descricao, double preco, 
                   int duracaoEstimada, String tipo) {
        super(id, nome, descricao, preco);
        this.duracaoEstimada = duracaoEstimada;
        this.tipo = tipo;
    }

    public int getDuracaoEstimada() {
        return duracaoEstimada;
    }

    public void setDuracaoEstimada(int duracaoEstimada) {
        this.duracaoEstimada = duracaoEstimada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String obterInformacoes() {
        return String.format("Serviço - %s | Tipo: %s | Preço: R$ %.2f | Duração estimada: %d minutos",
                getNome(), tipo, getPreco(), duracaoEstimada);
    }
}
