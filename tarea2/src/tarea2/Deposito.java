package tarea2;

import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> lista;
    
    public Deposito(){
        lista = new ArrayList<Bebida>();
    }
    
    public void addBebida(Bebida bebida){
        lista.add(bebida);
    }
    
    public Bebida getBebida(){
        if(lista.size() == 0){
            return null;
        }
        return lista.remove(0);
    }
}
