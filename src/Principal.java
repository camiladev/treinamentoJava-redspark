//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.time.LocalDate;
//import java.util.Date;
//
//public class Principal {
//
//    public static void main(String[] args) {
//
//        Produto produtoArroz = new Produto();
//        produtoArroz.setNome("Arroz");
//        produtoArroz.setCodigo(130);
//        produtoArroz.setPreco(12.0f);
//        produtoArroz.setValidade(LocalDate.of(2021,6,29));
//
//        Produto produtoBolacha = new Produto("Bolacha", 430, 3.20f, LocalDate.of(2021,7,14));
//
//        //criar estoque
//        Estoque estoque = new Estoque();
//        estoque.acrescentarProduto(produtoArroz);
//        estoque.acrescentarProduto(produtoArroz);
//
//        estoque.acrescentarProduto(produtoBolacha);
//        estoque.acrescentarProduto(produtoBolacha);
//
//        int totalEstoque = estoque.calcularTotal(); //exibir a quantidade de produtos do estoque
//        System.out.println("Quantidade de produtos em estoque: "+totalEstoque);
//
//
//        Caixa caixa = new Caixa();
//
////        caixa.venderProduto(produtoArroz,1, estoque);
////        caixa.venderProduto(produtoBolacha,1, estoque);
////
////        caixa.venderProduto(produtoArroz,1, estoque);
////        caixa.venderProduto(produtoArroz,1, estoque);
////        caixa.venderProduto(produtoBolacha,1, estoque);
//
//
//        caixa.totalizarVenda();
//
//        totalEstoque = estoque.calcularTotal(); //exibir a quantidade de produtos do estoque
//        System.out.println("Quantidade de produtos em estoque atualizado: "+totalEstoque);
//
//
//
//    }
//}
