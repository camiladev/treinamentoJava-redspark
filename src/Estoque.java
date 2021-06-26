import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Estoque {

    private List<Produto> listaEstoque = new ArrayList<>();

    //ações
    public int calcularTotal(){
        //somar a quantidade de produtos tem na lista

        return listaEstoque.size();
    }

    public void acrescentarProduto(Produto produto){
        //acrescentar Produto no estoque
        listaEstoque.add(produto);
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

    public void retirarProduto(Produto produto, int qtd){
        int quantidade = contarItems(produto);

        if(qtd <= quantidade){
            //retirar o produto do estoque
            for (int i = 0; i < qtd; i++) {
                listaEstoque.remove(produto);
            }
        }else {
            System.out.println(produto.getNome()+" indisponivel");
        }



    }
}
