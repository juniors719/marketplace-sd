package com.marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementação concreta da interface CarrinhoDeCompras.
 */
public class CarrinhoDeComprasImpl implements CarrinhoDeCompras {
    private Map<String, ItemCarrinho> itens;
    private boolean finalizado;

    public CarrinhoDeComprasImpl() {
        this.itens = new HashMap<>();
        this.finalizado = false;
    }

    @Override
    public void adicionarItem(ItemVenda item, int quantidade) {
        if (item == null || quantidade <= 0) {
            throw new IllegalArgumentException("Item não pode ser nulo e quantidade deve ser maior que zero");
        }

        if (finalizado) {
            throw new IllegalStateException("Não é possível adicionar itens a um carrinho finalizado");
        }

        String itemId = item.getId();
        if (itens.containsKey(itemId)) {
            ItemCarrinho itemCarrinho = itens.get(itemId);
            itemCarrinho.setQuantidade(itemCarrinho.getQuantidade() + quantidade);
        } else {
            itens.put(itemId, new ItemCarrinho(item, quantidade));
        }
    }

    @Override
    public void removerItem(String itemId) {
        if (finalizado) {
            throw new IllegalStateException("Não é possível remover itens de um carrinho finalizado");
        }
        itens.remove(itemId);
    }

    @Override
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrinho itemCarrinho : itens.values()) {
            total += itemCarrinho.getItem().getPreco() * itemCarrinho.getQuantidade();
        }
        return total;
    }

    @Override
    public boolean finalizarCompra() {
        if (itens.isEmpty()) {
            return false;
        }
        finalizado = true;
        return true;
    }

    @Override
    public List<ItemVenda> obterItens() {
        List<ItemVenda> listaItens = new ArrayList<>();
        for (ItemCarrinho itemCarrinho : itens.values()) {
            listaItens.add(itemCarrinho.getItem());
        }
        return listaItens;
    }

    @Override
    public void limparCarrinho() {
        if (finalizado) {
            throw new IllegalStateException("Não é possível limpar um carrinho finalizado");
        }
        itens.clear();
    }

    /**
     * Verifica se o carrinho foi finalizado.
     */
    public boolean isFinalizado() {
        return finalizado;
    }

    /**
     * Retorna o número de itens diferentes no carrinho.
     */
    public int getNumeroItens() {
        return itens.size();
    }

    /**
     * Classe interna para representar um item no carrinho com sua quantidade.
     */
    private static class ItemCarrinho {
        private ItemVenda item;
        private int quantidade;

        public ItemCarrinho(ItemVenda item, int quantidade) {
            this.item = item;
            this.quantidade = quantidade;
        }

        public ItemVenda getItem() {
            return item;
        }

        public int getQuantidade() {
            return quantidade;
        }

        public void setQuantidade(int quantidade) {
            this.quantidade = quantidade;
        }
    }
}
