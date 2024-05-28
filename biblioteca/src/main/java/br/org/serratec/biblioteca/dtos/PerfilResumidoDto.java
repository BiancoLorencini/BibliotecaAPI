package br.org.serratec.biblioteca.dtos;

public class PerfilResumidoDto {

	private String nome;
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return String.format("""
				Nome: %s
				Descrição: %s
				""",nome, descricao);
	}

}
