package com.marketplace;

/**
 * Classe de demonstração do sistema de marketplace.
 */
public class MarketplaceDemo {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Marketplace para Comércio Local ===\n");

        // Criar uma loja
        Loja loja = new Loja("L001", "Loja do João", "Rua Principal, 123");
        System.out.println("Loja criada: " + loja + "\n");

        // Criar produtos físicos
        ProdutoFisico produto1 = new ProdutoFisico(
            "P001", 
            "Notebook Dell", 
            "Notebook com 16GB RAM e SSD 512GB", 
            3500.00, 
            2.5, 
            "35x25x2 cm", 
            10
        );

        ProdutoFisico produto2 = new ProdutoFisico(
            "P002", 
            "Mouse Wireless", 
            "Mouse sem fio ergonômico", 
            89.90, 
            0.15, 
            "10x6x4 cm", 
            50
        );

        // Criar serviços
        Servico servico1 = new Servico(
            "S001", 
            "Entrega Express", 
            "Entrega rápida em até 2 horas", 
            25.00, 
            120, 
            "entrega"
        );

        Servico servico2 = new Servico(
            "S002", 
            "Instalação de Software", 
            "Instalação e configuração de software", 
            80.00, 
            90, 
            "instalação"
        );

        // Criar produtos digitais
        ProdutoDigital produtoDigital1 = new ProdutoDigital(
            "D001", 
            "Voucher de Desconto", 
            "Vale de R$ 100 para próxima compra", 
            90.00, 
            "Digital", 
            "https://exemplo.com/voucher123", 
            "31/12/2025"
        );

        ProdutoDigital produtoDigital2 = new ProdutoDigital(
            "D002", 
            "Ingresso Show", 
            "Ingresso para show de rock", 
            150.00, 
            "PDF", 
            "https://exemplo.com/ingresso456", 
            "15/11/2025"
        );

        // Adicionar itens ao catálogo da loja
        loja.adicionarItem(produto1);
        loja.adicionarItem(produto2);
        loja.adicionarItem(servico1);
        loja.adicionarItem(servico2);
        loja.adicionarItem(produtoDigital1);
        loja.adicionarItem(produtoDigital2);

        // Listar catálogo
        loja.listarCatalogo();
        System.out.println();

        // Criar carrinho de compras
        CarrinhoDeCompras carrinho = new CarrinhoDeComprasImpl();
        System.out.println("=== Carrinho de Compras ===");

        // Adicionar itens ao carrinho
        carrinho.adicionarItem(produto1, 1);
        System.out.println("Adicionado ao carrinho: " + produto1.getNome());

        carrinho.adicionarItem(produto2, 2);
        System.out.println("Adicionado ao carrinho: " + produto2.getNome() + " (x2)");

        carrinho.adicionarItem(servico1, 1);
        System.out.println("Adicionado ao carrinho: " + servico1.getNome());

        carrinho.adicionarItem(produtoDigital1, 1);
        System.out.println("Adicionado ao carrinho: " + produtoDigital1.getNome());

        // Calcular total
        double total = carrinho.calcularTotal();
        System.out.println("\nTotal do carrinho: R$ " + String.format("%.2f", total));

        // Finalizar compra
        if (carrinho.finalizarCompra()) {
            System.out.println("Compra finalizada com sucesso!");
        } else {
            System.out.println("Erro ao finalizar compra.");
        }

        System.out.println("\n=== Demonstração concluída ===");
    }
}
