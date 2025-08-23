import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Arquivador {

    public void salvaJson(EnderecoDto enderecoDto){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            FileWriter writer = new FileWriter("Endereços.json");
            writer.write(gson.toJson(enderecoDto));
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
