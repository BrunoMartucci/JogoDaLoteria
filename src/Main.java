import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Digite seus seis números entre 1 e 99:");
        int[] numerosApostados = new int[6];
        for (int i = 0; i < 6; i++) {
            numerosApostados[i] = scanner.nextInt();
        }

        int[] numerosSorteados = gerarNumerosSorteados();

        int numerosCorrespondentes = contarNumerosCorrespondentes(numerosApostados, numerosSorteados);

        validarPremio(numerosCorrespondentes);

        System.out.println("Números sorteados: " + Arrays.toString(numerosSorteados));

        scanner.close();
    }
    private static int[] gerarNumerosSorteados() {
        Random random = new Random();
        int[] numerosSorteados = new int[6];

        for (int i = 0; i < 6; i++) {
            numerosSorteados[i] = random.nextInt(99) + 1;
        }

        return numerosSorteados;
    }


    private static int contarNumerosCorrespondentes(int[] apostados, int[] sorteados) {
        int contagem = 0;

        for (int numeroApostado : apostados) {
            for (int numeroSorteado : sorteados) {
                if (numeroApostado == numeroSorteado) {
                    contagem++;
                    break;
                }
            }
        }

        return contagem;
    }


    private static void validarPremio(int acertos) {
        switch (acertos) {
            case 3:
                System.out.println("Parabéns! Você ganhou um terno!");
                break;
            case 4:
                System.out.println("Parabéns! Você ganhou uma quadra!");
                break;
            case 5:
                System.out.println("Parabéns! Você ganhou uma quina!");
                break;
            case 6:
                System.out.println("Parabéns! Você ganhou a sena!");
                break;
            default:
                System.out.println("Infelizmente, você não ganhou nenhum prêmio. Tente novamente!");
        }
    }
}
