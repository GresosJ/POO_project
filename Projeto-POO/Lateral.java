import java.util.ArrayList;
import java.util.List;

/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Lateral extends Jogador
{
    private int cruzamento;


    //--------------------------------------------------------contrutores---------------------------------------------------------
    //Construtor por omissão
    public Lateral(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int impulsao, int cabecear,int remate,int passe, int cruzamento, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, impulsao, cabecear, remate, passe, valorJogador,historial);
        this.cruzamento = cruzamento;
    }


    //--------------------------------------------------------gets---------------------------------------------------------------
    public int getCruzamento(){
        return this.cruzamento;
    }

    //--------------------------------------------------------metodos base---------------------------------------------------------

    public String toString(){
        String s = super.toString();
        StringBuffer sb = new StringBuffer();

        sb.append(s);
        sb.append("\n|Cruzamento: "+getCruzamento());
        sb.append("\n|Valor Jogador: "+super.getValorJogador()+"\n");
        sb.append("|Historico: "+super.getHistorial());
        sb.append("\n|---------------------------------------------|\n");

        return sb.toString();
    }

    public Jogador clone(){
        return new Lateral(this.getNome(), this.getNrCamisola(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImpulsao(), this.getCabecear(), this.getRemate(), this.getPasse(),this.getCruzamento(), this.getValorJogador(), this.getHistorial());
    }


    //--------------------------------------------------------metodos---------------------------------------------------------
    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.7*((double)this.getVelocidade() + (double) this.getResistencia() + (double) this.getCruzamento()) + 0.2*((double) this.getCabecear() + (double) this.getRemate() + (double)this.getImpulsao()) + 0.1*((double) this.getDestreza() + (double) this.getPasse());
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        Lateral l = new Lateral(campos[0], Integer.parseInt(campos[1]),
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

        l.setValorJogador(l.valorJogador());
        return l;
    }

}
