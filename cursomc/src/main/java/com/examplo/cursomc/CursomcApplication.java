package com.examplo.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.examplo.cursomc.domain.Categoria;
import com.examplo.cursomc.domain.Cidade;
import com.examplo.cursomc.domain.Cliente;
import com.examplo.cursomc.domain.Endereco;
import com.examplo.cursomc.domain.Estado;
import com.examplo.cursomc.domain.ItemPedido;
import com.examplo.cursomc.domain.Pagamento;
import com.examplo.cursomc.domain.PagamentoComBoleto;
import com.examplo.cursomc.domain.PagamentoComCartao;
import com.examplo.cursomc.domain.Pedido;
import com.examplo.cursomc.domain.Produto;
import com.examplo.cursomc.domain.enums.EstadoPagamento;
import com.examplo.cursomc.domain.enums.TipoCliente;
import com.examplo.cursomc.repositories.CategoriaRepository;
import com.examplo.cursomc.repositories.CidadeRepository;
import com.examplo.cursomc.repositories.ClienteRepository;
import com.examplo.cursomc.repositories.EnderecoRepository;
import com.examplo.cursomc.repositories.EstadoRepository;
import com.examplo.cursomc.repositories.ItemPedidoRepository;
import com.examplo.cursomc.repositories.PagamentoRepository;
import com.examplo.cursomc.repositories.PedidoRepository;
import com.examplo.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

		
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	
	}

}
