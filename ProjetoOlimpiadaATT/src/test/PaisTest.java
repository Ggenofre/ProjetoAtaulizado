 package test;

import static org.junit.Assert.assertEquals;
import model.Pais;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	PaisService paisService;
	static int id = 0;


	
		@Before
		public void setUp() throws Exception {
			System.out.println("setup");
			pais = new Pais();
			pais.setId(id);
			pais.setNome("camboja02");
			pais.setPopulacao(1000000);
			pais.setArea(8.500151);
			copia = new Pais();
			copia.setId(id);
			copia.setNome("camboja02");
			copia.setPopulacao(1000000);
			copia.setArea(8.500151);
			paisService = new PaisService();
			System.out.println(pais);
			System.out.println(copia);
			System.out.println(id);
		}
		
		@Test
		public void test00Carregar() {
			System.out.println("carregar");
			//para funcionar o cliente 1 deve ter sido carregado no banco por fora
			Pais fixture = new Pais();
			fixture.setId(1);
			fixture.setNome("Brasil");
			fixture.setPopulacao(200000000);
			fixture.setArea(453.543);
			PaisService novoService = new PaisService();
			Pais novo = novoService.carregar(1);
			assertEquals("testa inclusao", novo, fixture);
		}

		@Test
		public void test01Criar() {
			System.out.println("criar");
			id = paisService.criar(pais);
			System.out.println(id);
			copia.setId(id);
			assertEquals("testa criacao", pais, copia);
		}

		@Test
		public void test02Atualizar() {
			System.out.println("atualizar");
			pais.setPopulacao(546546546);
			copia.setPopulacao(546546546);
			paisService.atualizar(pais);
			pais = paisService.carregar(pais.getId());
			assertEquals("testa atualizacao", pais, copia);
		}

		@Test
		public void test03Excluir() {
			System.out.println("excluir");
			copia.setId(-1);
			copia.setNome(null);
			copia.setPopulacao(-1);
			copia.setArea(-1);
			paisService.excluir(id);
			pais = paisService.carregar(id);
			assertEquals("testa exclusao", pais, copia);
		}
	}

