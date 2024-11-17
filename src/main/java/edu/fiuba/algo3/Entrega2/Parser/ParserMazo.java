package edu.fiuba.algo3.Entrega2.Parser;
import  edu.fiuba.algo3.Entrega2.Parser.Parcer;
import edu.fiuba.algo3.entrega_1.Prooveedor.Proveedor;

public class ParserMazo implements Parcer {

    @Override
    public String convertirDeJsonAString(String direccion) {
        String filePath = "user.json";
        String json = FileUtil.readFileAsString(filePath);

        // Crear un ObjectMapper para Jackson
        ObjectMapper mapper = new ObjectMapper();
        return "";
    }


}
