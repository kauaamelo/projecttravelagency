package com.viagenstka.model;

import java.sql.Timestamp;

public class Passagem {
	
	private int idPassagem;
    private int idPessoa;
    private Timestamp dataViagemPassagem;
    private double precoPassagem;
    private String destinoPassagem;
    private double precoPromocionalPassagem;
    private String assentoPassagem;
    private String onibusPassagem;
	
    public Passagem() {
		super();
	}

	public Passagem(Timestamp dataViagemPassagem, double precoPassagem, String destinoPassagem,
			double precoPromocionalPassagem, String assentoPassagem, String onibusPassagem) {
		super();
		this.dataViagemPassagem = dataViagemPassagem;
		this.precoPassagem = precoPassagem;
		this.destinoPassagem = destinoPassagem;
		this.precoPromocionalPassagem = precoPromocionalPassagem;
		this.assentoPassagem = assentoPassagem;
		this.onibusPassagem = onibusPassagem;
	}

	public int getIdPassagem() {
		return idPassagem;
	}

	public void setIdPassagem(int idPassagem) {
		this.idPassagem = idPassagem;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Timestamp getDataViagemPassagem() {
		return dataViagemPassagem;
	}

	public void setDataViagemPassagem(Timestamp dataViagemPassagem) {
		this.dataViagemPassagem = dataViagemPassagem;
	}

	public double getPrecoPassagem() {
		return precoPassagem;
	}

	public void setPrecoPassagem(double precoPassagem) {
		this.precoPassagem = precoPassagem;
	}

	public String getDestinoPassagem() {
		return destinoPassagem;
	}

	public void setDestinoPassagem(String destinoPassagem) {
		this.destinoPassagem = destinoPassagem;
	}

	public double getPrecoPromocionalPassagem() {
		return precoPromocionalPassagem;
	}

	public void setPrecoPromocionalPassagem(double precoPromocionalPassagem) {
		this.precoPromocionalPassagem = precoPromocionalPassagem;
	}

	public String getAssentoPassagem() {
		return assentoPassagem;
	}

	public void setAssentoPassagem(String assentoPassagem) {
		this.assentoPassagem = assentoPassagem;
	}

	public String getOnibusPassagem() {
		return onibusPassagem;
	}

	public void setOnibusPassagem(String onibusPassagem) {
		this.onibusPassagem = onibusPassagem;
	}
    
    
    
    

}
