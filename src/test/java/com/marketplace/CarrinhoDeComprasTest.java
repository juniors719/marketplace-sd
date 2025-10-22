package com.marketplace;

/**
 * Testes para a interface CarrinhoDeCompras e sua implementação.
 */
public class CarrinhoDeComprasTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes de CarrinhoDeCompras ===\n");

        testAdicionarItem();
        testRemoverItem();
        testCalcularTotal();
        testFinalizarCompra();
        testLimparCarrinho();
        testCarrinhoVazio();

        System.out.println("\n=== Todos os testes de CarrinhoDeCompras passaram! ===");
    }

    private static void testAdicionarItem() {
        System.out.println("Testando adição de itens ao carrinho...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        carrinho.adicionarItem(produto, 2);
        assert carrinho.obterItens().size() == 1 : "Carrinho deve ter 1 tipo de item";
        
        Servico servico = new Servico(
            "S001", "Serviço 1", "Descrição 1", 50.00, 60, "instalação"
        );
        
        carrinho.adicionarItem(servico, 1);
        assert carrinho.obterItens().size() == 2 : "Carrinho deve ter 2 tipos de itens";
        
        // Adicionar mais unidades do mesmo produto
        carrinho.adicionarItem(produto, 1);
        assert carrinho.obterItens().size() == 2 : "Não deve duplicar item, apenas aumentar quantidade";
        
        System.out.println("✓ Adição de itens passou");
    }

    private static void testRemoverItem() {
        System.out.println("Testando remoção de itens do carrinho...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        carrinho.adicionarItem(produto, 1);
        assert carrinho.obterItens().size() == 1 : "Carrinho deve ter 1 item";
        
        carrinho.removerItem("P001");
        assert carrinho.obterItens().size() == 0 : "Carrinho deve estar vazio";
        
        System.out.println("✓ Remoção de itens passou");
    }

    private static void testCalcularTotal() {
        System.out.println("Testando cálculo de total...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        ProdutoFisico produto1 = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        ProdutoFisico produto2 = new ProdutoFisico(
            "P002", "Produto 2", "Descrição 2", 50.00, 1.0, "10x10x10", 5
        );
        
        carrinho.adicionarItem(produto1, 2); // 200.00
        carrinho.adicionarItem(produto2, 3); // 150.00
        
        double total = carrinho.calcularTotal();
        assert Math.abs(total - 350.00) < 0.01 : "Total deve ser 350.00, mas foi " + total;
        
        System.out.println("✓ Cálculo de total passou");
    }

    private static void testFinalizarCompra() {
        System.out.println("Testando finalização de compra...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        // Tentar finalizar carrinho vazio
        boolean resultado = carrinho.finalizarCompra();
        assert !resultado : "Não deve permitir finalizar carrinho vazio";
        
        // Adicionar item e finalizar
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        carrinho.adicionarItem(produto, 1);
        resultado = carrinho.finalizarCompra();
        assert resultado : "Deve permitir finalizar carrinho com itens";
        
        // Tentar adicionar item após finalizar
        try {
            carrinho.adicionarItem(produto, 1);
            assert false : "Não deve permitir adicionar item após finalizar";
        } catch (IllegalStateException e) {
            // Esperado
        }
        
        System.out.println("✓ Finalização de compra passou");
    }

    private static void testLimparCarrinho() {
        System.out.println("Testando limpeza de carrinho...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", "Produto 1", "Descrição 1", 100.00, 1.0, "10x10x10", 5
        );
        
        carrinho.adicionarItem(produto, 1);
        assert carrinho.obterItens().size() == 1 : "Carrinho deve ter 1 item";
        
        carrinho.limparCarrinho();
        assert carrinho.obterItens().size() == 0 : "Carrinho deve estar vazio";
        
        System.out.println("✓ Limpeza de carrinho passou");
    }

    private static void testCarrinhoVazio() {
        System.out.println("Testando carrinho vazio...");
        
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        
        assert carrinho.obterItens().isEmpty() : "Carrinho deve estar vazio inicialmente";
        assert carrinho.calcularTotal() == 0.0 : "Total deve ser 0.0 em carrinho vazio";
        
        System.out.println("✓ Carrinho vazio passou");
    }
}
