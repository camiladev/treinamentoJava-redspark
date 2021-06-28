import java.time.LocalDate;
import java.util.Date;

public class Produto {
    //atributos sempre privados
    private String nome;
    private int codigo;
    private float preco;
    private LocalDate validade;

    //construtor padrão
    public Produto(){}

    //construtor
    public Produto(String nome, int codigo, float preco, LocalDate validade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.validade = validade;
    }


    public boolean validaProdutoVencido(LocalDate dataValidade){
        LocalDate dataLimite = LocalDate.now().plusDays(16);

        return dataValidade.isBefore(dataLimite);

    }

    // getters e setters (metodos especiais)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public float getPreco(){
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
            this.validade = validade;
    }

}
