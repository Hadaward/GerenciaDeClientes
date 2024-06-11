package trabalho;

/**
 * DUPLA: Eduardo Gimenez e Lucas Theodoro
 */

import java.nio.file.Path;
import java.nio.file.Paths;
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
            this.getArquivo()
        );
    }

    public void gravarArquivo(String dados) throws Exception {
        Path dir = getArquivo().getParent();

        if (!Files.exists(dir)) {
            Files.createDirectories(dir);
        }

        Files.write(getArquivo(), dados.getBytes()); 
    }
    
    public String lerArquivo () throws Exception {
        return new String(Files.readAllBytes(getArquivo()), StandardCharsets.UTF_8);
    }
}

