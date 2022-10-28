package tarea2;

class NoHayBebidaException extends Exception{
    public NoHayBebidaException(String mensaje){
        super(mensaje);
    }
}

class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(String mensaje){
        super(mensaje);
    }
}

class PagoIncorrectoException extends Exception{
    public PagoIncorrectoException(String mensaje){
        super(mensaje);
    }
}

public class Expendedor {
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
    
    public Bebida comprarBebida(Moneda m, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayBebidaException{
        //agregar exception de no recibir una moneda
        if(m == null){
            //return null;
            throw new PagoIncorrectoException("no inserto monedas");
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
        else throw new PagoInsuficienteException("saldo insuficiente para comprar bebida");
        
        if(cual == SPRITE && m.getValor() >= precioBebidas){
            spriteBebida = sprite.getBebida();
            if(cocaColaBebida != null){
                vueltoDeposito= m.getValor()- precioBebidas;
            }
        }
        else throw new PagoInsuficienteException("saldo insuficiente para comprar bebida");
        
        if(cual == FANTA && m.getValor() >= precioBebidas){
            fantaBebida = fanta.getBebida();
            if(cocaColaBebida != null){
                vueltoDeposito= m.getValor()- precioBebidas;
            }
        }
        else throw new PagoInsuficienteException("saldo insuficiente para comprar bebida");
        
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
    
    public int getPrecioBebida(){
        return this.precioBebidas;
    }
    
}