package Auxiliar;
import principal. *;

import java.util.ArrayList;
import java.util.List;

public class Inicializador {

    public Inicializador(){

    }
    public void inicializaItens(Inventario inv){
        Item temp = new Item(1, "Destilado Anão","Destilado Anão", true, Raridade.Comum,0);
        inv.addItem(temp);
        temp = new Item(2, "Cérebro de Afogado", "Cérebro de Afogado", true, Raridade.Comum,0);
        inv.addItem(temp);
        temp = new Item(3, "Andorinha", "Andorinha", false, Raridade.Comum, 1);

        inv.addItem(temp);

    }

    public void inicializaReceitas(Inventario inv){
        Receita temp = new Receita(1, 3, 1, 2);
        Item temp2 = inv.getItem(3);
        temp.setProduto(temp2);
        inv.adicionarReceita(temp);

    }
}