public class Post {

    int id;
    private String text;
    private int quantidadeCurtidas;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void novoPost(String corpo){
        setText(corpo);
    }
}
