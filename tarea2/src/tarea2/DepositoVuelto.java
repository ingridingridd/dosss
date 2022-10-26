package tarea2;

import java.util.ArrayList;

public class DepositoVuelto {
    private ArrayList<Moneda> lista;
    
    public DepositoVuelto(){
        lista = new ArrayList<Moneda>();
    }
    
    public void addMoneda(Moneda moneda){
        lista.add(moneda);
    }
    
    public Moneda getMoneda(){
        if(lista.size() == 0){
            return null;
        }
        return lista.remove(0);
    }
}
