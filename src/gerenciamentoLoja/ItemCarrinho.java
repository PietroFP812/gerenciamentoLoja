package gerenciamentoLoja;

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;
    private double desconto;

    public ItemCarrinho(Produto produto, int quantidade, double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public double obterCusto() {
        return quantidade * produto.obterValorComDesconto(desconto);
    }
}
