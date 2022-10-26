package tarea2;

import java.util.ArrayList;

class Expendedor{
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public static final int FANTA = 3;
    private Deposito coca;
    private Deposito sprite;
    private Deposito fanta;
    private DepositoVuelto vuelto;
    private int precioBebidas;
    
    public Expendedor(int numBebidas, int precioBebidas){
        this.precioBebidas = precioBebidas;
        vuelto = new DepositoVuelto();
        coca = new Deposito();
        sprite = new Deposito();
        fanta = new Deposito();
        int serieCocaCola = 100;
        int serieSprite = 200;
        int serieFanta = 300;
        for(int i=0; i<numBebidas; i++){
            coca.addBebida(new CocaCola(serieCocaCola + i));
            sprite.addBebida(new Sprite(serieSprite + i));
            fanta.addBebida(new Fanta(serieFanta + i));
        }
    }
    
    public Bebida comprarBebida(Moneda m, int cual){
        if(m == null){
            return null;
        }
        int vueltoDeposito = m.getValor();
        Bebida cocaColaBebida = null;
        Bebida spriteBebida = null;
        Bebida fantaBebida = null;
        
        if(cual == COCA && m.getValor() >= precioBebidas){
            cocaColaBebida = coca.getBebida();
            if(cocaColaBebida != null){
                vueltoDeposito= m.getValor()- precioBebidas;
            }
        }
        
        if(cual == SPRITE && m.getValor() >= precioBebidas){
            spriteBebida = sprite.getBebida();
            if(cocaColaBebida != null){
                vueltoDeposito= m.getValor()- precioBebidas;
            }
            
        }
        
        if(cual == FANTA && m.getValor() >= precioBebidas){
            fantaBebida = fanta.getBebida();
            if(cocaColaBebida != null){
                vueltoDeposito= m.getValor()- precioBebidas;
            }
        }
        
        while(vueltoDeposito > 0){
            vuelto.addMoneda(new Moneda100());
            vueltoDeposito = vueltoDeposito - 100;
        }
        
        if(cual == COCA){
            return cocaColaBebida;
        }
        else if(cual == SPRITE){
            return spriteBebida;
        }
        else if(cual == FANTA){
            return fantaBebida;
        }
        else{
            return null;
        }
    }
    
    public Moneda getVuelto(){
        return vuelto.getMoneda();
    }
    
}

class Deposito{
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

abstract class Moneda{
    public Moneda(){
        
    }
    
    public Moneda getSerie(){
        return this.getSerie();
    }
    public abstract int getValor();
}

class Moneda1000 extends Moneda{
    public Moneda1000(){
        super();
    }
    
    @Override
    public int getValor(){
        return 1000;
    }
}

class Moneda500 extends Moneda{
    public Moneda500(){
        super();
    }
    @Override
    public int getValor(){
        return 500;
    }
}

class Moneda100 extends Moneda{
    public Moneda100(){
        super();
    }
    
    @Override
    public int getValor(){
        return 100;
    }
}

class DepositoVuelto{
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

class Comprador{
    private Expendedor exp;
    private int vuelto;
    private String saborBebida;
    
    public Comprador(Moneda m, int cualBebida, Expendedor exp){
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
abstract class Bebida{
    private int serie; //codigo bebida
    
    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return this.serie;
    }
    public abstract String beber();
}

class Fanta extends Bebida{
    public Fanta(int i){
        super(i);
    }
    public String beber(){
        return "Fanta";
    }
}
class Sprite extends Bebida{
    public Sprite(int i){
        super(i);
    }
    public String beber(){
        return "Sprite";
    }
}
class CocaCola extends Bebida{
    public CocaCola(int i){
        super(i);
    }
    public String beber(){
        return "Cocacola";
    }
}


public class Tarea2 {

    public static void main(String[] args) {
        
    }
    
}
