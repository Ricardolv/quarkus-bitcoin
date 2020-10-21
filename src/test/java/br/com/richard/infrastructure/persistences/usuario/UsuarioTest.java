package br.com.richard.infrastructure.persistences.usuario;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

@QuarkusTest
class UsuarioTest {

    @Test
    public void  testarSeFindByIdOptionalRetornaUsuarioCorreto() {

        PanacheMock.mock(Usuario.class);

        Usuario usuario = new Usuario();
        Optional<PanacheEntityBase> usuarioOptional = Optional.of(usuario);

        Mockito.when(Usuario.findByIdOptional(1)).thenReturn(usuarioOptional);

        Assertions.assertSame(usuario, Usuario.findByIdOptional(1).get());

    }

}