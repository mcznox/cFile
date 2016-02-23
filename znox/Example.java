package znox;

public class Example {

    // Metodo de exemplo
    public void example() throws Exception {
        // Cria uma nova instancia da classe 'File'
        File file = new File();

        // Aplica o nome do arquivo
        file.setFileName("teste");

        // Aplica a extensao do arquivo
        file.setExtension("nox");

        // Cria o arquivo
        file.create();

        // Adiciona um valor ao arquivo
        file.addValue("nickname", "zNoX_");

        // Retorna o arquivo em forma de java.io.File
        java.io.File file2 = file.getFile();
    }

}
