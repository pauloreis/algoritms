package easy.maioremenor;

public class Test {
    public static void main(String[] args) {
        double salario[] = new double[4];
        salario[0] = 32000.00;
        salario[1] = 6000.00;
        salario[2] = 5000.00;
        salario[3] = 2200.00;

        int maiorSalario = 0;
        int menorSalario = 0;

        for(int atual=0; atual<4; atual++){
            if(salario[atual] < salario[menorSalario]){
                menorSalario = atual;
            }
            if(salario[atual] > salario[maiorSalario]){
                maiorSalario = atual;
            }
        }

        System.out.println("Maior Salário: " + salario[maiorSalario]);
        System.out.println("Menor Salário: " + salario[menorSalario]);
    }
}
