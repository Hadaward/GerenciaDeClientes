package trabalho;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
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
        // Obtém diretório do arquivo
        Path dir = getArquivo().getParent();
        // Valida se o diretório existe
        if (!Files.exists(dir)) {
            // Se não existir, cria os diretórios recursivamente
            Files.createDirectories(dir);
        }
        Files.write(getArquivo(), value.getBytes()); 
    }
    
    public String lerArquivo () throws Exception{
        return Files.readString(getArquivo());
    }
}

