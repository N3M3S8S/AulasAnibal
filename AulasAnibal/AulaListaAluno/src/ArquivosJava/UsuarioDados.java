package ArquivosJava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsuarioDados {
    //Criando atributos
    private String nome;
    private String email;
    private String senha;
    private String login;
    private String telefone;
    private float[] notas = new float[4];
    
    //Método construtor padrão
    public UsuarioDados(){
        
    }
    
    public UsuarioDados(String nome, String email, String login, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.login = login;
        this.telefone = telefone;
    }
    
    //Definindo funções Get (receber) e Set (definir)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public float[] getNotas() {
        return notas;
    }

    public void setNotas(float[] notas) {
        this.notas = notas;
    }    
    
    public List<UsuarioDados> getUsuarios() throws FileNotFoundException {
        File file = new File("Usuarios.csv");
        List<UsuarioDados> listaUsuarios = new ArrayList<UsuarioDados>();
        if(!file.exists()) { return listaUsuarios;}
        Scanner scan = new Scanner(file); //lê linha por linha
        String linha;
        String[] colunas;
        while(scan.hasNextLine()) {
            linha =  scan.nextLine();
            colunas = linha.split(",");
            String nome = colunas[0];
            String email = colunas[1];
            String login = colunas[2];
            String senha = colunas[3];
            String telefone = colunas[4];
            UsuarioDados user = new UsuarioDados(nome, email, login, senha, telefone);
            listaUsuarios.add(user);
        }
        return listaUsuarios;
    }
    
    public void cadastrar() throws IOException {
        File file = new File("Usuarios.csv");
        FileWriter arquivo;
        if(!file.exists()) {
            file.createNewFile();
            String cabecalho = "nome,email,login,senha,telefone";
            arquivo = new FileWriter(file, true);
            arquivo.write(cabecalho+"\r\n");
            arquivo.close();
        }
        arquivo = new FileWriter(file, true);
        String text = nome+","+email+","+login+","+senha+","+telefone+"\r\n";
        arquivo.write(text);
        arquivo.close();
    }
}
