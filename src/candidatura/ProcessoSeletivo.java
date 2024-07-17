package candidatura;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        System.out.println("\nProcesso seletivo\n");
        analisarCandidato(1900.00);
        analisarCandidato(1900.40);
        analisarCandidato(2200.00);
        analisarCandidato(2000.00);

    }
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.00;
        if(salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PRO CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
