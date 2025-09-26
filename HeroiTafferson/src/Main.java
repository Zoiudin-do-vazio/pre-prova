import java.util.Random;
import java.util.Scanner;

public class Main {
    static boolean dividirAtaque = false;
    static boolean especialDisponivel = true;
    static boolean fugiu = false;
    static int pocao = 2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int xp = 0;

        //Controle de Poder Especial, pode ser usado somente 1x


        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");


        while (vidaHeroi > 0 && vidaMonstro > 0 && !fugiu) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("==================");
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");
            System.out.println(":");

            int escolha = sc.nextInt();

            if (escolha == 1) {

                vidaMonstro = atacar(vidaMonstro, rand);

            } else if (escolha == 2) {

                vidaHeroi = usarPocao(vidaHeroi);


            } else if (escolha == 3) {

                defender(escolha);

            } else if (escolha == 4) {

                vidaMonstro = poderEspecial(vidaMonstro);

            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                fugir(escolha);
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
                ataqueMonstro = ataqueMonstro / 2;
            }
            vidaHeroi -= ataqueMonstro;
            System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
            dividirAtaque = false;
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
            xp = ganharxp(xp, rand);
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else if (vidaHeroi <= 0) {

            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");

        } else {
            System.out.println("\uD83C\uDFC3\uD83D\uDCA8 Tafferson fugiu... e agora quem irá nos defender (nao irá ser o chapolin)");

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
            System.out.println("💥 Taffeson atacou!  'Crítico!'");
            System.out.println(" Taffeson Causou " + ataque + " de dano!");
        } else {
            System.out.println("💥 Taffeson atacou! e causou " + ataque + " de dano!");

        }
        return ataque;

    }
    // public static int poderEspecial(int vidaMonstro) { ... }

    //POCAO
    public static int usarPocao(int vidaHeroi) {
        if (pocao > 0) {
            vidaHeroi += 15;
            pocao--;
            System.out.println("\uD83C\uDF75 Você usou uma poção! +15 ");
            System.out.println("❤️ Vida Atual:" + vidaHeroi);
        } else {
            System.out.println("❌ Você não tem mais Poções! \uD83C\uDF75");
        }
        return vidaHeroi;
    }


    //DEFENDER
    public static void defender(int escolha) {

        if (escolha == 3) {
            dividirAtaque = true;
            System.out.println("\uD83D\uDEE1 Taffe está Defendendo (Dano reduzido pela metade)");
        } else dividirAtaque = false;

    }

    //PODER ESPECIAL
    public static int poderEspecial(int vidaMonstro) {

        int poderEspecial = 25;  //Dano fixo
        if (especialDisponivel) {
            vidaMonstro = vidaMonstro - poderEspecial;
            System.out.println("\uD83D\uDDE1 Taffeson usou o poder \uD83C\uDF20 ESPECIAL! \uD83C\uDF20 ");
            System.out.println(" ⭐ Taffeson causou " + poderEspecial + " de dano! ⭐");
            especialDisponivel = false;
        } else {
            System.out.println("❌ O poder especial já foi usado!");
        }
        return vidaMonstro;
    }

    // XP
    public static int ganharxp(int xp, Random rand) {
        xp = rand.nextInt(20) + 10;

        return xp;
    }

    // FUGIR
    public static boolean fugir(int escolha) {
        if (escolha == 5) {
            fugiu = true;
            System.out.println("\uD83D\uDCAB Tafferson saiu correndo da luta");
        }
        return fugiu;
    }


}