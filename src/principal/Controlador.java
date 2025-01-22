package principal;

public class Controlador {
    public Controlador(){

    }

    public Jogador criarJogador(int id, String nome){
        return new Jogador(id, nome);
    }
    public Mesa criarMesa(){
        return new Mesa();
    }

    //public finalizarJogo()
}
