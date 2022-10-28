package tarea2;

public class Comprador {
    private Expendedor exp;
    private int vuelto;
    private String saborBebida;
    
    public Comprador(Moneda m, int cualBebida, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        this.exp = exp;
        
        if(exp.comprarBebida(m, cualBebida) != null){
            if(cualBebida == 1){
                saborBebida = "colacola";
            }
            else if(cualBebida == 2){
                saborBebida = "sprite";
            }
            else if(cualBebida == 3){
                saborBebida = "fanta";
            }
        }
        else throw new NoHayBebidaException("No quedan bebidas");
        
        Moneda moneda = null;
        moneda = exp.getVuelto();
        while(moneda != null){
            vuelto = vuelto + moneda.getValor();
            moneda = exp.getVuelto();
        }
    }
    
    public int cuantoVuelto(){
        return vuelto;
    }
    public String queBebiste(){
        return saborBebida;
    }
}