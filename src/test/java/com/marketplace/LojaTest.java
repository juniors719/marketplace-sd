package com.marketplace;

/**
 * Testes para a classe Loja.
 */
public class LojaTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes de Loja ===\n");

        testCriacaoLoja();
        testAdicionarItem();
        testRemoverItem();
        testBuscarItem();
        testCatalogoVazio();

        System.out.println("\n=== Todos os testes de Loja passaram! ===");
    }

    private static void testCriacaoLoja() {
        System.out.println("Testando criação de Loja...");
        
        Loja loja = new Loja("L001", "Loja Teste", "Rua A, 123");
        
        assert loja.getId().equals("L001") : "ID incorreto";
        assert loja.getNome().equals("Loja Teste") : "Nome incorreto";
        assert loja.getEndereco().equals("Rua A, 123") : "Endereço incorreto";
        assert loja.getTamanhoCatalogo() == 0 : "Catálogo deve estar vazio inicialmente";
        
        System.out.println("✓ Criação de Loja passou");
    }

    private static void testAdicionarItem() {
        System.out.println("Testando adição de itens ao catálogo...");
        
        Loja loja = new Loja("L001", "Loja Teste", "Rua A, 123");
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        loja.adicionarItem(produto);
        assert loja.getTamanhoCatalogo() == 1 : "Catálogo deve ter 1 item";
        
        Servico servico = new Servico(
            "S001", "Serviço 1", "Descrição 1", 50.00, 60, "instalação"
        );
        
        loja.adicionarItem(servico);
        assert loja.getTamanhoCatalogo() == 2 : "Catálogo deve ter 2 itens";
        
        // Tentar adicionar item duplicado
        loja.adicionarItem(produto);
        assert loja.getTamanhoCatalogo() == 2 : "Não deve adicionar item duplicado";
        
        System.out.println("✓ Adição de itens passou");
    }

    private static void testRemoverItem() {
        System.out.println("Testando remoção de itens do catálogo...");
        
        Loja loja = new Loja("L001", "Loja Teste", "Rua A, 123");
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        loja.adicionarItem(produto);
        assert loja.getTamanhoCatalogo() == 1 : "Catálogo deve ter 1 item";
        
        loja.removerItem("P001");
        assert loja.getTamanhoCatalogo() == 0 : "Catálogo deve estar vazio após remoção";
        
        // Tentar remover item que não existe
        loja.removerItem("P999");
        assert loja.getTamanhoCatalogo() == 0 : "Remover item inexistente não deve causar erro";
        
        System.out.println("✓ Remoção de itens passou");
    }

    private static void testBuscarItem() {
        System.out.println("Testando busca de itens...");
        
        Loja loja = new Loja("L001", "Loja Teste", "Rua A, 123");
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        loja.adicionarItem(produto);
        
        ItemVenda itemEncontrado = loja.buscarItem("P001");
        assert itemEncontrado != null : "Deve encontrar o item";
        assert itemEncontrado.getId().equals("P001") : "ID do item encontrado deve ser correto";
        
        ItemVenda itemNaoEncontrado = loja.buscarItem("P999");
        assert itemNaoEncontrado == null : "Item inexistente deve retornar null";
        
        System.out.println("✓ Busca de itens passou");
    }

    private static void testCatalogoVazio() {
        System.out.println("Testando catálogo vazio...");
        
        Loja loja = new Loja("L001", "Loja Teste", "Rua A, 123");
        
        assert loja.obterCatalogo().isEmpty() : "Catálogo deve estar vazio";
        assert loja.getTamanhoCatalogo() == 0 : "Tamanho do catálogo deve ser 0";
        
        System.out.println("✓ Catálogo vazio passou");
    }
}
