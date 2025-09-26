import java.util.Random;
import java.util.Scanner;

public class Main {
    static boolean dividirAtaque = false;
    static boolean especialDisponivel = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int pocao = 2;
        int xp = 0;

        //Controle de Poder Especial, pode ser usado somente 1x


        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");


        while (vidaHeroi > 0 && vidaMonstro > 0) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");

            int escolha = sc.nextInt();

            if (escolha == 1) {

                int danoDoAtaque = atacar(vidaMonstro, rand);
                vidaMonstro -= danoDoAtaque;
                System.out.println("Taffeson Causou " + danoDoAtaque + " de dano");

            } else if (escolha == 2) {

                vidaHeroi = usarPocao(vidaHeroi, pocao);
                pocao--;

            } else if (escolha == 3) {
                defender(dividirAtaque);
            } else if (escolha == 4) {
                poderEspecial(vidaMonstro);
            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                // fugir();
                return;
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            // Turno do monstro
            //TODO leve essa logica para uma função chamada Ataque de Mostro()
            int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
            boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
            if (critico) {
                ataqueMonstro *= 2;
                System.out.println("💥 O monstro acertou um CRÍTICO!");
            }
            if (dividirAtaque) {
                ataqueMonstro /= 2;
            }
            vidaHeroi -= ataqueMonstro;
            System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            // xp = ganharXP();
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }

    // =============================
    //          Funções
    // =============================

    //ATACAR
    public static int atacar(int vidamonstro, Random rand) {
        int ataque = rand.nextInt(4) + 8;
        boolean critico = rand.nextInt(100) < 20;
        if (critico) {
            ataque *= 2;
            System.out.println("💥 Voce Acertou um CRITICO!!");
        }
        return ataque;

    }
    // public static int poderEspecial(int vidaMonstro) { ... }

    //POCAO
    public static int usarPocao(int vidaHeroi, int pocao) {
        if (pocao >= 0) {
            vidaHeroi += 15;
            System.out.println("Você usou uma poção!");
            System.out.println("Vida Atual: " + vidaHeroi);
        } else {
            System.out.println("Você não tem mais Poções");
        }
        return vidaHeroi;
    }


    //DEFENDER
    public static void defender(boolean dividirAtaque) {
        System.out.println("Taffe está Defendendo (Dano reduzido pela metade)");
        dividirAtaque = true;

    }

    //PODER ESPECIAL
    public static int poderEspecial(int vidaMonstro) {

        //  2. Causar 25 de dano fixo no monstro.
        int poderEspecial = 25;
        if (especialDisponivel) {
            vidaMonstro = vidaMonstro - poderEspecial;
            System.out.println("Taffeson usou o poder especial!");
            especialDisponivel = false;
        } else {
            System.out.println("❌ O poder especial já foi usado!");
        }
        return vidaMonstro;
    }
}


