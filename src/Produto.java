import java.util.Date;

public class Produto {
    //atributos sempre privados
    private String nome;
    private int codigo;
    private float preco;
    private Date validade;

    //construtor padrão
    public Produto(){}

    //construtor
    public Produto(String nome, int codigo, float preco, Date validade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.validade = validade;
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

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

}
