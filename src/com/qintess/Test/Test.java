package com.qintess.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.qintess.dao.GenericDAO;
import com.qintess.model.Cerveja;
import com.qintess.model.Cidade;
import com.qintess.model.Cliente;
import com.qintess.model.Estado;
import com.qintess.model.Estilo;
import com.qintess.model.Grupo;
import com.qintess.model.ItemVenda;
import com.qintess.model.Permissao;
import com.qintess.model.SchemaVersion;
import com.qintess.model.Usuario;
import com.qintess.model.Venda;

public class Test {
	public static void main(String[] args) {
		System.out.println("Criando objeto no java");
			//CRIANDO OBJETOS
		SchemaVersion schemaversion = new SchemaVersion();
			schemaversion.setVersion("D3H 1.0");
			schemaversion.setDescription("Aprender a utilizar Hibernate");
			schemaversion.setType("Controle");
			schemaversion.setScript(null);
			schemaversion.setChecksum(12);
			schemaversion.setInstalledby("Schmidt, R.F.");
			schemaversion.setInstalledon(Timestamp.valueOf(LocalDateTime.now()));
			schemaversion.setExecutiontime(5);
			schemaversion.setSucess(10);
			System.out.println("Salvando Schema_Version no BD");
			GenericDAO<SchemaVersion> schemaversiongenericdao = new GenericDAO<SchemaVersion>();
			schemaversiongenericdao.salvar(schemaversion);
			
			Estilo estilo1 = new Estilo("Irish Stout");
			//estilo1.setNome("Irish Stout");
			Estilo estilo2 = new Estilo("Irish Extra Stout");
			Estilo estilo3 = new Estilo("Foreign Extra Stout");
			System.out.println("Salvando Estilo no BD");
			GenericDAO<Estilo> estilogenericdao = new GenericDAO<Estilo>();
			estilogenericdao.salvar(estilo1);
			estilogenericdao.salvar(estilo2);
			estilogenericdao.salvar(estilo3);

			
			
			Estado estado1 = new Estado();
			estado1.setNome("Sao Paulo");
			estado1.setSigla("SP");
			Estado estado2 = new Estado("Rio de Janeiro", "RJ");
			
			Cidade cidade1 = new Cidade();
			cidade1.setNome("Santos");
			cidade1.setEstado(estado1);
			Cidade cidade2 = new Cidade(estado2, "Cabo Frio");
			Cidade cidade3 = new Cidade(estado1, "Piracicaba");
			
			GenericDAO<Estado> estadogenericdao = new GenericDAO<Estado>();
			estadogenericdao.salvar(estado1);
			estadogenericdao.salvar(estado2);
			
			GenericDAO<Cidade> cidadegenericdao = new GenericDAO<Cidade>();
			cidadegenericdao.salvar(cidade1);
			cidadegenericdao.salvar(cidade2);
			cidadegenericdao.salvar(cidade3);
			System.out.println(cidade1);
			
			Cliente cliente1 = new Cliente();
			cliente1.setNome("Luis Silva");
			cliente1.setTipopessoa("Pessoa Fisica");
			cliente1.setCpfcnpj("111111111-11");
			cliente1.setTelefone("11111111");
			cliente1.setEmail("luissiliva@gmail.com");
			cliente1.setLogradouro("R. I de Maio");
			cliente1.setNumero("11");
			cliente1.setComplemento("");
			cliente1.setCep("111111-111");
			cliente1.setCidade(cidade1);
			Cliente cliente2 = new Cliente(cidade2, "Gabriela Silva", "Pessoa Juridica", "22222222222222200002", "22222222", "gabrielasilva@hormail.com","Av. Joao Pessoa", "222", "", "222222222");
			Cliente cliente3 = new Cliente(cidade3, "João Batista", "Pessoa Fisica", "33333333333", "33333333", "joaobatista@bol.com.br", "R. Pedro Cabral", "333", null, "3333333333");
			GenericDAO<Cliente> clientegenericdao = new GenericDAO<Cliente>();
			clientegenericdao.salvar(cliente1);
			clientegenericdao.salvar(cliente2);
			clientegenericdao.salvar(cliente3);
			
			Permissao permissao1 = new Permissao();
			permissao1.setNome("Alberto Martins");
			Permissao permissao2 = new Permissao("Heloisa Prado");
			System.out.println("Salvando Permissao no BD");
			GenericDAO<Permissao> permissaogenericdao = new GenericDAO<Permissao>();
			permissaogenericdao.salvar(permissao1);
			permissaogenericdao.salvar(permissao2);
			
			Grupo grupo1 = new Grupo("Vendedores Internos");
			Grupo grupo2 = new Grupo("Vendedores Externos");
			grupo1.addPermissao(permissao1);
			grupo2.addPermissao(permissao2);
			System.out.println("Salvar Grupo no BD");
			GenericDAO<Grupo> grupogenericdao = new GenericDAO<Grupo>();
			grupogenericdao.salvar(grupo1);
			grupogenericdao.salvar(grupo2);			
			
			Usuario usuario1 = new Usuario();
			usuario1.setNome("Arnaldo Antunes");
			usuario1.setEmail("arnaldoantunes@gmail.com");
			usuario1.setSenha("123456");
			usuario1.setAtivo((short) 2);
			usuario1.setDatanascimento(Date.valueOf(LocalDate.now()));
			usuario1.addGrupo(grupo1);
			Usuario usuario2 = new Usuario("Luisa Souza", "luisasouza@gmail.com", "098765",(short) 2, Date.valueOf(LocalDate.now()));
			usuario2.addGrupo(grupo2);
			GenericDAO<Usuario> usuariogenericdao = new GenericDAO<Usuario>();
			usuariogenericdao.salvar(usuario1);
			usuariogenericdao.salvar(usuario2);
			Cerveja cerveja1 = new Cerveja(estilo1, "Carnes brancas, peixes e frutos do mar", "CERVEJA SAGRA", "Cerveja Artesana	Sagra 100% Malte Premium Pilsen", 15.0, 1.5, "Aromatica com notas frutadas e florais.", "Espanha - Castilha La-Mancha", 5.5, 100, null, "Ingredientes: água, malte de cerveja, lupulo, levedura" );
			/*cerveja1.setEstilo(estilo1);        //Associar o objeto cerveja ao estilo
			cerveja1.setSku("Harmonizacao: carnes brancas, peixes e frutos do mar");
			cerveja1.setNome("CERVEJA SAGRA");
			cerveja1.setDescricao("Cerveja Artesana	Sagra 100% Malte Premium Pilsen");
			cerveja1.setValor(15.00);
			cerveja1.setComissao(1.50);
			cerveja1.setSabor("Fresca, aromatica com notas frutadas e florais, leve amargor e denso.");
			cerveja1.setOrigem("Espanha - Castilha La-Mancha");
			cerveja1.setTeoralcoolico(5.5);
			cerveja1.setQuantidadeestoque(100);
			cerveja1.setFoto(null);
			cerveja1.setContenttype("Ingredientes: água, malte de cerveja, lupulo, levedura");*/
			Cerveja cerveja2 = new Cerveja(estilo2, "Carnes leves, legumes e frutos do mar.", "DOROT", "Artesanal Dorot 100% Malte- Wiess de Trigo", 12.5, 1.24, "Frutada citrico e cremosa", "Espanha Castilha La-Mancha", 5.8, 100, null, "Água, malte de cevada e trigo, lupulo, levedura, cascas secas de laranja e cuentro");
			Cerveja cerveja3 = new Cerveja(estilo2,"Macarrao sem molho, carnes brancas e saladas", "SEOTOP", "", 14.6, 1.46, "Suave e refrescante", "Italia Roma", 4.7, 100, null, "Água, malte de cevada, lupulo, levedura" );
			System.out.println("Salvando Cerveja no BD");
			GenericDAO<Cerveja> cervejagenericdao = new GenericDAO<Cerveja>();
			cervejagenericdao.salvar(cerveja1);
			cervejagenericdao.salvar(cerveja2);
			cervejagenericdao.salvar(cerveja3);
			
			Venda venda1 = new Venda();
			venda1.setDatacriacao(Date.valueOf(LocalDate.now()));
			venda1.setValorfrete(5.0);
			venda1.setValordesconto(0);
			venda1.setValortotal(100.00);
			venda1.setStatus("Ativo");
			venda1.setObservacao("");
			venda1.setDatahoraentrega(Date.valueOf(LocalDate.now()));
			venda1.setCliente(cliente1);
			venda1.setUsuario(usuario1);
			Venda venda2 = new Venda(cliente1, usuario2, Date.valueOf(LocalDate.now()), 5.0, 10.0, 500.00, "Ativo", "", Date.valueOf(LocalDate.now()));
			GenericDAO<Venda> vendagenericdao = new GenericDAO<Venda>();
			vendagenericdao.salvar(venda1);
			vendagenericdao.salvar(venda2);
			
			ItemVenda itemvenda1 = new ItemVenda();
			itemvenda1.setCerveja(cerveja1);
			itemvenda1.setVenda(venda1);
			itemvenda1.setQuantidade(30);
			itemvenda1.setValorunitario(10.0);
			ItemVenda itemvenda2 = new ItemVenda(cerveja2, venda2, 20, 18.00);
			GenericDAO<ItemVenda> itemvendagenericdao = new GenericDAO<ItemVenda>();
			itemvendagenericdao.salvar(itemvenda1);
			itemvendagenericdao.salvar(itemvenda2);
			
			//BUSCAR DADOS
			System.out.println(itemvendagenericdao.buscaPorId(ItemVenda.class, 2));
			System.out.println(cervejagenericdao.buscaPorId(Cerveja.class, 1));
			System.out.println(estilogenericdao.buscaPorId(Estilo.class, 3));
			System.out.println(vendagenericdao.buscaPorId(Venda.class, 1));
			System.out.println(usuariogenericdao.buscaPorId(Usuario.class, 2));
			System.out.println(clientegenericdao.buscaPorId(Cliente.class, 2));
			System.out.println(cidadegenericdao.buscaPorId(Cidade.class, 3));
			System.out.println(estadogenericdao.buscaPorId(Estado.class, 1));
			System.out.println(grupogenericdao.buscaPorId(Grupo.class, 1));
			System.out.println(permissaogenericdao.buscaPorId(Permissao.class, 2));
			
			//DELETAR DADOS
			/*itemvendagenericdao.deletar(itemvenda2);    
			cervejagenericdao.deletar(cerveja3);
			estilogenericdao.deletar(estilo3);
			vendagenericdao.deletar(venda1);
			usuariogenericdao.deletar(usuario2);
			clientegenericdao.deletar(cliente2);
			cidadegenericdao.deletar(cidade3);
			estadogenericdao.deletar(estado1);
			grupogenericdao.deletar(grupo1);
			permissaogenericdao.deletar(permissao2); */
	}
}
