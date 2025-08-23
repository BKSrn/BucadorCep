import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();
        Arquivador arquivador = new Arquivador();

        System.out.println("Informe o cep ");
        String cep = scanner.nextLine();
        
        try {
            if (cep.length() < 8){
                throw new CepTamanhoException();
            } else if (cep.length() > 8) {
                throw new CepTamanhoException("maior");
            }
            EnderecoDto enderecoDto = consultaCep.requisicaoAPI(cep);
            System.out.println(enderecoDto.toString());
            arquivador.salvaJson(enderecoDto);
        }catch (CepTamanhoException e){
            System.out.println(e.getMessage());
        } catch(RuntimeException e){
            throw new RuntimeException(e);
        }

    }
}