import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Caixa {

    //propriedades
    private List<Produto> listaDeVendas = new ArrayList<>();

    //ações
    public void venderProduto(int codigo, Estoque estoque){
        //retirar do estoque
        Produto produtoRetirado = estoque.retirarProduto(codigo);

        //acrescenta na lista
        if (produtoRetirado != null) {
            venderProdutoNaoVencido(produtoRetirado);
        }
    }

    private void venderProdutoNaoVencido(Produto produtoRetirado) {
        if(produtoRetirado.getValidade().isBefore(LocalDate.now())){
            System.out.println("Produto vencido");
        }else{
            listaDeVendas.add(produtoRetirado);
        }
    }

    private boolean consultaDesconto(Produto produtoRetirado) {
        return produtoRetirado.getValidade().isBefore(LocalDate.now().plusDays(15));
    }

    public void imprimir(int qdt, String prod, double valor){
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
                double totalUnit = 0;
                if(consultaDesconto(produto)){
                    totalUnit = (produto.getPreco()-(produto.getPreco() * 0.1)) *qtdVendida;
                }else{
                    totalUnit = produto.getPreco()*qtdVendida;
                }
                imprimir(qtdVendida,produto.getNome(),totalUnit);
            }

            precoTotal = precoTotal + produto.getPreco(); //ou precoTotal += produto.getPreco();
        }


        System.out.println("-----------------------");
        System.out.println("Total:        R$ "+precoTotal);
        System.out.println("-----------------------");
    }


}
