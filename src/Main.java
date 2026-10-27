import Models.Celta;
import Models.Xogador;
import Services.CeltaService;
import Services.FileService;
import Services.XogadorServices;

import java.io.File;
import java.util.List;

public class Main {
    static void main(String[] args) {
        System.out.println("Insertar Xogadores");
        System.out.println("------------------------------");
        XogadorServices taboaXogadores = new XogadorServices();

        Xogador x1 = new Xogador("Alexander Mostovoi", "Mediocentro", 34);
        Xogador x2 = new Xogador("Valeri Karpin", "Interior dereito", 33);
        Xogador x3 = new Xogador("Gustavo Lopez", "Extremo esquerdo", 29);
        Xogador x4 = new Xogador("Haim Revivo", "Mediapunta", 30);
        Xogador x5 = new Xogador("Claude Makelele", "Pivote", 26);
        Xogador x6 = new Xogador("Michel Salgado", "Lateral dereito", 23);
        Xogador x7 = new Xogador("Patxi Salinas", "Central", 34);
        Xogador x8 = new Xogador("Catanha", "Delantero", 28);

//        taboaXogadores.crearXogador(x1);
//        taboaXogadores.crearXogador(x2);
//        taboaXogadores.crearXogador(x3);
//        taboaXogadores.crearXogador(x4);
//        taboaXogadores.crearXogador(x5);
//        taboaXogadores.crearXogador(x6);
//        taboaXogadores.crearXogador(x7);
//        taboaXogadores.crearXogador(x8);

        System.out.println("Ler taboa xogadores con Id e Nome");
        System.out.println("------------------------------");
        List<Xogador> listaXogadores = taboaXogadores.listarXogadores();

        for (Xogador x : listaXogadores) {
            System.out.println(x.getId() + "-" + x.getNome());
        }

        System.out.println("Formando equipo!");
        List<String> listaMod = FileService.getLista("mod.txt");//Non conseguin que getLista funcionara para sacar los jugadores y meterlos en celta

//        List<Xogador> listaXogadoresMod = taboaXogadores.listarXogadoresMod(listaMod);
//        //A idea seria iterar sobre os nomes e facer una lista de obxetos con xogadores fichados para Celta
//        //Despois facer outro bucle para iterar sobre esta e ir metendoos na taboa de Celta


//        taboaCelta.crearXogadorCelta();

        System.out.println("Valores inseridos \n" + "Exportando equipo para a federación!");
        List<Celta> listaXCelta = null;
        listaXCelta = CeltaService.listarXogadoresCelta();
        for (Celta c : listaXCelta) {
            System.out.println(c.getId()) + c.getNome() + c.getSoldo());
        }

        FileService.serializarXogadoresCelta(listaXCelta, "CeltaSerializado");

        System.out.println("Actualizamos soldos");
        CeltaService.actualizarSoldos(listaXCelta);
        //Creo que non funcionaria tal como o teño, tampouco puden comprobalo

        System.out.println("Diñeiro insuficiente, debemos baixarlle o soldos a alguén :( !!");
        List<Celta> listaDeseri = FileService.deserializarXogadoresCelta("CeltaDeserializado");
        Celta primerXogador = listaDeseri.getFirst();
        System.out.println("O xogador" + primerXogador.getNome() + "debería cobrar" + primerXogador.getNome() + "xerando informe...");

        FileService.toXMl(primerXogador);//Aqui o parametro do xml era pasarlle unha lista porque pensei que habria que convertir mais dun elemento

        taboaXogadores.borrarContidoXogadores();
        CeltaService.borrarContidoXogadoresCelta();
    }
}
