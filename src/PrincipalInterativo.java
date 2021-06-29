import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrincipalInterativo {

    private static void cadastraProduto(File arq, Scanner scanner, Estoque estoque){
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.next();

        System.out.println("Digite o código do produto: ");
        int cod = scanner.nextInt();

        System.out.println("Digite o preço do produto: ");
        float preco = scanner.nextFloat();

        System.out.println("Digite a data de validade do produto: dd/mm/aaaa ");
        String validadeString = scanner.next();

        String[] vencimentoArray = validadeString.split("/");
        LocalDate dataValidade = LocalDate.of(Integer.parseInt(vencimentoArray[2]),Integer.parseInt(vencimentoArray[1]), Integer.parseInt(vencimentoArray[0]));

        Produto produto = new Produto(nome, cod, preco, dataValidade);
        estoque.acrescentarProduto(produto);
        salvaEstoque(arq,produto);
    }

    private static void lerProdutosEstoque(File arq, Estoque estoque){
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = null;

            while ((linha = bufferedReader.readLine()) != null){
                if(linha != null && !linha.isEmpty()){
                    String[] dadosArray = linha.split(";");

                    String[] dataValidadeArray = dadosArray[3].split("-");
                    LocalDate dataValidade = LocalDate.of(Integer.parseInt(dataValidadeArray[0]),Integer.parseInt(dataValidadeArray[1]),Integer.parseInt(dataValidadeArray[2]));

                    Produto produto = new Produto(dadosArray[1], Integer.parseInt(dadosArray[0]), Float.parseFloat(dadosArray[2]), dataValidade);
                    estoque.atualizarEstoqueCadastrado(produto);
                }
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void salvaEstoque(File arq, Produto produto){

        try {
//            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(produto.getCodigo()+";"+produto.getNome()+";"+produto.getPreco()+";"+produto.getValidade());
            printWriter.println();

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\camila.bittencourt\\IdeaProjects\\TreinamentoRedSpark\\src\\dados");
        File arq = new File(dir, "estoque.txt");

        Estoque estoque = new Estoque();
        Caixa caixa = new Caixa();

        lerProdutosEstoque(arq, estoque);

        int totalEstoque = estoque.calcularTotal();
        System.out.println("Quantidade de produtos em estoque: "+totalEstoque);

        Scanner scanner = new Scanner(System.in);

        int opcao = 9;

        while (opcao != 0){
            System.out.println("Digite a opção desejada: ");


            System.out.println("1 - Cadastrar novo produto e adicionar no estoque ");
            System.out.println("2 - Listar produtos em estoque ");
            System.out.println("3 - Iniciar venda ");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1: cadastraProduto(arq,scanner,estoque);
                    break;
                case 2: estoque.listarProdutosEmEstoque();
                    break;
                case 3: iniciarVenda(estoque, caixa,scanner);
                    break;
            }
        }
    }



    private static void iniciarVenda(Estoque estoque, Caixa caixa, Scanner scanner) {

        int opcao = 5;
        while (opcao != 0){
            System.out.println("Informe o código do produto:");
            int cod = scanner.nextInt();
            caixa.venderProduto(cod,estoque );

            System.out.println("1 - Próximo produto ");
            System.out.println("0 - Finalizar venda ");
            opcao = scanner.nextInt();
        }

        //finalizar venda
        caixa.totalizarVenda();

        //exibir a quantidade de produtos do estoque
        int totalEstoque = estoque.calcularTotal();
        System.out.println("Quantidade de produtos em estoque atualizado: "+totalEstoque);

    }


}
