import javax.management.modelmbean.ModelMBean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Controller extends Observable implements Observer {
    private Model model;

    public Controller(Model model ){
        this.model = model;
    }

    public void adicionarGuardaRedes(String campos){
        model.adicionarGuardaRedes(campos);
    }

    public void adicionarDefesa(String campos){
        model.adicionarDefesa(campos);
    }

    public void adicionarMedio(String campos){
        model.adicionarMedio(campos);
    }

    public void adicionarAvancado(String campos){
        model.adicionarAvancado(campos);
    }

    public void adicionarLateral(String campos){
        model.adicionarLateral(campos);
    }

    public void removeJogadorDeEquipa(Integer nr, String equipa){model.removeJogadorDeEquipa(nr,equipa);}

    public Jogador getJogador(String nome){
        return model.getJogador(nome);
    }

    public void addEquipa(String equipaNome){
        model.addEquipa(equipaNome);
    }

    public Equipa getEquipa(String nome){
        return model.getEquipa(nome);
    }

    public void addJogadorToTeam(String[] campos){
        model.addJogadorToTeam(campos[0],campos[1]);
    }

    public void switchJogador(String[] campos){
        model.switchJogador(campos[0],campos[1],campos[2]);
    }

    public void criarJogo(String[] campos){

        List<Integer> titularesC = new ArrayList<>();
        Map<Integer,Integer> substituicoesC = new HashMap<>();

        for(int i=1 ; i<3 ; i++) // 12
            titularesC.add(Integer.parseInt(campos[i]));

        String[] substitutosC = campos[3].split("->");
        substituicoesC.put(Integer.parseInt(substitutosC[0]),Integer.parseInt(substitutosC[1]));

        List<Integer> titularesF = new ArrayList<>();
        Map<Integer,Integer> substituicoesF = new HashMap<>();

        for(int i=5 ; i<7 ; i++)  //13 e 24
            titularesF.add(Integer.parseInt(campos[i]));


        String[] substitutosF = campos[7].split("->");
        substituicoesF.put(Integer.parseInt(substitutosF[0]),Integer.parseInt(substitutosF[1]));

        model.criarJogo(campos[0],titularesC,substituicoesC,campos[4],titularesF,substituicoesF);
    }

    public void load(String ficheiro) throws LinhaIncorretaException {
        model.parse(ficheiro);
    }

    public void saveModel(String file) throws IOException {
        model.writeModel(file);
    }

    public void readModel(String Ficheiro) throws IOException, ClassNotFoundException {
        model.readModel(Ficheiro);
    }


    ///-------------------------------------------------Observer--------------------------------------------------------
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
