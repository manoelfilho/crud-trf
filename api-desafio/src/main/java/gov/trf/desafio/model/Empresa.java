package gov.trf.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "empresas")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 18, max = 18, message = "CNPJ - Forneça o mínimo de {max} caracteres")
	@NotNull(message = "CNPJ não pode ser nulo")
	@NotEmpty(message = "CNPJ não pode ser vazio")
	@Column(length = 18, nullable = false)
	private String cnpj;

	@Size(min = 2, max = 50, message = "Nome - Forneça o mínimo de {min} caracteres e o máximo de {max}")
	@NotNull(message = "Nome não pode ser nulo")
	@Column(length = 50, nullable = false)
	@NotEmpty(message = "Nome não pode ser vazio")
	private String nome;

	@NotNull(message = "Tipo de empresa - Não pode ser nulo")
	@Column(length = 6, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEmpresa tipoEmpresa;

	@Size(max = 40, message = "Razão Social - Forneça o máximo de {max} caracteres")
	@NotNull(message = "Razão socia não pode ser nulo")
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Razão Social não pode ser vazio")
	private String razaoSocial;

	@Size(max = 40, message = "Contato - Forneça o máximo de {max} caracteres")
	@NotNull(message = "Contato não pode ser nulo")
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Contato não pode ser vazio")
	private String contato;

	@Size(max = 40, message = "Email - Forneça o máximo de {max} caracteres")
	@Email(message = "Forneça um email válido")
	@NotNull(message = "Email não pode ser nulo")
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Email não pode ser vazio")
	private String email;

	@Size(max = 8, message = "CEP - Forneça o máximo de {max} caracteres")
	@NotNull(message = "CEP não pode ser nulo")
	@NotEmpty(message = "CEP não pode ser vazio")
	@Column(length = 8, nullable = false)
	private String cep;

	@Size(max = 40, message = "Estado - Forneça o máximo de {max} caracteres")
	@NotNull(message = "Estado não pode ser nulo")
	@NotEmpty(message = "Estado não pode ser vazio")
	@Column(length = 40, nullable = false)
	private String estado;

	@Size(max = 40, message = "Bairro - Forneça o máximo de {max} caracteres")
	@NotNull(message = "Bairro não pode ser nulo")
	@NotEmpty(message = "Bairro não pode ser vazio")
	@Column(length = 40, nullable = false)
	private String bairro;

	@Size(max = 40, message = "Forneça o máximo de {max} caracteres")
	@NotNull
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Cidade não pode ser vazio")
	private String cidade;

	@Size(max = 40, message = "Forneça o máximo de {max} caracteres")
	@NotNull(message = "Cidade não pode ser nulo")
	@Column(length = 40, nullable = false)
	@NotEmpty(message = "Logradouro não pode ser vazio")
	private String logradouro;

	@Size(max = 40, message = "Forneça o máximo de {max} caracteres")
	@Column(length = 40, nullable = true)
	private String complemento;

	public Empresa() {
	}

	public Empresa(String cnpj, String nome, TipoEmpresa tipoEmpresa, String razaoSocial, String contato, String email,
			String cep, String estado, String bairro, String cidade, String logradouro, String complemento) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.tipoEmpresa = tipoEmpresa;
		this.razaoSocial = razaoSocial;
		this.contato = contato;
		this.email = email;
		this.cep = cep;
		this.estado = estado;
		this.bairro = bairro;
		this.cidade = cidade;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoEmpresa getTipoEmpresa() {
		return tipoEmpresa;
	}

	public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
		this.tipoEmpresa = tipoEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
