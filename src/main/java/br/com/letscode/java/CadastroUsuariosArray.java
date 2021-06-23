package br.com.letscode.java;

import br.com.letscode.java.anotacoes.UsuarioArray;

import javax.enterprise.inject.Default;
import javax.inject.Named;
import java.util.Arrays;
import java.util.stream.Stream;

@UsuarioArray
//@Default
//@Named("array")
public class CadastroUsuariosArray implements CadastroUsuarios {

    private Usuario[] usuarios = new Usuario[10];
    private int qtd = 0;

    @Override
    public Usuario adicionar(Usuario usuario) {
        if (usuario instanceof Admin) {
            try {
                 if (this.buscar("admin") != 0) {
                     System.err.println("Já existe um Admin no cadastro");
                     return null;
                 }
            } catch (UsuarioNaoEncontradoException ex) {
                //faz nada
            }

        }
        if (this.usuarios.length == qtd) {
            this.aumentarCapacidade();
        }
        return this.usuarios[qtd++] = usuario;
    }

    private void aumentarCapacidade() {
        final var tempUsuarios = this.usuarios;
        this.usuarios = new Usuario[usuarios.length * 2];
        System.arraycopy(tempUsuarios, 0, this.usuarios, 0, this.qtd);
    }

    @Override
    public Usuario getUsuario(String login) {
        final var indice = this.buscar(login);
        return this.usuarios[indice];
    }

    @Override
    public int buscar(String login) {
        for (int i = 0; i < this.qtd; i++) {
            final var usr = this.usuarios[i];
            if (usr.getLogin().equalsIgnoreCase(login)) {
                return i;
            }
        }
        throw new UsuarioNaoEncontradoException();
    }

    @Override
    public void remover(String login) {
        if (this.getUsuario(login) instanceof Admin) {
            System.err.println("Não é possível deixar o cadastro sem Admin");
            return;
        }

        final var indice = this.buscar(login);
        this.qtd--;
        this.usuarios[indice] = this.usuarios[this.qtd];
        this.usuarios[this.qtd] = null;
    }

    @Override
    public void listarTodos(Usuario usuario) {
        if (usuario instanceof Admin) {
            String[] nomes  = new String[this.qtd];
            for (int i=0; i<this.qtd; i++) {
                nomes[i] = this.usuarios[i].getNome();
            }
            Arrays.sort(nomes);
            for (String nome : nomes) {
                System.out.println(nome);
            }
        } else {
            throw new NaoAutorizadoException();
        }
    }
}
