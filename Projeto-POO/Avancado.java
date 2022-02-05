import java.util.ArrayList;
import java.util.List;

/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Avancado extends Jogador
{

    //--------------------------------------------------------contrutores---------------------------------------------------------
    public Avancado(String nome,int nrCamisola ,int velocidade,int resistencia ,int destreza, int impulsao, int cabecear,int remate,int passe, double valorJogador, List<String> historial) {
        super(nome, nrCamisola, velocidade, resistencia, destreza, impulsao, cabecear, remate, passe, valorJogador, historial);
    }



    //--------------------------------------------------------metodos base---------------------------------------------------------
    public Jogador clone(){
        return new Avancado(this.getNome(), this.getNrCamisola(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImpulsao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.getValorJogador(), this.getHistorial());
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
        return 0.8 *((double)this.getImpulsao() + (double)this.getRemate() + (double)this.getCabecear() + (double)this.getResistencia()) + 0.1*(double)this.getVelocidade() + 0.1*((double)this.getDestreza() + (double)this.getPasse());
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        Avancado a = new Avancado(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                0,
                new ArrayList<>());

        a.setValorJogador(a.valorJogador());
        return a;
    }

}
