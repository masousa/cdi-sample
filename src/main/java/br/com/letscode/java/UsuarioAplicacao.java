package br.com.letscode.java;

import br.com.letscode.java.anotacoes.UsuarioArray;
import br.com.letscode.java.anotacoes.UsuarioList;

import javax.inject.Inject;
import javax.inject.Named;

public class UsuarioAplicacao {

    @Inject
    @UsuarioArray
    //@Named("array")
    private CadastroUsuarios cadastroUsuarios;



    public Usuario adicionar(Usuario usuario) {
        return cadastroUsuarios.adicionar(usuario);
    }

    public int buscar(String login) {
        return cadastroUsuarios.buscar(login);

    }
    public void remover(String login) {
        cadastroUsuarios.remover(login);

    }
    public void listarTodos(Usuario usuario) {
        cadastroUsuarios.listarTodos(usuario);

    }
    public Usuario getUsuario(String login) {
        return cadastroUsuarios.getUsuario(login);
    }

}
