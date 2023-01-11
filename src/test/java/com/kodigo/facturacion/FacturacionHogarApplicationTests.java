package com.kodigo.facturacion;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.Propietario;
import com.kodigo.facturacion.persistence.Usuario;
import com.kodigo.facturacion.repository.interfaces.CasaRepository;
import com.kodigo.facturacion.repository.interfaces.PropietarioRepository;
import com.kodigo.facturacion.repository.interfaces.UserRepository;
import com.kodigo.facturacion.service.CasaImpl;
import com.kodigo.facturacion.service.interfaces.CasaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FacturacionHogarApplicationTests {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PropietarioRepository propietarioRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testUserRepository(){
		Usuario usuario = new Usuario();
		usuario.setNombre("Junit.test");
		usuario.setPassword("test123");
		Usuario savedUser = userRepository.save(usuario);
		Usuario recoveredUser = userRepository.findById(savedUser.getIdUsuario()).orElseThrow(()->
				new ResourceNotFoundException("Usuario","Id",savedUser.getIdUsuario()));
		System.out.println(recoveredUser);
		assertAll(()->{
			assertEquals("Junit.test",recoveredUser.getNombre());
			assertEquals("test123",recoveredUser.getPassword());
		});
		userRepository.deleteById(recoveredUser.getIdUsuario());
	}

	@Test
	void testPropietarioRespository(){
		Propietario propietario = new Propietario();
		propietario.setNombrePersona("Propietario JUnit");
		propietario.setCorreo("junit@email.com");
		Propietario propietarioGuardado = propietarioRepository.save(propietario);
		Propietario propietarioRecuperado = propietarioRepository.findById(propietarioGuardado.getCodigoPropietario())
				.orElseThrow(()->
						new ResourceNotFoundException("Propietario","Id",propietarioGuardado.getCodigoPropietario()));
		System.out.println(propietarioRecuperado);
		assertAll(()->{
			assertEquals("Propietario JUnit",propietarioRecuperado.getNombrePersona());
			assertEquals("junit@email.com",propietarioRecuperado.getCorreo());
		});
		userRepository.deleteById(propietarioRecuperado.getCodigoPropietario());
	}

}
