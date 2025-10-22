package com.marketplace;

/**
 * Representa um produto físico no marketplace.
 */
public class ProdutoFisico extends ItemVenda {
    private double peso;
    private String dimensoes;
    private int estoque;

    public ProdutoFisico(String id, String nome, String descricao, double preco, 
                        double peso, String dimensoes, int estoque) {
        super(id, nome, descricao, preco);
        this.peso = peso;
        this.dimensoes = dimensoes;
        this.estoque = estoque;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String obterInformacoes() {
        return String.format("Produto Físico - %s | Preço: R$ %.2f | Peso: %.2fkg | Dimensões: %s | Estoque: %d unidades",
                getNome(), getPreco(), peso, dimensoes, estoque);
    }
}
