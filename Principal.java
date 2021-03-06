import java.util.Scanner;

class Principal {
    
    
    static Util u = new Util();
    
    //Iniciando o Scanner
    static Scanner sc = new Scanner(System.in);

    //Classes das Listas/Pilhas
    static ListaSequencial lista1 = new ListaSequencial();
    static ListaEncadeada lista2 = new ListaEncadeada();
    static PilhaSequencial lista3 = new PilhaSequencial();
    static PilhaEncadeada lista4 = new PilhaEncadeada();

    public static void main(String[] args) {
        
        ListasApp();
    }

    
    public static void ListasApp(){

        boolean sair = false;
        
        do{
            
            //Início do loop das opções do menu.            
            u.Escrever("\nDigite a OPCAO desejada:\n"
            + "1 - Lista Sequencial\n"
            + "2 - Lista Encadeada\n"
            + "3 - Pilha Sequencial\n"
            + "4 - Pilha Encadeada\n"
            + "0 para Sair\n");
            
            u.Escrever("OPCAO:");
            String entrada; //Entrada da opção pelo usuário.
            entrada = sc.nextLine(); //Recebe a entrada do usuário
            
            switch(entrada){
                case "1": //Op(1)-Lista Sequencial
                    lista1.Iniciar(sc);
                    break;
    
                case "2": //Op(2)-Lista Encadeada
                    lista2.Iniciar(sc);
                    break;
    
                case "3": //Op(3)-Pilha Sequencial
                    lista3.Iniciar(sc);
                    break;
    
                case "4": //Op(4)-Pilha Encadeada
                    lista4.Iniciar(sc);
                    break;

                case "0": //Para sair do loop
                    sair = true;
                    break;
            }
            
        } while (!sair); //Mantem o loop enquanto a opção não for "0"
    }
}
