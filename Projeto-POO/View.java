import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private final Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }

    public void runView() {
        Menu menu = new Menu( new String[] {"Criar Jogador","Criar Equipa","Ver Jogador","Ver equipa","Adicionar jogador a equipa","Remover Jogador de Equipa","Trocar Jogador","Jogar","Carregar ficheiro de Texto","Guardar ficheiro de Objetos","Ler ficheiro de Objetos"});

        menu.setHandler(1, this::criarJogador);
        menu.setHandler(2, this::criarEquipa);
        menu.setHandler(3, this::verJogador);
        menu.setHandler(4, this::verEquipa);
        menu.setHandler(5, this::adicionarJogadorToTeam);
        menu.setHandler(6, this::removerjogador);
        menu.setHandler(7, this::trocarJogador);
        menu.setHandler(8, this::jogar);
        menu.setHandler(9, this::readFicheiroTexto);
        menu.setHandler(10,this::saveModel);
        menu.setHandler(11,this::readModel);

        menu.run();
    }

    public void criarJogador(){
        Menu menu = new Menu( new String[] {"Guarda-Redes","Defesa","Medio","Avancado","Lateral"});
        menu.setHandler(1, this::adicionarGuardaRedes);
        menu.setHandler(2, this::adicionarDefesa);
        menu.setHandler(3, this::adicionarMedio);
        menu.setHandler(4, this::adicionarAvancado);
        menu.setHandler(5, this::adicionarLateral);
        menu.run();
    }

    public void adicionarGuardaRedes(){
        GetInput guardaRedes = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Elasticidade"});
        String campos = guardaRedes.getLine();
        controller.adicionarGuardaRedes(campos);
    }

    public void adicionarDefesa(){
        GetInput defesa = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe",});
        String campos = defesa.getLine();
        controller.adicionarDefesa(campos);
    }

    public void adicionarMedio(){
        GetInput medio = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Recuperacao de Bolas"});
        String campos = medio.getLine();
        controller.adicionarMedio(campos);
    }

    public void adicionarAvancado(){
        GetInput avancado = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe"});
        String campos = avancado.getLine();
        controller.adicionarAvancado(campos);
    }

    public void adicionarLateral(){
        GetInput lateral = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Cruzamento"});
        String campos = lateral.getLine();
        controller.adicionarLateral(campos);
    }

    public void removerjogador(){
        GetInput jog = new GetInput(new String[] {"Número","Nome da Equipa"});
        String[] campos = jog.getCampos();
        controller.removeJogadorDeEquipa(Integer.parseInt(campos[0]),campos[1]);

    }

    private void verJogador(){
        GetInput jogador = new GetInput( new String[] {"Nome"});
        String[] campos = jogador.getCampos();

        Jogador j = controller.getJogador(campos[0]);
        jogador.showJogador(j);
    }

    public void criarEquipa(){
        GetInput equipa = new GetInput(new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();
        controller.addEquipa(campos[0]);
    }

    public void verEquipa(){
        GetInput equipa = new GetInput( new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();

        Equipa e = controller.getEquipa(campos[0]);
        equipa.showEquipa(e);

    }

    public void adicionarJogadorToTeam(){
        GetInput jog_equipa = new GetInput(new String[] {"Jogador","Equipa"});
        String[] campos = jog_equipa.getCampos();

        controller.addJogadorToTeam(campos);
    }

    public void trocarJogador(){
        GetInput i = new GetInput(new String[] {"Nr do Jogador","Equipa Inicial","Equipa Final"});
        String[] campos = i.getCampos();

        controller.switchJogador(campos);
    }

    public void jogar(){
        GetInput jogo = new GetInput(new String[] {"Equipa casa","j1","j2","j?->j?","Equipa fora","j1","j2","j?->j?"});
        String[] campos = jogo.getCampos();

        controller.criarJogo(campos);
    }

    public void readFicheiroTexto() {

        GetInput nome = new GetInput(new String[] {"Nome do ficheiro"});
        String file = nome.getLine();

        try {
            controller.load(file);
        }catch(LinhaIncorretaException l){
            System.out.println("erro");
        }
    }

    public void saveModel(){

        GetInput nome = new GetInput(new String[] {"Nome do ficheiro"});
        String file = nome.getLine();

        try{ controller.saveModel(file);}
        catch (IOException e) { System.out.println("erro a salvar");}
    }

    public void readModel(){

        GetInput nome = new GetInput(new String[] {"Nome do ficheiro"});
        String file = nome.getLine();

        try{ controller.readModel(file); }
        catch (IOException e) { System.out.println("erro na escrita");}
        catch (ClassNotFoundException e) { System.out.println("erro nas classes");}
    }

    //-----------------------------------------------Observer-----------------------------------------------------------

    public void update(Observable o, Object arg) {
        String evento = (String) arg;
        System.out.println(evento);
    }
}
