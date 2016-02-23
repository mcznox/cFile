package znox;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

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

    // Retorna o arquivo
    public java.io.File getFileDirectory() { return new java.io.File(getDirectory() + getFileName() + "." + getExtension()); }

    // Retorna um arquivo com nome especifico
    public java.io.File getFileDirectory(String fileName) { return new java.io.File(getDirectory() + fileName + "." + getExtension()); }

    // Retorna um arquivo com nome e extensão específicas
    public java.io.File getFileDirectory(String fileName, String extension) { return new java.io.File(getDirectory() + fileName + "." + extension); }

    // Retorna o diretorio onde o aplicativo esta
    public String getDirectory() { return System.getProperty("user.dir") + "/".replaceAll("/", Matcher.quoteReplacement("\\/")); }

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
    public File addValue(Object path, Object[] values) throws Exception {
        // Checa se o arquivo já existe
        if (!exist()) {
            throw new Error("Primeiramente, crie um arquivo...");
        }
        // Cria uma nova instancia para a edição do arquivo
        PrintWriter writer = new PrintWriter(file, "UTF-8");

        // Escreve no arquivo
        writer.println(builder(path, values));

        // Fecha a conexão com a instancia
        writer.close();
        return this;
    }

    // Cria um novo rquivo
    public File create() throws Exception {
        java.io.File file = new java.io.File(getDirectory() + getFileName() + "." + getExtension());
        if (!file.exists()) {
            // Declara a variavel do arquivo
            this.file = file;

            // Cria o novo arquivo
            getFile().createNewFile();
        } else {
            throw new Error("O arquivo ja existe.");
        }
        return this;
    }

    public boolean exist() {
        return file != null && (file.exists() && !file.isDirectory()) ? true : false;
    }

    // Cria o estilo de linhas do arquivo
    public String builder(Object key, Object[] values) {
        List<Object> objectList = new ArrayList<Object>();
        for (Object object : values) {
            objectList.add(object);
        }

        StringBuilder builder = new StringBuilder();
        for (Object object : objectList) {
            if (builder.length() > 0) {
                builder.append(", ");
            }
            builder.append(object);
        }

        String string = key + " = " + builder.toString() + ";";
        return string;
    }

}
