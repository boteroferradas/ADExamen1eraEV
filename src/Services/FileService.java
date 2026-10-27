package Services;

import Models.Celta;
import Models.Xogador;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static List<String> getLista(String directorio) {
        List<String> lista = new ArrayList<>();
        File arquivo = new File(directorio);
        if (arquivo.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(arquivo));
                String line = "";
                while ((line =br.readLine())!=null) {
                    lista.add(line);
                }
            } catch (IOException e) {
                System.out.println("Erro lendo algo " + e.getMessage());
            }
        }
        return lista;
    }

    public static void serializarXogadoresCelta(List<Celta> lista, String directorio) {
        File arquivo = new File(directorio);

        try(FileOutputStream fos = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(lista);

        } catch (IOException e) {
            System.out.println("Erro ao serializar xogadores: " + e.getMessage());
        }
    }

    public static List<Celta> deserializarXogadoresCelta(String directorio){
        List<Celta> listaDes = new ArrayList<>();
        File arquivo = new File(directorio);

        try(FileInputStream fis = new FileInputStream(arquivo);
        ObjectInputStream ois = new ObjectInputStream(fis)
        ){
            listaDes = (List<Celta>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listaDes;
    }


    public static void toXMl(List<Celta> listaCelta, String directorio) {
        XMLOutputFactory XOF = XMLOutputFactory.newInstance();
        try(FileWriter fw = new FileWriter(directorio);
            XMLStreamWriter xsw = XOF.createXMLStreamWriter(fw)
        ){
            xsw.writeStartDocument("UTF-8", "1.0");
            xsw.writeCharacters("\n");

            xsw.writeCharacters("\n");
            for (Celta c : listaCelta) {
                xsw.writeStartElement("Xogador");
                xsw.writeAttribute("id", String.valueOf(c.getId()));
                xsw.writeAttribute("Nome", c.getNome());
                xsw.writeAttribute("Soldo", String.valueOf(c.getSoldo()));
                xsw.writeEndElement();
        }

    } catch (XMLStreamException | IOException e) {
            System.out.println("Error al importar a XML: " + e.getMessage());
        }

    }
}
