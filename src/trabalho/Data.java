package trabalho;

public class Data {
    private int dia; 
    private int mes; 
    private int ano;

    private final int possiveisDiasDoMes[] = {
       31,29,31,
       30,31,30,
       31,31,30,
       31,30,31
    };

    public void setData(int dia, int mes, int ano) throws Exception {
        if (ano <= 1 || mes < 1 || mes > 12 || dia > possiveisDiasDoMes[mes - 1]) {
            throw new Exception("Data inválida");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes; 
    }

    public int getAno(){
        return this.ano; 
    }

    public String getData() {
        return String.format("%1$2s/%2$2s/%3$4s", this.dia, this.mes, this.ano).replace(' ', '0');
    }

    public static Data parseData(String data) throws NumberFormatException, Exception {
        String[] partesDaData = data.split("/");

        int dia = Integer.parseInt(partesDaData[0]);
        int mes = Integer.parseInt(partesDaData[1]);
        int ano = Integer.parseInt(partesDaData[2]);
        
        Data instancia = new Data();
        instancia.setData(dia, mes, ano);

        return instancia;
    }
}
