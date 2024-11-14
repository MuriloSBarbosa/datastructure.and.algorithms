package murilo.barbosa.recursion;

public class Exercises {

    public static void main(String[] args) {
        int[] vetor = {50, 10, 15, 7, 15, 20};

        System.out.println("Soma dos anteriores: ");
        System.out.println(somarAnteriores(5));
        System.out.println("Soma dos elementos: ");
        System.out.println(somarElementos(0, vetor));
        System.out.println("Soma dos elementos pares: ");
        System.out.println(somarElementosPares(0, vetor));
        System.out.println("Quantidade de impares: ");
        System.out.println(getQuantidadeImpar(0, vetor));
        System.out.println("Contar ocorrencias: ");
        System.out.println(contarOcorrencias(15, 0, vetor));
        System.out.println("Maior divisor comum: ");
        System.out.println(maiorDividorComum(90, 54));
        System.out.println("Maior elemento: ");
        System.out.println(maiorElemento(0, vetor));
        System.out.println(maiorElementoComMaiorIndice(0, 0, vetor));
        System.out.println("Soma dos digitos: ");
        System.out.println(somaDigitos(132));
        System.out.println(somaDigitos(8294));
        System.out.println("Binario: ");
        System.out.println(binario(9, ""));
        System.out.println(binarioBetter(9));
        System.out.println(binarioBetter(32));
    }

    private static int somarAnteriores(int i) {
        if (i == 0) {
            return 0;
        }
        return i + somarAnteriores(i - 1);
    }

    private static int somarElementos(int index, int[] vetor) {
        if (index > vetor.length - 1) {
            return 0;
        }
        return vetor[index] + somarElementos(index + 1, vetor);
    }

    private static int somarElementosPares(int index, int[] vetor) {
        if (index > vetor.length - 1) {
            return 0;
        }
        int value = vetor[index] % 2 == 0 ? vetor[index] : 0;
        return value + somarElementosPares(index + 1, vetor);
    }

    private static int getQuantidadeImpar(int index, int[] vetor) {
        if (index > vetor.length - 1) {
            return 0;
        }
        int value = vetor[index] % 2 != 0 ? 1 : 0;
        return value + getQuantidadeImpar(index + 1, vetor);
    }

    private static int contarOcorrencias(int target, int index, int[] vetor) {
        if (index > vetor.length - 1) {
            return 0;
        }
        int value = vetor[index] == target ? 1 : 0;
        return value + contarOcorrencias(target, index + 1, vetor);
    }

    private static int maiorDividorComum(int first, int second) {
        int rest = first % second;
        if (rest == 0) {
            return second;
        }
        return maiorDividorComum(second, rest);
    }

    private static int maiorElemento(int index, int[] vetor) {
        if (index >= vetor.length) {
            return vetor[index - 1];
        }
        int maior = maiorElemento(index + 1, vetor);
        return Math.max(vetor[index], maior);
    }

    private static int maiorElementoComMaiorIndice(int index, int indexMaior, int[] vetor) {
        if (index > vetor.length - 1) {
            return vetor[indexMaior];
        }
        int maior = vetor[index] > vetor[indexMaior] ? index : indexMaior;
        return maiorElementoComMaiorIndice(index + 1, maior, vetor);
    }

    private static int somaDigitos(int numero) {
        int divided = numero / 10;
        int rest = numero % 10;
        if (divided == 0) {
            return numero;
        }
        return somaDigitos(divided) + rest;
    }

    private static String binario(int numero, String result) {
        int divided = numero / 2;
        int rest = numero % 2;

        if (divided == 0) {
            return rest + result;
        }

        return binario(divided, rest + result);
    }

    private static String binarioBetter(int numero) {
        if (numero == 0) {
            return "";
        }
        String num = numero % 2 == 0 ? "0" : "1";

        return binarioBetter(numero / 2) + num;
    }
}
