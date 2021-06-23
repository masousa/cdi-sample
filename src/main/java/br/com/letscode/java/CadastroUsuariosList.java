package br.com.letscode.java;


import br.com.letscode.java.anotacoes.UsuarioList;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;

@UsuarioList
//@Alternative
//@Named("list")
public class CadastroUsuariosList implements CadastroUsuarios{
    @Override
    public Usuario adicionar(Usuario usuario) {
        System.out.println("adicionado");
        return null;
    }

    @Override
    public int buscar(String login) {
        return 0;
    }

    @Override
    public void remover(String login) {

    }

    @Override
    public void listarTodos(Usuario usuario) {

    }

    @Override
    public Usuario getUsuario(String login) {
        return null;
    }
}
