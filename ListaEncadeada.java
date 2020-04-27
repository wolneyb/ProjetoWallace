import java.util.Scanner;

public class ListaEncadeada {

    // Cria a classe de Utilidade
    static Util u = new Util();

    //Descrição da lista
    Aluno primeiroAluno, ultimoAluno;
    int qtdAlunos = 0; // Inicia 0

    public void Iniciar(Scanner sc) {
        u.Escrever("• LISTA ENCADEADA Pode ser infinita se tiver paciência •");

        boolean voltar = false;
        do {
            u.Escrever("\nEscolha uma função para ser executada:\n"
            + "1 - Inserir Aluno ('Nome do Aluno')\n"
            + "2 - Remover Aluno ('Posicao') \n"
            + "3 - Exibir Alunos\n"
            + "4 - Voltar\n");
            
            String entrada;
            u.Escrever("FUNCAO:");
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


    //Inserindo elementos.
    public void InserirElemento(Scanner sc){

        u.Escrever("NOME:");
        String nome = sc.nextLine();
        
        if(nome != ""){
            
            //Define o novo nome para esse aluno.
            Aluno novoAluno = new Aluno();
            novoAluno.setNome(nome);

            qtdAlunos++; //Incrementa a quantidade de Alunos
            
            if (primeiroAluno == null){
                //Define esse como primeiro e ultimo aluno, se não houver nenhum.
                
                primeiroAluno = novoAluno;
                ultimoAluno = novoAluno;

            } else {
                //Se já existir aluno, pega o ultimoAluno e
                //define quem será o proximo aluno em relação a ele.

                ultimoAluno.setProximo(novoAluno); //Define o novo 'proximo' do último aluno
                novoAluno.setAnterior(ultimoAluno); //Define o novo 'anterior' do novo aluno
                
                ultimoAluno = novoAluno; //Atribui o novo aluno como último
            }
            u.Escrever("~ \""+ novoAluno.getNome() + "\" adicionado na lista!");

            
        } else {
            u.Escrever("Inválido!");
        }
        
    }

    //Removendo elementos.
    public void RemoverElemento(Scanner sc){
        u.Escrever("POSICAO:");
        int posicao = Integer.parseInt(sc.nextLine());

        if(posicao > qtdAlunos || posicao < 1){
            u.Escrever("Existem "+qtdAlunos+" posições até o momento. Escolha um numero de 1 a "+qtdAlunos);
        } else {

            //Primeiro aluno como var. auxiliar
            Aluno aux = primeiroAluno;

            for(int i=0; i<posicao; i++){                

                if(i < posicao - 1){
                    //Vai percorrendo um por um, a partir do primeiro aluno
                    aux = aux.getProximo(); 
                
                } else if (i == posicao - 1) {
                    //Ao chegar na posicao desejada...
                    
                    if(i == 0) {
                    //Se FOR o primeiro ALUNO
                        
                        if(qtdAlunos > 1) { //Se existir MAIS de 1 aluno, faça...
                            aux.getProximo().setAnterior(null);
                            primeiroAluno = aux.getProximo();
                            //Pego o proximo aluno, e deixa o Anterior dele NULO
                        }
                        
                    } else if (i < qtdAlunos - 1){
                    //Se NÃO for o ultimo ALUNO da lista
                         
                        aux.getAnterior().setProximo(aux.getProximo());
                        
                        aux.getProximo().setAnterior(aux.getAnterior());            
                    
                    } else {
                    //Se for o ultimo ALUNO da lista
                    
                        ultimoAluno = aux.getAnterior();
                        //Atribui o ANTERIOR deste como ultimoAluno
                    }
                    
                    u.Escrever(" "+(posicao)+" " + aux.getNome() + "REMOVIDO DA LISTA!");
                    aux = null; 
                    qtdAlunos--; //Decrementa do contador.
                }
            }

        }
    }

    //Exibindo elementos.
    public void ExibirElementos(){
        u.Escrever("---- LISTA ----");
        Aluno aux = primeiroAluno;
        for(int i=0; i<qtdAlunos; i++){

            //Escreve o aluno atual
            u.Escrever("  "+(i+1)+" " + aux.getNome());

            //Percorre pelos nós
            if(i < qtdAlunos)
                aux = aux.getProximo();
        }
        u.Escrever("---------------");

    }

}
