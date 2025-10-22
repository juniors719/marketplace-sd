package com.marketplace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa uma loja com um catálogo de itens de venda.
 * Demonstra o conceito de agregação com ItemVenda.
 */
public class Loja {
    private String id;
    private String nome;
    private String endereco;
    private List<ItemVenda> catalogo;
    private Map<String, ItemVenda> catalogoPorId;

    public Loja(String id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.catalogo = new ArrayList<>();
        this.catalogoPorId = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Adiciona um item ao catálogo da loja.
     */
    public void adicionarItem(ItemVenda item) {
        if (item != null && !catalogoPorId.containsKey(item.getId())) {
            catalogo.add(item);
            catalogoPorId.put(item.getId(), item);
        }
    }

    /**
     * Remove um item do catálogo da loja.
     */
    public void removerItem(String itemId) {
        ItemVenda item = catalogoPorId.get(itemId);
        if (item != null) {
            catalogo.remove(item);
            catalogoPorId.remove(itemId);
        }
    }

    /**
     * Busca um item no catálogo pelo ID.
     */
    public ItemVenda buscarItem(String itemId) {
        return catalogoPorId.get(itemId);
    }

    /**
     * Retorna todos os itens do catálogo.
     */
    public List<ItemVenda> obterCatalogo() {
        return new ArrayList<>(catalogo);
    }

    /**
     * Retorna o número de itens no catálogo.
     */
    public int getTamanhoCatalogo() {
        return catalogo.size();
    }

    /**
     * Lista todos os itens do catálogo.
     */
    public void listarCatalogo() {
        System.out.println("=== Catálogo da Loja: " + nome + " ===");
        if (catalogo.isEmpty()) {
            System.out.println("Catálogo vazio.");
        } else {
            for (ItemVenda item : catalogo) {
                System.out.println(item.obterInformacoes());
            }
        }
    }

    @Override
    public String toString() {
        return "Loja{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", itens no catálogo=" + catalogo.size() +
                '}';
    }
}
