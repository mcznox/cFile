package znox;

public class Example {

    // Metodo de exemplo
    public void example() throws Exception {
        // Cria uma nova instancia da classe 'File'
        File file = new File();

        // Cria uma nova instancia da classe 'File' com o nome do arquivo
        File filee = new File("teste");

        // Aplica o nome do arquivo
        file.setFileName("teste");

        // Aplica a extensao do arquivo
        file.setExtension("nox");

        // Cria o arquivo
        file.create();

        // Retorna uma boolean checando se o arquivo já existe
        file.exist();

        // Adiciona um valor ao arquivo
        file.addValue("nickname", new Object[] {
                "zNoX_", "Programador", 16
                // Irá setar no arquivo assim:
                // values = zNoX_, Programador, 16;
        });

        // Retorna o arquivo em forma de java.io.File
        java.io.File file2 = file.getFile();

        // Retorna um arquivo no diretorio da aplicação
        java.io.File file3 = file.getFileDirectory();

        // Retorna um arquivo com nome específico no diretorio da aplicação
        java.io.File file4 = file.getFileDirectory("teste");

        // Retorna um arquivo com nome e extensão específicas no diretorio da aplicação
        java.io.File file5 = file.getFileDirectory("teste", "nox");
    }

}
