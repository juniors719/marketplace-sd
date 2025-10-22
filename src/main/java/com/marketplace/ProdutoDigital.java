package com.marketplace;

/**
 * Representa um produto digital no marketplace (ex: voucher, ingresso).
 */
public class ProdutoDigital extends ItemVenda {
    private String formatoArquivo; // ex: "PDF", "PNG", "Digital"
    private String linkDownload;
    private String dataValidade;

    public ProdutoDigital(String id, String nome, String descricao, double preco, 
                         String formatoArquivo, String linkDownload, String dataValidade) {
        super(id, nome, descricao, preco);
        this.formatoArquivo = formatoArquivo;
        this.linkDownload = linkDownload;
        this.dataValidade = dataValidade;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String obterInformacoes() {
        return String.format("Produto Digital - %s | Preço: R$ %.2f | Formato: %s | Validade: %s",
                getNome(), getPreco(), formatoArquivo, dataValidade);
    }
}
