package trabalho;

public class Pessoa {
    private String nome; 
    private String cpf; 
    private String dataNacimento; 
    private String email; 

    public Pessoa(String cpf){
        this.cpf = cpf; 
    }

    public String getNome(){
        return this.nome; 
    }

    public void setNome(String nome){
        this.nome = nome; 
    } 

    public String getDataNacimento(){
        return this.dataNacimento; 
    }

    public void setDataNacimento(String value) throws NumberFormatException, Exception {
        this.dataNacimento = Data.parseData(value).getData(); 
    } 

    public String getEmail(){
        return this.email; 
    }      

    public void setEmail(String email){
        this.email = email;
    }

    public String getCpf(){
        return this.cpf; 
    }

    public void setCpf(String value){
        this.cpf = value; 
    }
}
