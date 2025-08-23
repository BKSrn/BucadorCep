public class CepTamanhoException extends RuntimeException {
    private String message;

    public CepTamanhoException() {
        this.message = "O CEP deve conter 8 dígitos";
    }
    public CepTamanhoException(String message){
        if (message.equals("maior")){
            this.message = "O CEP não pode conter mais de 8 digitos";
        }
    }

    @Override
    public String getMessage() {
        return message;
    }
}
