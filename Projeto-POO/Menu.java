import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public interface Handler {
        public void execute();
    }

    public interface PreCondition {
        public boolean validate();
    }

    private static final Scanner scan = new Scanner(System.in);

    private final List<String> opcoes;
    private final List<PreCondition> disponivel;
    private final List<Handler> handlers;

    public Menu(String[] opcoes){

        this.opcoes = Arrays.asList(opcoes);
        this.disponivel = new ArrayList<>();
        this.handlers = new ArrayList<>();

        this.opcoes.forEach(s-> {
            this.disponivel.add(()->true);
            this.handlers.add(()->System.out.println("Opçao não selecionavel"));
        });
    }

    public void run(){
        int op;

        do{
            show();
            op = readOption();
            if (op>0 && !this.disponivel.get(op-1).validate())
                System.out.println("Opcao indisponivel");
            else if( op>0)
                this.handlers.get(op-1).execute();
        } while (op!=0);
    }

    private void show(){

        for( int i=0 ; i<this.opcoes.size() ; i++){
            System.out.print(i+1);
            System.out.print(" - ");
            System.out.println(this.disponivel.get(i).validate()? this.opcoes.get(i):"------");
        }

        System.out.println("0 - Exit");
    }

    private int readOption(){
        return  scan.nextInt();
    }

    public void setHandler(int i, Handler h){
        this.handlers.add(i-1,h);
    }



}