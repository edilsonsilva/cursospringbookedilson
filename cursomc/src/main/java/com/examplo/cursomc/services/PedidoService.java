package com.examplo.cursomc.services;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examplo.cursomc.domain.ItemPedido;
import com.examplo.cursomc.domain.PagamentoComBoleto;
import com.examplo.cursomc.domain.Pedido;
import com.examplo.cursomc.domain.enums.EstadoPagamento;
import com.examplo.cursomc.repositories.ItemPedidoRepository;
import com.examplo.cursomc.repositories.PagamentoRepository;
import com.examplo.cursomc.repositories.PedidoRepository;
import com.examplo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoSerivce;
	
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Pedido.class.getName()));
	}
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj); 
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto= (PagamentoComBoleto) obj.getPagamento();
			boletoSerivce.preencherPagamentoComBoleto(pagto,obj.getInstante());
		}
		obj=repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for(ItemPedido ip:obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		return obj;
	}
}
