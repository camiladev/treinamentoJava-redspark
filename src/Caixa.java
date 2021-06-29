import java.time.LocalDate;
import java.util.*;

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

    public void imprimir(int qdt, String prod, float valor){
        System.out.println(qdt+"x "+prod+"     -   R$ "+valor);
    }

    public long qtdItem(String nome){
        long quantidade = listaDeVendas.stream()
                .filter(produtoVendido -> produtoVendido.getNome().equals(nome))
                .count();
        return quantidade;
    }

    public void totalizarVenda(){
        float precoTotal = 0f;

        int qtdVendida = 0;
        float valorDescontado = 0f;
        float totalUnit = 0f;


        Map<String, Integer> map = new TreeMap<String, Integer>();

        for(Produto produto : listaDeVendas){

            Integer count = map.get(produto.getNome());

            if(count == null){
                count = 0;
                //conta a quantidade vendida
                qtdVendida = (int) qtdItem(produto.getNome());

                map.put(produto.getNome(),count+1);

                if(consultaDesconto(produto)){
                    valorDescontado = (float) (produto.getPreco() * 0.1);
                    totalUnit = ((produto.getPreco()-valorDescontado) *qtdVendida);
                    String nome = produto.getNome()+" *";

                    imprimir(qtdVendida,nome,totalUnit);
                }else{
                    totalUnit = produto.getPreco()*qtdVendida;
                    imprimir(qtdVendida,produto.getNome(),totalUnit);
                }

            }

            precoTotal = precoTotal + totalUnit; //ou precoTotal += produto.getPreco();
        }


        System.out.println("-----------------------------");
        System.out.println("Total:              R$ "+precoTotal);
        System.out.println("-----------------------------");
        System.out.println("Descontado (*):     R$ "+valorDescontado);
        System.out.println("-----------------------------");

        listaDeVendas.clear();
    }


}
