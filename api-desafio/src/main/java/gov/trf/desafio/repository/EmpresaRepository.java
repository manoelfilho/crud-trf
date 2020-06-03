package gov.trf.desafio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import gov.trf.desafio.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {

	@Query("FROM empresas e WHERE ( LOWER(e.nome) like %:nome% AND LOWER(e.cnpj) like %:cnpj% ) ORDER BY e.id DESC")
	Page<Empresa> findByNomeAndCnpj(String nome, String cnpj, Pageable pageable);

}