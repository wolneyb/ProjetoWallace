import java.util.concurrent.TimeUnit;

//Classes para facilitar na hora da escrita
public class Util {

    public void Escrever(String texto) {
        if (texto.endsWith(":"))
            System.out.print(texto);
        else
            System.out.println(texto);
    }

    public void Esperar() {
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            Escrever("Houve um erro!");
        }
    }
}
