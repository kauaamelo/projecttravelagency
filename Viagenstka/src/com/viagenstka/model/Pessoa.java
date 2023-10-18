package com.viagenstka.model;

public class Pessoa {
	
	private int idPessoa;
	private String nomeCompletoPessoa; 
	private String cpfPessoa;
	private String endereçoPessoa;
	private String telefonePessoa;
	private String rgPessoa;
	
	
	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomeCompletoPessoa() {
		return nomeCompletoPessoa;
	}

	public void setNomeCompletoPessoa(String nomeCompletoPessoa) {
		this.nomeCompletoPessoa = nomeCompletoPessoa;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}
	

	public String getEndereçoPessoa() {
		return endereçoPessoa;
	}

	public void setEndereçoPessoa(String endereçoPessoa) {
		this.endereçoPessoa = endereçoPessoa;
	}

	public String getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(String telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public String getRgPessoa() {
		return rgPessoa;
	}

	public void setRgPessoa(String rgPessoa) {
		this.rgPessoa = rgPessoa;
	}

	public Pessoa(String nomeCompletoPessoa, String cpfPessoa, String endereçoPessoa, String telefonePessoa, String rgPessoa) {
		super();
		this.nomeCompletoPessoa = nomeCompletoPessoa;
		this.cpfPessoa = cpfPessoa;
		this.endereçoPessoa = endereçoPessoa;
		this.telefonePessoa = telefonePessoa;
		this.rgPessoa = rgPessoa;
	}

	public Pessoa() {
		super();
	}
	
	

}
