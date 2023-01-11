package com.kodigo.facturacion;

import com.kodigo.facturacion.exception.ResourceNotFoundException;
import com.kodigo.facturacion.persistence.*;
import com.kodigo.facturacion.repository.interfaces.*;
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
	@Autowired
	PaisRepository paisRepository;
	@Autowired
	DepartamentoRepository departamentoRepository;
	@Autowired
	MunicipioRepository municipioRepository;
	@Autowired
	CasaRepository casaRepository;

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

	@Test
	void testPaisRepository(){
		Pais pais = new Pais();
		pais.setNombrePais("Pais JUnit");
		Pais paisGuardado = paisRepository.save(pais);
		Pais paisRecuperado = paisRepository.findById(paisGuardado.getCodigoPais()).orElseThrow(()->
				new ResourceNotFoundException("Pais","Id", paisGuardado.getCodigoPais()));
		System.out.println(paisRecuperado);
		assertEquals("Pais JUnit",paisRecuperado.getNombrePais());
		paisRepository.deleteById(paisRecuperado.getCodigoPais());
	}

	@Test
	void testDepartamentoRepository(){
		Pais pais = new Pais();
		pais.setNombrePais("Pais JUnit");
		Pais paisGuardado = paisRepository.save(pais);
		Departamento departamento = new Departamento();
		departamento.setPais(paisGuardado);
		departamento.setNombreDepartamento("Departamento Junit");
		Departamento departamentoGuardado = departamentoRepository.save(departamento);
		Departamento departamentoRecuperado = departamentoRepository.findById(departamentoGuardado.getCodigoDepartamento()).orElseThrow(()->
				new ResourceNotFoundException("Departamento","Id",departamentoGuardado.getCodigoDepartamento()));
		System.out.println(departamentoRecuperado);
		assertAll(()->{
			assertEquals("Pais JUnit",departamentoRecuperado.getPais().getNombrePais());
			assertEquals("Departamento Junit",departamentoRecuperado.getNombreDepartamento());
		});
		departamentoRepository.deleteById(departamentoRecuperado.getCodigoDepartamento());
		paisRepository.deleteById(paisGuardado.getCodigoPais());
	}

	@Test
	void testMunicipioRepository(){
		Pais pais = new Pais();
		pais.setNombrePais("Pais JUnit");
		Pais paisGuardado = paisRepository.save(pais);
		Departamento departamento = new Departamento();
		departamento.setPais(paisGuardado);
		departamento.setNombreDepartamento("Departamento Junit");
		Departamento departamentoGuardado = departamentoRepository.save(departamento);
		Municipio municipio = new Municipio();
		municipio.setDepartamento(departamentoGuardado);
		municipio.setNombreMunicipio("Municipio Junit");
		Municipio municipioGuardado = municipioRepository.save(municipio);
		Municipio municipioRecuperado = municipioRepository.findById(municipioGuardado.getCodigoMunicipio())
				.orElseThrow(()-> new ResourceNotFoundException("Municipio","Id",municipioGuardado.getCodigoMunicipio()));
		System.out.println(municipioRecuperado);
		assertAll(()->{
			assertEquals("Pais JUnit",municipioRecuperado.getDepartamento().getPais().getNombrePais());
			assertEquals("Departamento Junit",municipioRecuperado.getDepartamento().getNombreDepartamento());
			assertEquals("Municipio Junit",municipioRecuperado.getNombreMunicipio());
		});
		municipioRepository.deleteById(municipioRecuperado.getCodigoMunicipio());
		departamentoRepository.deleteById(departamentoGuardado.getCodigoDepartamento());
		paisRepository.deleteById(paisGuardado.getCodigoPais());
	}

	@Test
	void testCasaRepository(){
		Propietario propietario = new Propietario();
		propietario.setNombrePersona("Propietario JUnit");
		propietario.setCorreo("junit@email.com");
		Propietario propietarioGuardado = propietarioRepository.save(propietario);
		Pais pais = new Pais();
		pais.setNombrePais("Pais JUnit");
		Pais paisGuardado = paisRepository.save(pais);
		Departamento departamento = new Departamento();
		departamento.setPais(paisGuardado);
		departamento.setNombreDepartamento("Departamento Junit");
		Departamento departamentoGuardado = departamentoRepository.save(departamento);
		Municipio municipio = new Municipio();
		municipio.setDepartamento(departamentoGuardado);
		municipio.setNombreMunicipio("Municipio Junit");
		Municipio municipioGuardado = municipioRepository.save(municipio);
		Casa casa = new Casa();
		casa.setNumeroCasa("JU-001");
		casa.setCostoMantenimiento(9999999999.99);
		casa.setPropietario(propietarioGuardado);
		casa.setPais(paisGuardado);
		casa.setDepartamento(departamentoGuardado);
		casa.setMunicipio(municipioGuardado);
		Casa casaGuardada = casaRepository.save(casa);
		Casa casaRecuperada = casaRepository.findById(casaGuardada.getCodigoCasa()).orElseThrow(()->
				new ResourceNotFoundException("Casa","Id", casaGuardada.getCodigoCasa()));
		System.out.println(casaRecuperada);
		assertAll(()->{
			assertEquals("Propietario JUnit",casaRecuperada.getPropietario().getNombrePersona());
			assertEquals("junit@email.com",casaRecuperada.getPropietario().getCorreo());
			assertEquals("Pais JUnit",casaRecuperada.getPais().getNombrePais());
			assertEquals("Departamento Junit",casaRecuperada.getDepartamento().getNombreDepartamento());
			assertEquals("Municipio Junit",casaRecuperada.getMunicipio().getNombreMunicipio());
			assertEquals("JU-001",casaRecuperada.getNumeroCasa());
			assertEquals(9999999999.99,casaRecuperada.getCostoMantenimiento());
		});
		casaRepository.deleteById(casaRecuperada.getCodigoCasa());
		propietarioRepository.deleteById(propietarioGuardado.getCodigoPropietario());
		municipioRepository.deleteById(municipioGuardado.getCodigoMunicipio());
		departamentoRepository.deleteById(departamentoGuardado.getCodigoDepartamento());
		paisRepository.deleteById(paisGuardado.getCodigoPais());
	}

}
