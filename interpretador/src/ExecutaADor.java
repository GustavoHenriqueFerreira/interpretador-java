/* Linguagem Rinha, usar a extensão .rinha
 *
 * Para testar o interpretador, use o comando:
 *   java -jar Rinha.jar Exemplos/HelloWorld.rinha
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExecutaADor {
    public String[] linhas;
    public Map<String, Double> variaveis;
    public int quantLinhas;

    public ExecutaADor(String[] vetorLinhas, int qtdLinha) {
        this.quantLinhas = qtdLinha;
        this.linhas = vetorLinhas;
        this.variaveis = new HashMap<String, Double>();
    }

    public void Processar() {
        int contLinha = this.quantLinhas;
        for (int i = 0; i < contLinha; i++) {
            String linha = this.linhas[i];
            String[] tokens = linha.split(" ");

            if ("edi".equals(tokens[0])) {
                String nomeVariavel = tokens[1];
                String expressaoLinha[] = linha.split(" ", 4);
                double valorVariavel = Sentencas.ProcessaExpressao(expressaoLinha[3], this.variaveis);
                this.variaveis.put(nomeVariavel, valorVariavel);
            } else if ("print".equals(tokens[0])) {
                String nomeVariavel = tokens[1];
                if (nomeVariavel.startsWith("\"")) {
                    String conteudo = linha.replace("print \"", "");
                    conteudo = conteudo.replace("\"", "");
                    System.out.println(conteudo);
                } else {
                    if (this.variaveis.containsKey(nomeVariavel)) {
                        double valor = this.variaveis.get(nomeVariavel);
                        System.out.println(valor);
                    } else {
                        System.out.println("Variavel " + nomeVariavel + " não definida");
                    }
                }
            } else if ("input".equals(tokens[0])) {
                String nomeVariavel = tokens[1];
                Scanner teclado = new Scanner(System.in);
                if (this.variaveis.containsKey(nomeVariavel)) {
                    double valorDigitado = teclado.nextDouble();
                    this.variaveis.put(nomeVariavel, valorDigitado);
                } else {
                    System.out.println("A variável " + nomeVariavel + " não foi definida");
                }
                teclado.close();
            } else if ("primo".equals(tokens[0])) {
                int x = Integer.parseInt(tokens[1]);
                String res = Primo.TestaPrimo(x);
                System.out.println(res);
            } else if ("if".equals(tokens[0])) {
                int x = Integer.parseInt(tokens[1]);
                String res = String.valueOf(Fluxo.TestaIf(x));
                System.out.println(res);

            }
        }
    }
}