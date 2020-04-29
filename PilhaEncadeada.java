import java.util.Scanner;

public class PilhaEncadeada {

    //classe de Utilidade
    static Util u = new Util();

    // Pilha
    Aluno primeiroAluno, ultimoAluno;
    int qtdAlunos = 0; // Inicia 0

    public void Iniciar(Scanner sc) {
        u.Escrever("--- Pilha Encadeada ---");

        boolean voltar = false;
        do {
            u.Escrever("\nEscolha uma opção para executar:\n"
            + "1 - Inserir Aluno ('Nome do Aluno')\n"
            + "2 - Remover Aluno\n"
            + "3 - Exibir Alunos\n"
            + "4 - Voltar\n");
            
            String entrada;
            u.Escrever("FUNÇÃO:");
            entrada = sc.nextLine();

            switch (entrada) {
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

        u.Escrever("NOME:");
        String nome = sc.nextLine();
        
        if(nome != ""){
            
            //Define o novo nome para esse aluno.
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(nome);

            if (qtdAlunos == 0){
                //Define esse como primeiro e ultimo aluno
                //caso não exista nenhum
                primeiroAluno = novoAluno;
                ultimoAluno = novoAluno;
                
            } else {
                //Se já existir aluno, pega o ultimoAluno e
                //define quem será o proximo aluno em relação a ele.
                ultimoAluno.setProximo(novoAluno); //Definimos o novo 'proximo' do ultimo aluno
                novoAluno.setAnterior(ultimoAluno); //E definimos o novo 'anterior' do novo aluno
                
                ultimoAluno = novoAluno; //Finalmente atribuimos o novo aluno como ultimo
            }

            qtdAlunos++; //Incrementa a quantidade de Alunos
            u.Escrever("~ \""+ novoAluno.getNome() + "\" adicionado na lista!");

            
        } else {
            u.Escrever("Vazio inválido!");
        }
        
    }

    //Metodo para remover elementos. 
    public void RemoverElemento(Scanner sc){

        if(qtdAlunos == 0){
            u.Escrever("~ Não temos ninguém na pilha.");
        } else {
            u.Escrever("~ Aluno \""+ ultimoAluno.getNome() + "\" na posicao "+ qtdAlunos  +" removido!");
            ultimoAluno = ultimoAluno.getAnterior();
            if(qtdAlunos > 1){
                ultimoAluno.setProximo(null);
            }
            qtdAlunos--;
        }

    }

    //Metodo para exibir elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        Aluno aux = ultimoAluno; //Vamos mostrar do ultimo para o primeiro aqui...
        for(int i=qtdAlunos; i > 0; i--){

            //Escrever o aluno atual
            u.Escrever("~ "+ i +" " + aux.getNome());

            //Percorrendo nós
            if(i > 0)
                aux = aux.getAnterior();
        }
        

    }

}
