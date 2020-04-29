import java.util.Scanner;

public class PilhaSequencial {

    //classe de Utilidade
    static Util u = new Util();

    // Pilha
    Aluno[] alunos = new Aluno[10];
    int indiceAtual = 0; //Inicia em 0

    public void Iniciar(Scanner sc){
        u.Escrever("--- Pilha Sequencial (1-10) ---");
        
        boolean voltar = false;
        do{
            u.Escrever("\nEscolha uma opção para executar:\n"
            +"1 - Inserir Aluno ('Nome do Aluno')\n"
            +"2 - Remover Aluno\n"
            +"3 - Exibir Alunos\n"
            +"4 - Voltar\n");
            
            String entrada;
            u.Escrever("FUNCAO:");
            entrada = sc.nextLine();

            switch(entrada){
                case "1":
                InserirElemento(sc);
                break;

                case "2":
                RemoverElemento(sc);
                break;

                case "3":
                ExibirElementos();
                break;

                case "4":
                voltar = true;
                break;
            }

            u.Esperar();

        } while (!voltar);
    }


    //Metodo para inserir elementos (PUSH)
    public void InserirElemento(Scanner sc){

        if(indiceAtual == 10){ //9 que representa a 10ª posicao
            u.Escrever("--- A pilha está Lotada. Remova algum para poder adicionar um novo elemento ---");
        } else {
            
            u.Escrever("NOME:");
            String nome = sc.nextLine();
            
            if(nome != ""){
                Aluno novoAluno = new Aluno(); //Cria um novo aluno
                novoAluno.setNome(nome); //Atribui novo nome para esse aluno.

                alunos[indiceAtual] = novoAluno; //Inclui o aluno no indice atual.
                u.Escrever("--- \""+ novoAluno.getNome()+"\" adicionado na posicao "+ (indiceAtual+1) +" com sucesso!");

                indiceAtual++; //Incrementa o Indice atual.

            } else {
                u.Escrever("Vazio inválido!");
            }
        }
    }


    //Metodo para remover elementos (POP)
    public void RemoverElemento(Scanner sc){

        if(indiceAtual == 0){
            u.Escrever("-- Não há nenhum elemento na pilha.");
        } else {
            u.Escrever("--- Aluno \""+ alunos[indiceAtual -1].getNome() + "\" na posicao "+ indiceAtual  +" removido com sucesso!");
            alunos[indiceAtual - 1] = null;
            indiceAtual--;
        }
    }

    //Metodo para exibir elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        //Mostrando do maior para o menor, para ficar uma pilha graficamente
        for(int i=alunos.length - 1; i>=0; i--){
            if(alunos[i] != null){
                u.Escrever("~ " + (i+1) + " - " + alunos[i].getNome());
            }
        }
       
    }

}
