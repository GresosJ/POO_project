import java.util.ArrayList;
import java.util.List;

public class Guarda_Redes extends Jogador
{
    private int elasticidade; 
    
    //--------------------------------------------------------contrutores---------------------------------------------------------
    public Guarda_Redes(){
        super();
        this.elasticidade = 0;
    }

    public Guarda_Redes(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int elasticidade, double valorJogador,List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador,historial);
        this.elasticidade = elasticidade;
    }

    //--------------------------------------------------------gets---------------------------------------------------------
    public int getElasticidade(){
        return this.elasticidade;
    }

    //--------------------------------------------------------metodos base---------------------------------------------------------

    public Jogador clone(){
        return new Guarda_Redes(this.getNome(), this.getNrCamisola(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImpulsao(), this.getCabecear(), this.getRemate(), this.getPasse(),this.getElasticidade(), this.getValorJogador(), this.getHistorial());
    }

    public String toString(){
        String s = super.toString();
        StringBuffer sb = new StringBuffer();

        sb.append(s);
        sb.append("\n|Elasticidade: "+getElasticidade());
        sb.append("\n|Valor Jogador: "+super.getValorJogador()+"\n");
        sb.append("|Historico: "+super.getHistorial());
        sb.append("\n|---------------------------------------------|\n");

        return sb.toString();
    }

    //--------------------------------------------------------metodos---------------------------------------------------------

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.6* (double)this.elasticidade + 0.1*(double)this.getRemate() + 0.3*(double)this.getDestreza();
    }

    //Leitura
    public static Jogador parse(String input){
        String[] campos = input.split(",");

        Guarda_Redes gr = new Guarda_Redes(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                0,
                new ArrayList<>());

        gr.setValorJogador(gr.valorJogador());
        return gr;
    }


}
