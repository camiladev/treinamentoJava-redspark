import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Caixa {

    //propriedades
    private List<Produto> listaDeVendas = new ArrayList<>();

    //ações
    public void venderProduto(Produto produto, int qtd, Estoque estoque){
        //logica
        //retirar do estoque
        estoque.retirarProduto(produto, qtd);

        //acrescenta na lista
        for (int indice = 0; indice < qtd; indice++) {
            listaDeVendas.add(produto);
        }
    }

    public void imprimir(int qdt, String prod, float valor){
        System.out.println(qdt+"x "+prod+"   -   R$ "+valor);


    }

    public int qtdItem(String nome){
        int qtd = 0;
        for (Produto prod : listaDeVendas) {

            if(nome == prod.getNome()) {
                qtd += 1;
            }

        }
        return qtd;
    }

    public void totalizarVenda(){
        float precoTotal = 0f;

        int qtdVendida = 0;
        Map<String, Integer> map = new TreeMap<String, Integer>();

        for(Produto produto : listaDeVendas){

            Integer count = map.get(produto.getNome());
            if(count == null){
                count = 0;
                qtdVendida = qtdItem(produto.getNome());
                map.put(produto.getNome(),count+1);
                float totalUnit = produto.getPreco()*qtdVendida;
                imprimir(qtdVendida,produto.getNome(),totalUnit);
            }

            precoTotal = precoTotal + produto.getPreco(); //ou precoTotal += produto.getPreco();
        }



        System.out.println("-------------------");
        System.out.println("Total:        R$ "+precoTotal);
    }


}
