package com.marketplace;

/**
 * Executor de todos os testes do sistema.
 */
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║  Sistema de Marketplace - Execução de Testes     ║");
        System.out.println("╚═══════════════════════════════════════════════════╝\n");

        try {
            // Executar testes de ItemVenda
            ItemVendaTest.main(args);
            System.out.println();

            // Executar testes de Loja
            LojaTest.main(args);
            System.out.println();

            // Executar testes de CarrinhoDeCompras
            CarrinhoDeComprasTest.main(args);
            System.out.println();

            System.out.println("╔═══════════════════════════════════════════════════╗");
            System.out.println("║  ✓ TODOS OS TESTES PASSARAM COM SUCESSO!         ║");
            System.out.println("╚═══════════════════════════════════════════════════╝");

        } catch (AssertionError e) {
            System.err.println("\n✗ FALHA NO TESTE: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            System.err.println("\n✗ ERRO DURANTE EXECUÇÃO DOS TESTES: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}
