import java.util.Scanner;

class Objeto {
    String descricao;
    int ocorrencia;
    double largura;
    double altura;
    double profundidade;
    String tipoDeGarra;

    Objeto(String descricao) {
        this.descricao = descricao;
        this.ocorrencia = 0;
    }
}

public class GeraListaObjeto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Objeto[] objetos = new Objeto[100];  // Supondo um máximo de 100 objetos
        int count = 0;

        while (true) {
            System.out.println("Insira a descricao do objeto:");
            String descricao = scanner.nextLine();
            if (descricao.isEmpty()) break;

            Objeto obj = null;
            for (int i = 0; i < count; i++) {
                if (objetos[i].descricao.equals(descricao)) {
                    obj = objetos[i];
                    break;
                }
            }

            if (obj == null) {
                obj = new Objeto(descricao);
                System.out.println("Insira a altura do objeto:");
                obj.altura = scanner.nextDouble();
                System.out.println("Insira a largura do objeto:");
                obj.largura = scanner.nextDouble();
                System.out.println("Insira a profundidade do objeto:");
                obj.profundidade = scanner.nextDouble();
                scanner.nextLine();  // Consumir a nova linha

                System.out.println("Insira o tipo de garra recomendada:");
                obj.tipoDeGarra = scanner.nextLine();

                objetos[count++] = obj;
            } else {
                System.out.println("Objeto ja registrado. Atualizando valores.\n");      
                System.out.println("Insira a altura do objeto:");
                obj.altura = scanner.nextDouble();
                System.out.println("Insira a largura do objeto:");
                obj.largura = scanner.nextDouble();
                System.out.println("Insira a profundidade do objeto:");
                obj.profundidade = scanner.nextDouble();
                scanner.nextLine();  // Consumir a nova linha

                System.out.println("Insira o tipo de garra recomendada:");
                obj.tipoDeGarra = scanner.nextLine();

                obj.ocorrencia++;
                System.out.println("Ocorrencia de " + descricao + " aumentada para " + obj.ocorrencia);
            }

            System.out.println("Deseja adicionar mais objetos? (s/n):");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("n")) break;
        }

        // Listagem final
        System.out.println("Lista de todos os objetos registrados:\n");
        for (int i = 0; i < count; i++) {
            Objeto obj = objetos[i];
            System.out.printf("Descricao: %s \nOcorrencia: %d \nDimensoes: \n Altura: %.2f cm\n Largura: %.2f cm\n Profundidade: %.2f cm\nTipo de Garra: %s\n \n",
                    obj.descricao, obj.ocorrencia, obj.largura, obj.altura, obj.profundidade, obj.tipoDeGarra);
        }

        scanner.close();
    }
}
