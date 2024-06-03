import java.util.Scanner;
import java.util.Random;
public class Ludo {
    public static int Inicio(){
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;
        System.out.println("1- Iniciar");
        System.out.println("0- Sair");
        opcao = scanner.nextInt();
        return opcao;
    }
    public static int lancarDado(){
        Scanner scanner = new Scanner(System.in);
        int dado = -1;
        System.out.println("1- Lançar dado");
        dado = scanner.nextInt();
        return dado;
    }
    public static int Dado (){
        Random random = new Random();
        int rand = random.nextInt(6) + 1;
        return rand;
    }
    public static void main(String[] args) {
        int jogador = 1;
        int p1 = 0;
        int p2= 0;
        int[] sorte = {2, 4, 6, 7, 13, 14, 16, 17, 19, 26, 30};
        int[] reves = {1, 3, 5, 9, 12, 15, 20, 23, 25, 31};
        int opcao = Inicio();
        if(opcao == 1){
            while(p1 < 32 || p2 < 32){
                if(jogador % 2 != 0){
                    int dado = lancarDado();
                    if(dado == 1){
                        int rand = Dado();
                        System.out.println("Tirou " + rand);
                        p1 += rand;
                        for (int house : sorte) {
                            if(house == p1){
                                System.out.println("Kit te cura: +2 Casas");
                                p1 += 2;
                                break;
                            }
                        }
                        for (int house : reves) {
                            if(house == p1){
                                System.out.println("Charlie te prende e Amber te queima: -2 Casas");
                                p1 -= 2;
                                break;
                            }
                        }
                        System.out.println("Posição do Igor: " + p1);
                        jogador++;
                        System.out.println("Vez de Marco");
                    }
                }else if(jogador % 2 == 0){
                    int rand = lancarDado();
                    if (rand == 1) {
                        int random = Dado();
                        System.out.println("Tirou " + random);
                        p2 += random;
                        for (int house : sorte) {
                            if(house == p2){
                                System.out.println("Kit te cura: +2 Casas");
                                p2 += 2;
                                break;
                            }
                        }
                        for (int house : reves) {
                            if(house == p2){
                                System.out.println("Charlie te prende e Amber te queima -2 Casas");
                                p2 -= 2;
                                break;
                            }
                        }
                        System.out.println("Posição do Marco: " + p2);
                        jogador++;
                        System.out.println("Vez de Igor");
                    }
                }
                if (p1 >= 32) {
                    System.out.println("Igor venceu o jogo!");
                }
                if (p2 >= 32) {
                    System.out.println("Marco venceu o jogo!");
                }
            }
        }
    }
}