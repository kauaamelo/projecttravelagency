package com.viagenstka.model;

public class Pessoa {
	
	private int idPessoa;
	private String nomeCompletoPessoa; 
	private String cpfPessoa;
	private String endere�oPessoa;
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
	

	public String getEndere�oPessoa() {
		return endere�oPessoa;
	}

	public void setEndere�oPessoa(String endere�oPessoa) {
		this.endere�oPessoa = endere�oPessoa;
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

	public Pessoa(String nomeCompletoPessoa, String cpfPessoa, String endere�oPessoa, String telefonePessoa, String rgPessoa) {
		super();
		this.nomeCompletoPessoa = nomeCompletoPessoa;
		this.cpfPessoa = cpfPessoa;
		this.endere�oPessoa = endere�oPessoa;
		this.telefonePessoa = telefonePessoa;
		this.rgPessoa = rgPessoa;
	}

	public Pessoa() {
		super();
	}
	
	

}
