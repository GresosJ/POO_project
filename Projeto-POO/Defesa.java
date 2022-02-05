import java.util.ArrayList;
import java.util.List;

/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Defesa extends Jogador
{

    //--------------------------------------------------------contrutores---------------------------------------------------------
    public Defesa(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int impulsao, int cabecear,int remate,int passe, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, impulsao, cabecear, remate, passe, valorJogador, historial);
    }


    //--------------------------------------------------------metodos base---------------------------------------------------------
    public Jogador clone(){
        return new Defesa(this.getNome(), this.getNrCamisola(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImpulsao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.getValorJogador(), this.getHistorial());
    }

    public String toString(){
        String s = super.toString();
        StringBuffer sb = new StringBuffer();

        sb.append(s);
        sb.append("\n|Valor Jogador: "+super.getValorJogador()+"\n");
        sb.append("|Historico: "+super.getHistorial());
        sb.append("\n|---------------------------------------------|\n");

        return sb.toString();
    }

    //--------------------------------------------------------metodos---------------------------------------------------------

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.5*(double)this.getDestreza() + 0.3*(double)this.getPasse() + 0.2*((double)this.getVelocidade() + (double)this.getResistencia() + (double)this.getImpulsao() + (double)this.getRemate() + (double)this.getCabecear());
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        Defesa d = new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                0,
                new ArrayList<>());

        d.setValorJogador(d.valorJogador());
        return d;
    }


    
}
