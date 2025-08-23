import com.google.gson.Gson;

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ConsultaCep {

    public EnderecoDto requisicaoAPI(String cep){
        URI endereco = URI.create("https://viacep.com.br/ws/"+cep+"/json/");
        HttpClient client = HttpClient.newBuilder()
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            return gson.fromJson(response.body(), EnderecoDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            throw new RuntimeException("Não consegui obter o endereço! ");
        }

    }

}
