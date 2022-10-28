package tarea2;

public class Tarea2 {

    public static void main(String[] args) {
        Expendedor e = new Expendedor(1,500);
        Moneda mmil = new Moneda1000();
        Moneda mcien = new Moneda100();
        Moneda m500 = new  Moneda500();
        CocaCola cc = new CocaCola(1);
        Fanta f = new Fanta(3);
        Comprador com = new Comprador(mmil, 1, e);
        Deposito d = new Deposito();
        DepositoVuelto dvuelto = new DepositoVuelto();
        
        
        System.out.println("Precio: " + e.getPrecioBebida());
        int beb = cc.getSerie();
        if(beb == 1) System.out.println("Coca Cola");
        else if(beb == 2) System.out.println("Sprite");
        else if(beb == 3) System.out.println("Fanta");
        
        System.out.println("Moneda: " + dvuelto.getMoneda());
        System.out.println("vuelto: " + e.getVuelto());
    }  
}
