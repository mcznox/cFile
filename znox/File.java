package znox;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class File {

    // Variavel de nome de arquivo
    private String fileName;

    // Variavel de nome de extensao
    private String extension;

    // Variavel de arquivo
    private java.io.File file;

    // Construção...
    public File(String fileName) { this.fileName = fileName; }

    // Construção...
    public File() { }

    // Retorna o nome do arquivo
    public String getFileName() { return fileName; }

    // Retorna a extensão do arquivo
    public String getExtension() { return extension; }

    // Retorna o arquivo
    public java.io.File getFile() { return file; }

    // Aplica um novo arquivo a variavel de arquivo
    public java.io.File setFile(java.io.File file) { return this.file = file; }

    // Aplica um novo nome a variavel de nome do arquivo
    public File setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    // Aplica um novo nome a variavel de extensão
    public File setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    // Adiciona um valor ao arquivo
    public File addValue(String path, String value) throws Exception {
        // Checa se o arquivo já existe
        if (getFile() == null) {
            throw new Error("Primeiramente, crie um arquivo...");
        }
        // Cria uma nova instancia para a edição do arquivo
        PrintWriter writer = new PrintWriter(file, "UTF-8");

        // Escreve no arquivo
        writer.println(builder(new String[] { path, value }));

        // Fecha a conexão com a instancia
        writer.close();
        return this;
    }

    // Cria um novo rquivo
    public File create() {
        java.io.File file = new java.io.File(getFileName() + "." + getExtension());
        if (!file.exists()) {
            this.file = file;
        } else {
            throw new Error("O arquivo ja existe.");
        }

        return this;
    }

    // Cria o estilo do arquivo
    public static String builder(String[] strings) {
        StringBuilder builder = new StringBuilder();
        List<String> stringList = new ArrayList<String>();
        for (String string : strings) { stringList.add(string); }
        for (String string : stringList) {
            if (builder.length() > 1) {
                builder.append(" = ");
            } else {
                return string + " = null;";
            }
            builder.append(string);
        }
        // Retorna ' valor = valor1; '
        return builder.toString() + ";";
    }

}
