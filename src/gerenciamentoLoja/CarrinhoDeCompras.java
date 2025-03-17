package gerenciamentoLoja;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<ItemCarrinho> itens = new ArrayList<>();
    private Cliente cliente;

    public CarrinhoDeCompras(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean adicionarProduto(Produto produto, int quantidade, double desconto) {
        return itens.add(new ItemCarrinho(produto, quantidade, desconto));
    }

    public double obterValorTotal() {
        return itens.stream().mapToDouble(ItemCarrinho::obterCusto).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrinho de " + cliente.getNome() + "\n");
        for (ItemCarrinho item : itens) {
            sb.append("Produto: ").append(item.obterCusto()).append("\n");
        }
        sb.append("Total: ").append(obterValorTotal());
        return sb.toString();
    }
}