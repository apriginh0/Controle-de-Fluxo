package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class FiltroSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
        imprimirSelecionados();


    }

    static void imprimirSelecionados(){
        System.out.println("\nCandidatos selecionados:\n");
        for (int i = 0; i < numCandidatoSelecionado; i++) {
            System.out.println(candidatosSelecionados[i]);
        }
        for (String candidato: candidatosSelecionados){
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    private static final int maxCandidatosSelecionados = 5;
    private static final String[] candidatosSelecionados = new String[maxCandidatosSelecionados];
    private static int numCandidatoSelecionado = 0;

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosAtual = 0;
        double salarioBase = 2000.00;
        while (numCandidatoSelecionado < maxCandidatosSelecionados && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou esse valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados[numCandidatoSelecionado] = candidato;
                numCandidatoSelecionado++;
            }
            candidatosAtual++;
        }
        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativasRealizadas++;
            } else {
                System.out.println("Contato realizado com sucesso.");
            }
        }while (continuarTentando && tentativasRealizadas < 3);
        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na "+ tentativasRealizadas + " tentativa.");
        } else{
            System.out.println("Não conseguimos contato com "+ candidato + ", número máximo de tentativas: " + tentativasRealizadas);
        }
    }

}
