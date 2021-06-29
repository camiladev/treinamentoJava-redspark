import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Estoque {

    private List<Produto> listaEstoque = new ArrayList<>();


    public void listarProdutosEmEstoque() {
        System.out.println("----> Produtos em Estoque <---- ");

        Map<String, Long> result = listaEstoque.stream().collect(
                Collectors.groupingBy(Produto::getNome, Collectors.counting()));

        for (Map.Entry itemMap : result.entrySet()) {
            System.out.println("Produto: "+itemMap.getKey() + " - Quantidade: "
                    + itemMap.getValue());
        }

//        listaEstoque.stream()
//                .map(item -> item.getNome())
//                .distinct()
//                .forEach(System.out::println);

    }

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

    public void atualizarEstoqueCadastrado(Produto produto){
        listaEstoque.add(produto);
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
