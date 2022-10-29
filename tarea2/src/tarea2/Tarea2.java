package tarea2;

public class Tarea2 {

    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1,500);
        Moneda mmil = new Moneda1000();
        Moneda mcien = new Moneda100();
        Moneda m500 = new  Moneda500();
        CocaCola cc = new CocaCola(1);
        Fanta f = new Fanta(3);
//        Comprador com = new Comprador(mmil, 1, exp) throw PagoIncorrectoException, PagoInsuficienteException, NohayBebidaException;
        Deposito d = new Deposito();
        DepositoVuelto dvuelto = new DepositoVuelto();
        Expendedor exp2 = new Expendedor(3,400);
        
        System.out.println("compra 1-------");
        System.out.println("Precio: " + exp.getPrecioBebida());
        int beb = cc.getSerie();
        if(beb == 1) System.out.println("Coca Cola");
        else if(beb == 2) System.out.println("Sprite");
        else if(beb == 3) System.out.println("Fanta");
        
        System.out.println("Moneda: " + dvuelto.getMoneda());
        System.out.println("vuelto: " + exp.getVuelto());
        
        System.out.println("compra 2-------");
        System.out.println("Precio: " + exp2.getPrecioBebida());
        int beb2 = f.getSerie();
        if(beb2 == 1) System.out.println("Coca Cola");
        else if(beb2 == 2) System.out.println("Sprite");
        else if(beb2 == 3) System.out.println("Fanta");
        DepositoVuelto dvuelto2 = new DepositoVuelto();
        System.out.println("Moneda: " + dvuelto2.getMoneda());
        System.out.println("vuelto: " + exp2.getVuelto());
    }  
}
