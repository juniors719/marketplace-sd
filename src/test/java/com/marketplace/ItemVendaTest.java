package com.marketplace;

/**
 * Testes para a classe ItemVenda e suas subclasses.
 */
public class ItemVendaTest {

    public static void main(String[] args) {
        System.out.println("=== Executando testes de ItemVenda ===\n");

        testProdutoFisico();
        testServico();
        testProdutoDigital();

        System.out.println("\n=== Todos os testes de ItemVenda passaram! ===");
    }

    private static void testProdutoFisico() {
        System.out.println("Testando ProdutoFisico...");
        
        ProdutoFisico produto = new ProdutoFisico(
            "P001", 
            "Notebook", 
            "Notebook Dell", 
            3500.00, 
            2.5, 
            "35x25x2", 
            10
        );

        assert produto.getId().equals("P001") : "ID incorreto";
        assert produto.getNome().equals("Notebook") : "Nome incorreto";
        assert produto.getPreco() == 3500.00 : "Preço incorreto";
        assert produto.getPeso() == 2.5 : "Peso incorreto";
        assert produto.getDimensoes().equals("35x25x2") : "Dimensões incorretas";
        assert produto.getEstoque() == 10 : "Estoque incorreto";
        
        String info = produto.obterInformacoes();
        assert info.contains("Produto Físico") : "Informações devem indicar tipo de produto";
        assert info.contains("Notebook") : "Informações devem conter nome";
        
        System.out.println("✓ ProdutoFisico passou em todos os testes");
    }

    private static void testServico() {
        System.out.println("Testando Servico...");
        
        Servico servico = new Servico(
            "S001", 
            "Entrega", 
            "Entrega rápida", 
            25.00, 
            120, 
            "entrega"
        );

        assert servico.getId().equals("S001") : "ID incorreto";
        assert servico.getNome().equals("Entrega") : "Nome incorreto";
        assert servico.getPreco() == 25.00 : "Preço incorreto";
        assert servico.getDuracaoEstimada() == 120 : "Duração incorreta";
        assert servico.getTipo().equals("entrega") : "Tipo incorreto";
        
        String info = servico.obterInformacoes();
        assert info.contains("Serviço") : "Informações devem indicar tipo de serviço";
        assert info.contains("Entrega") : "Informações devem conter nome";
        
        System.out.println("✓ Servico passou em todos os testes");
    }

    private static void testProdutoDigital() {
        System.out.println("Testando ProdutoDigital...");
        
        ProdutoDigital produto = new ProdutoDigital(
            "D001", 
            "Voucher", 
            "Vale desconto", 
            90.00, 
            "Digital", 
            "https://exemplo.com/voucher", 
            "31/12/2025"
        );

        assert produto.getId().equals("D001") : "ID incorreto";
        assert produto.getNome().equals("Voucher") : "Nome incorreto";
        assert produto.getPreco() == 90.00 : "Preço incorreto";
        assert produto.getFormatoArquivo().equals("Digital") : "Formato incorreto";
        assert produto.getLinkDownload().equals("https://exemplo.com/voucher") : "Link incorreto";
        assert produto.getDataValidade().equals("31/12/2025") : "Data de validade incorreta";
        
        String info = produto.obterInformacoes();
        assert info.contains("Produto Digital") : "Informações devem indicar tipo de produto";
        assert info.contains("Voucher") : "Informações devem conter nome";
        
        System.out.println("✓ ProdutoDigital passou em todos os testes");
    }
}
