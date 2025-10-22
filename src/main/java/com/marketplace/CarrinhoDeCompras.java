package com.marketplace;

import java.util.List;

/**
 * Interface que define as operações de um carrinho de compras.
 */
public interface CarrinhoDeCompras {
    /**
     * Adiciona um item ao carrinho.
     * @param item O item a ser adicionado
     * @param quantidade A quantidade do item
     */
    void adicionarItem(ItemVenda item, int quantidade);

    /**
     * Remove um item do carrinho.
     * @param itemId O ID do item a ser removido
     */
    void removerItem(String itemId);

    /**
     * Calcula o total do carrinho.
     * @return O valor total
     */
    double calcularTotal();

    /**
     * Finaliza a compra.
     * @return true se a compra foi finalizada com sucesso, false caso contrário
     */
    boolean finalizarCompra();

    /**
     * Retorna a lista de itens no carrinho.
     * @return Lista de itens
     */
    List<ItemVenda> obterItens();

    /**
     * Limpa o carrinho.
     */
    void limparCarrinho();
}
