package gov.trf.desafio.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gov.trf.desafio.model.Empresa;
import gov.trf.desafio.service.EmpresaService;

@RestController
public class EmpresaController {
	
	@Autowired 
	EmpresaService empresaService;
	
	@PostMapping({ "/empresa" })
	public Empresa criar(@Valid @RequestBody Empresa empresa) {
		return empresaService.save(empresa);
	}
	
	@PutMapping("/empresa/{id}")
	public Empresa alterar(@RequestBody Empresa empresa, @PathVariable int id) {
		return empresaService.update(empresa, id);
	}
	
	@DeleteMapping("/empresa/{id}")
	public void excluir(@PathVariable int id) {
		empresaService.delete(id);
	}
	
	@GetMapping("/empresa/{id}")
	public Empresa buscar(@PathVariable int id) {
		return empresaService.buscar(id);
	}
	
	@GetMapping({ "/empresa" })
	public Slice<Empresa> filtrar(
			@RequestParam(value = "pagina", required = false, defaultValue = "0") int pagina,
			@RequestParam(value = "tamanho", required = false, defaultValue = "10") int tamanho,
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
			@RequestParam(value = "cnpj", required = false, defaultValue = "") String cnpj) {
		return empresaService.filtrar(pagina, tamanho, nome, cnpj);
		
	}

}
