package easy;

// Gerar números sequenciais
// Deve-se receber o parametro de quantos periodos existirão
// Para cada período qual o lote minimo e lote maximo
// Gerar sequencial de 0 à 99.999 incrementando sempre 1 ao lote para cada numero gerado
// Quando chegar no lote maximo, voltar lote para o lote mínimo.
// Quando mudar período, voltar o lote para o lote mínimo do período.


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class GenerateRandonNumbers {

    private static final Long ESCALA = 1L;
    private static final Long QTD_NUMBERS = 10L * ESCALA;

    private static final Long SERIAL_MIN = 0L;

    private static final Long SERIAL_MAX = 99999L;

    public static void main(String[] args) {
        Periodo periodOptional = getPeriodoEntry();
        generateNumber(getLoteMax(periodOptional), getLoteMin(periodOptional));
    }

    private static Periodo getPeriodoEntry() {
        Map<Long, Periodo> periodos = CreatePeriod.create();
        Optional<Map.Entry<Long, Periodo>> periodOptional = periodos.entrySet().stream().filter(p -> p.getKey().equals(2L)).findFirst();
        return periodOptional.get().getValue();
    }

    private static Long getLoteMin(Periodo periodOptional) {
        return periodOptional.loteMin;
    }

    private static Long getLoteMax(Periodo periodOptional) {
        return periodOptional.loteMax;
    }

    private static void generateNumber(Long loteMax, Long loteMin) {
        Long currentLot = loteMin;
        for(int i=0; i < QTD_NUMBERS; i++){
            validaLoteMinMax(loteMax, loteMin);
            currentLot = ehCurrentLot(loteMax, loteMin, currentLot);
            System.out.println(createNumber(currentLot));
            currentLot++;
        }
    }

    private static String createNumber(Long currentLot) {
        return currentLot +"/"+ generateSerial();
    }

    private static Long ehCurrentLot(Long loteMax, Long loteMin, Long currentLot) {
        if(currentLot > loteMax){
            currentLot = loteMin;
        }
        return currentLot;
    }

    private static Long generateSerial() {
        Random aleatorio = new Random();
        Long serial = aleatorio.nextInt(Math.toIntExact((SERIAL_MAX - SERIAL_MIN) + 1)) + SERIAL_MIN;
        return serial;
    }

    private static void validaLoteMinMax(Long max, Long min) {
        if(min > max) throw new RuntimeException("Min not can major with max!");
    }
}

class Periodo{
    Long id;
    String nome;
    Long loteMin;
    Long loteMax;
}

class CreatePeriod{

    public static Map<Long, Periodo> create(){
        Map<Long, Periodo> periodos = new HashMap<>();

        Periodo periodo1 = new Periodo();
        periodo1.id = 1L;
        periodo1.nome = "Período 1";
        periodo1.loteMin = 0L;
        periodo1.loteMax = 3L;

        Periodo periodo2 = new Periodo();
        periodo2.id = 2L;
        periodo2.nome = "Período 2";
        periodo2.loteMin = 4L;
        periodo2.loteMax = 7L;

        Periodo periodo3 = new Periodo();
        periodo3.id = 3L;
        periodo3.nome = "Período 3";
        periodo3.loteMin = 10000L;
        periodo3.loteMax = 14999L;

        periodos.put(1L, periodo1);
        periodos.put(2L, periodo2);
        periodos.put(3L, periodo3);

        return periodos;
    }
}