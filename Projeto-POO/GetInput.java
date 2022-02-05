import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GetInput {

    private static Scanner scan = new Scanner(System.in);
    private List<String> param;

    public GetInput(String[] params){
        this.param = Arrays.asList(params);
    }

    public String[] getCampos(){
        this.show();
        return scan.nextLine().split(",");
    }

    public String getLine(){
        this.show();
        return scan.nextLine();
    }

    private void show(){
        int i;

        System.out.print("(");
        for( i=0 ; i<param.size()-1 ; i++)
            System.out.print(param.get(i)+",");
        System.out.println(param.get(i)+")");
    }

    public void showJogador(Jogador jogador){
        System.out.println(jogador.toString());
    }

    public void showEquipa(Equipa equipa){
        System.out.println(equipa.toString());
    }

}

