package trabalho;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files; 

public class GerenciaArquivosTxt {
    private String urlPasta; 
    private String nomeArquivo; 

    public GerenciaArquivosTxt(String nomeArquivo, String urlPasta){
        this.urlPasta = urlPasta; 
        this.nomeArquivo = nomeArquivo;
    }

    public Path getArquivo() {
        return Paths.get(this.urlPasta, this.nomeArquivo);
    }
    
    public boolean verificarArquivo() {
        return Files.exists(
            Paths.get(
                this.getArquivo().toString()
            )
        );
    }

    public void gravarArquivo(String value) throws Exception{
        if(! verificarArquivo()){
            // throw  new Exception("O arquivo não existe"); 
        
        }
        Files.write()
       
    }
}
