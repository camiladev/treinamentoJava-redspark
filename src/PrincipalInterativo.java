import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalInterativo {

    private static void cadastraProduto(File arq){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do produto: ");
        String nome = scanner.next();

        System.out.println("Digite o código do produto: ");
        String cod = scanner.next();

        System.out.println("Digite o preço do produto: ");
        String preco = scanner.next();

        System.out.println("Digite a data de validade do produto: ");
        String validade = scanner.next();

    }

    public void lerProdutosEstoque(File arq){
        try {
            FileReader fileReader = new FileReader(arq);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha = "";

            List estoqueLista = new ArrayList();

            while ((linha = bufferedReader.readLine()) != null){
                if(linha != null && !linha.isEmpty()){
                    estoqueLista.add(linha);
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

    public void salvaEstoque(){
        File dir = new File("C:\\Users\\camila.bittencourt\\IdeaProjects\\TreinamentoRedSpark\\src\\dados");
        File arq = new File(dir, "estoque.txt");
        try {
//            arq.createNewFile();
            FileWriter fileWriter = new FileWriter(arq, true);

            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Teste escrevendoo");

            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
//        for(File file : files.listFiles()){
//            System.out.println(file);
//        }

    }

    public static void main(String[] args) {
        File dir = new File("C:\\Users\\camila.bittencourt\\IdeaProjects\\TreinamentoRedSpark\\src\\dados");
        File arq = new File(dir, "estoque.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a opção desejada: ");
        System.out.println("1 - Cadastrar novo produto ");
        String opcao = scanner.next();

        switch (opcao){
            case "1": cadastraProduto(arq);
            break;

            default:
                System.out.println("Digite uma opção valida !!");
        }
    }


}
