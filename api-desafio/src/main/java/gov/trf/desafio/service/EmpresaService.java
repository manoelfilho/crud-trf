package gov.trf.desafio.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import gov.trf.desafio.model.Empresa;
import gov.trf.desafio.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public Empresa save(Empresa empresa) {
		return empresaRepository.save(empresa);
	}

	public Empresa update(Empresa empresa, int id) {
		Optional<Empresa> savedEmpresa = empresaRepository.findById(id);
		empresa.setId(id);
		if (savedEmpresa.isPresent())
			empresaRepository.save(empresa);
		return empresa;
	}

	public void delete(Integer idEmpresa) {
		Optional<Empresa> savedEmpresa = empresaRepository.findById(idEmpresa);
		if (savedEmpresa.isPresent()) {
			empresaRepository.delete(savedEmpresa.get());
		}
	}

	public Slice<Empresa> filtrar(int pagina, int tamanho, String nome, String cnpj) {
		Pageable pageable = PageRequest.of(pagina, tamanho);
		return empresaRepository.findByNomeAndCnpj(nome, cnpj, pageable);
	}

	public Empresa buscar(int id){
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		if(optionalEmpresa.isPresent()) {
			return optionalEmpresa.get();
		}else {
			return new Empresa();
		}
	}

}
