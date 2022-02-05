import java.util.ArrayList;
import java.util.List;

/**
 * Escreva a descrição da classe Medio aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Medio extends Jogador
{
    private int recuperaçãoDeBolas;

    //--------------------------------------------------------contrutores---------------------------------------------------------
    public Medio(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int impulsao, int cabecear,int remate,int passe, int recuperaçãoDeBolas, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, impulsao, cabecear, remate, passe, valorJogador, historial);
        this.recuperaçãoDeBolas = recuperaçãoDeBolas;
    }

    //--------------------------------------------------------gets---------------------------------------------------------------
    public int getRecuperaçãoDeBolas(){
        return this.recuperaçãoDeBolas;
    }

    //--------------------------------------------------------metodos base---------------------------------------------------------
    public String toString(){
        String s = super.toString();
        StringBuffer sb = new StringBuffer();

        sb.append(s);
        sb.append("\n|Recuperacao de bolas: "+getRecuperaçãoDeBolas());
        sb.append("\n|Valor Jogador: "+super.getValorJogador()+"\n");
        sb.append("|Historico: "+super.getHistorial());
        sb.append("\n|---------------------------------------------|\n");

        return sb.toString();
    }
    
    public Jogador clone(){
        return new Medio(this.getNome(), this.getNrCamisola(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImpulsao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.getRecuperaçãoDeBolas(), this.getValorJogador(), this.getHistorial());
    }

    //--------------------------------------------------------metodos---------------------------------------------------------

    ////////////////////////falta ter em consideraçao a recuperação de bolas/////////////////////////////////////////////
    public double valorJogador(){
        return 0.7*((double)this.getPasse() + (double)this.getDestreza() + (double)this.getVelocidade()) + 0.3*((double)this.getResistencia() + (double)this.getCabecear() + (double)this.getRemate()+ (double)this.getImpulsao());
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        Medio m = new Medio(campos[0], Integer.parseInt(campos[1]),
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

        m.setValorJogador(m.valorJogador());
        return m;
    }

}
