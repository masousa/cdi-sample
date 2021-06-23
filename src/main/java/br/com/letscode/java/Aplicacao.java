package br.com.letscode.java;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Aplicacao {

    public static void main(String[] args) {
        WeldContainer container = new Weld().initialize();
        var cadastroUsuarios =
                container.select(UsuarioAplicacao.class).get();
        new Aplicacao().executar(cadastroUsuarios);
    }

    private void executar(UsuarioAplicacao cadastroUsuarios) {
        cadastroUsuarios.adicionar(new Usuario("Frodo", "frodo", "frodo123"));
        cadastroUsuarios.adicionar(new Usuario("Sam", "sam", "sam123"));
        cadastroUsuarios.adicionar(new Usuario("Pippin", "pippin", "pippin123"));
        cadastroUsuarios.adicionar(new Admin());
        cadastroUsuarios.adicionar(new Usuario("Meerri", "meerri", "meerri123"));

        login(cadastroUsuarios, "login");
        login(cadastroUsuarios, "frodo");

        cadastroUsuarios.remover("pippin");
        cadastroUsuarios.listarTodos(new Admin());


    }

    private void login(UsuarioAplicacao cadastroUsuarios, String login) {
        try {
            final var usuario = cadastroUsuarios.getUsuario(login);
            System.out.println("Seja bem-vindo, " + usuario.getNome());
        } catch (UsuarioNaoEncontradoException ex) {
            System.err.println("Não autorizado");
        }
    }
}
