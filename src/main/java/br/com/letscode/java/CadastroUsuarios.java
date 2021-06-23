package br.com.letscode.java;

public interface CadastroUsuarios {

    CadastroUsuarios instance = new CadastroUsuariosArray();

    static CadastroUsuarios getDefault() {
        return CadastroUsuarios.instance;
    }

    Usuario adicionar(Usuario usuario);
    int buscar(String login);
    void remover(String login);
    void listarTodos(Usuario usuario);
    Usuario getUsuario(String login);

}
