import java.time.LocalDate;
import java.util.*;

public class Estoque {

    private List<Produto> listaEstoque = new ArrayList<>();

    //ações
    public int calcularTotal(){
        //somar a quantidade de produtos tem na lista
        return listaEstoque.size();
    }

    public void acrescentarProduto(Produto produto){
        if (validarProdutoVencido(produto.getValidade())){
            System.out.println("Produto vencido ou vence em 15 dias!");
        }else {
            listaEstoque.add(produto);
        }
    }

    private boolean validarProdutoVencido(LocalDate validade) {
        LocalDate dataLimite = LocalDate.now().plusDays(16);
        return validade.isBefore(dataLimite);
    }

    public int contarItems(Produto item){
        int quantidade = 0;
        for (Produto nome : listaEstoque) {
            if(nome == item) {
                quantidade += 1;
            }
        }
        return quantidade;
    }

    public Produto retirarProduto(int codigo){
        Optional<Produto> produtoOptional = listaEstoque.stream()
                .filter(produtoEstoque -> produtoEstoque.getCodigo() == codigo)
                .findFirst();

        if(produtoOptional.isPresent()){
            //retirar o produto do estoque
            listaEstoque.remove(produtoOptional.get());
            return produtoOptional.get();
        }else {
            System.out.println("Quantidade em estoque insuficiente ou produto não encontrado.");
            return null;
        }



    }
}
