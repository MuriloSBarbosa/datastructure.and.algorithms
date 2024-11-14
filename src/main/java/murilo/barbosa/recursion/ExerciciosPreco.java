package murilo.barbosa.recursion;

import java.util.Arrays;

public class ExerciciosPreco {

    public static void main(String[] args) {
        int[] precos = new int[]{10, 15, 50, 7, 15, 20};
        System.out.println("Preços: ");
        System.out.println(Arrays.toString(precos));

        System.out.println("Quantidade de vendas: ");
        System.out.println(buscarQuantidadeVendas(precos, 0));

        System.out.println("Soma das vendas: ");
        System.out.println(somarVendas(precos, 0));

        System.out.println("Buscar preço: 15");
        System.out.println(buscarPreco(precos, 15, 0));

        System.out.println("Buscar preço: 100");
        System.out.println(buscarPreco(precos, 100, 0));

        System.out.println("Maior preço: ");
        System.out.println(buscarMaiorPreco(precos, 0));

        System.out.println("Menor preço: ");
        System.out.println(buscarMenorPreco(precos, 0));

        System.out.println("Buscar por preço mínimo: 15");
        int[] result = buscarPorPrecoMinimo(precos, 0, 15);
        System.out.println(Arrays.toString(result));

        System.out.println("Buscar por preço mínimo com array: 15");
        int[] result2 = buscarPorPrecoMinimoComArray(precos, 0, 15, new int[precos.length]);
        System.out.println(Arrays.toString(result2));

    }

    public static int buscarQuantidadeVendas(int[] precos, int index) {
        if (index > precos.length - 1) {
            return 0;
        }
        return 1 + buscarQuantidadeVendas(precos, index + 1);
    }

    public static int somarVendas(int[] precos, int index) {
        if (index > precos.length - 1) {
            return 0;
        }
        return precos[index] + somarVendas(precos, index + 1);
    }

    public static boolean buscarPreco(int[] precos, int preco, int index) {
        if (index > precos.length - 1) {
            return false;
        }
        if (precos[index] == preco) {
            return true;
        }
        return buscarPreco(precos, preco, index + 1);
    }

    public static int buscarMaiorPreco(int[] precos, int index) {
        if (index > precos.length - 1) {
            return 0;
        }
        int maior = buscarMaiorPreco(precos, index + 1);
        return Math.max(precos[index], maior);
    }

    public static int buscarMenorPreco(int[] precos, int index) {
        if (index > precos.length - 1) {
            return Integer.MAX_VALUE;
        }
        int menor = buscarMenorPreco(precos, index + 1);
        return Math.min(precos[index], menor);
    }

    public static int[] buscarPorPrecoMinimo(int[] precos, int index, int minimo
    ) {
        if (index > precos.length - 1) {
            return new int[0];
        }

        if (precos[index] >= minimo) {
            int[] result = buscarPorPrecoMinimo(precos, index + 1, minimo);
            int[] resultAux = new int[result.length + 1];
            resultAux[0] = precos[index];
            for (int i = 0; i < result.length; i++) {
                resultAux[i + 1] = result[i];
            }
            return resultAux;
        }
        return buscarPorPrecoMinimo(precos, index + 1, minimo);
    }

    public static int[] buscarPorPrecoMinimoComArray(int[] precos, int index, int minimo,
          int[] filtrados) {
        if (index > precos.length - 1) {
            return filtrados;
        }

        if (precos[index] >= minimo) {
            filtrados[index] = precos[index];
        }

        return buscarPorPrecoMinimoComArray(precos, index + 1, minimo, filtrados);
    }
}
