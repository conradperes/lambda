package memoria.dao;

public class Aviao {
	
	
	
	private String nome;
	private int rodas;
	private double motor;
	private int asas;
	private boolean isJato;
	private int poltronas;
	private String computadorInterno;
	public Aviao(String nome, int rodas, double motor, int asas, boolean isJato, int poltronas,
			String computadorInterno) {
		super();
		this.nome = nome;
		this.rodas = rodas;
		this.motor = motor;
		this.asas = asas;
		this.isJato = isJato;
		this.poltronas = poltronas;
		this.computadorInterno = computadorInterno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getRodas() {
		return rodas;
	}
	public void setRodas(int rodas) {
		this.rodas = rodas;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	public int getAsas() {
		return asas;
	}
	public void setAsas(int asas) {
		this.asas = asas;
	}
	public boolean isJato() {
		return isJato;
	}
	public void setJato(boolean isJato) {
		this.isJato = isJato;
	}
	public int getPoltronas() {
		return poltronas;
	}
	public void setPoltronas(int poltronas) {
		this.poltronas = poltronas;
	}
	public String getComputadorInterno() {
		return computadorInterno;
	}
	public void setComputadorInterno(String computadorInterno) {
		this.computadorInterno = computadorInterno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + asas;
		result = prime * result + ((computadorInterno == null) ? 0 : computadorInterno.hashCode());
		result = prime * result + (isJato ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(motor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + poltronas;
		result = prime * result + rodas;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aviao other = (Aviao) obj;
		if (asas != other.asas)
			return false;
		if (computadorInterno == null) {
			if (other.computadorInterno != null)
				return false;
		} else if (!computadorInterno.equals(other.computadorInterno))
			return false;
		if (isJato != other.isJato)
			return false;
		if (Double.doubleToLongBits(motor) != Double.doubleToLongBits(other.motor))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (poltronas != other.poltronas)
			return false;
		if (rodas != other.rodas)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Aviao [nome=" + nome + ", rodas=" + rodas + ", motor=" + motor + ", asas=" + asas + ", isJato=" + isJato
				+ ", poltronas=" + poltronas + ", computadorInterno=" + computadorInterno + "]";
	}
	

}
