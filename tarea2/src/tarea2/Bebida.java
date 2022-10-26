package tarea2;

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
