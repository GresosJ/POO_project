import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

//Gerson Henrique de Araujo Junior
//29-03-2021

public abstract class Jogador implements Serializable
{
    private String nome;
    private int nrCamisola;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int impulsao;
    private int cabecear;
    private int remate;
    private int passe;
    private double valorJogador;
    private List<String> historial;

    //--------------------------------------------------------contrutores---------------------------------------------------------
    public Jogador(){
        this.nome = "";
        this.nrCamisola = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.impulsao = 0;
        this.cabecear = 0;
        this.remate = 0;
        this.passe = 0;
        this.valorJogador = 0;
        this.historial = new ArrayList<>();
    }
    
    //Construtor parametrizado
    public Jogador(String nome,int nrCamisola, int velocidade, int resistencia, int destreza, int impulsao, int cabecear, int remate, int passe, double valorJogador, List<String> historial){
        this.nome = nome;
        this.nrCamisola = nrCamisola;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.impulsao = impulsao;
        this.cabecear = cabecear;
        this.remate = remate;
        this.passe = passe;
        this.valorJogador = valorJogador;
        this.historial = historial;
    }
    
    //Construtor de copia
    public Jogador(Jogador umJogador){
        this.nome = umJogador.getNome();
        this.nrCamisola = umJogador.getNrCamisola();
        this.velocidade = umJogador.getVelocidade();
        this.resistencia = umJogador.getResistencia();
        this.destreza = umJogador.getDestreza();
        this.impulsao = umJogador.getImpulsao();
        this.cabecear = umJogador.getCabecear();
        this.remate = umJogador.getRemate();
        this.passe = umJogador.getPasse();
        this.valorJogador = umJogador.getValorJogador();
        this.historial = umJogador.getHistorial();
    }

    //--------------------------------------------------------gets---------------------------------------------------------------
    public String getNome(){
        return this.nome;
    }
    
    public int getNrCamisola(){
        return this.nrCamisola;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public int getResistencia(){
        return this.resistencia;
    }
    
    public int getDestreza(){
        return this.destreza;
    }
    
    public int getImpulsao(){
        return this.impulsao;
    }
    
    public int getCabecear(){
        return this.cabecear;
    }
    
    public int getRemate(){
        return this.remate;
    }
    
    public int getPasse(){
        return this.passe;
    }
    
    public double getValorJogador(){
        return this.valorJogador;
    }
    
    public List<String> getHistorial(){
        return this.historial;
    }


    //--------------------------------------------------------sets---------------------------------------------------------------
    public void setNomeJogador(String nome){
        this.nome = nome;
    }
    
    public void setNumeroJogador(int numeroJogador){
        this.nrCamisola= nrCamisola;
    }
    
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    
    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }
    
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }
    
    public void setImplusao(int implusao){
        this.impulsao = impulsao;
    }
    
    public void setCabecear(int cabecear){
        this.cabecear = cabecear;
    }
    
    public void setRemate(int remate){
        this.remate = remate;
    }
    
    public void setPasse(int passe){
        this.passe = passe;
    } 
        
    public void setValorJogador(double valorJogador){
        this.valorJogador = valorJogador;
    }
    
    public void setHistorial(List<String> historial){
        this.historial = historial;
    }
    
    public void addHistorial(String equipa){
        this.historial.add(equipa);
    }

    //--------------------------------------------------------metodos base---------------------------------------------------------------
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("|---------------------------------------------|\n");
        sb.append("|Nome: "+getNome()+"\n");
        sb.append("|NumeroJogador: "+getNrCamisola()+"\n");
        sb.append("|Velocidade: "+getVelocidade()+"\n");
        sb.append("|Resistencia: "+getResistencia()+"\n");
        sb.append("|Destreza: "+getDestreza()+"\n");
        sb.append("|Impulsao: "+getImpulsao()+"\n");
        sb.append("|Cabecear: "+getCabecear()+"\n");
        sb.append("|Remate: "+getRemate()+"\n");
        sb.append("|Passe: "+getPasse());

        return sb.toString();
    }

    public abstract Jogador clone();
    public abstract double valorJogador();
}
