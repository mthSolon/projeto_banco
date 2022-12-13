package model;

public class HabilitacaoExame extends GenericModel {
	private String observacao;
	private double custo;
	private Laboratorio id_laboratorio;
	private TipoExame tipo_exame_id;

	public HabilitacaoExame(String observacao, double custo, Laboratorio id_laboratorio, TipoExame tipo_exame_id) {
		this.observacao = observacao;
		this.custo = custo;
		this.id_laboratorio = id_laboratorio;
		this.tipo_exame_id = tipo_exame_id;
	}

	public HabilitacaoExame(Long id, String observacao, double custo, Laboratorio id_laboratorio, TipoExame tipo_exame_id) {
		this.observacao = observacao;
		this.custo = custo;
		this.id_laboratorio = id_laboratorio;
		this.tipo_exame_id = tipo_exame_id;
		super.setId(id);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}

	public Laboratorio getId_laboratorio() {
		return id_laboratorio;
	}

	public void setId_laboratorio(Laboratorio id_laboratorio) {
		this.id_laboratorio = id_laboratorio;
	}

	public TipoExame getTipo_exame_id() {
		return tipo_exame_id;
	}

	public void setTipo_exame_id(TipoExame tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
	}

	@Override
	public String toString() {
		return "HabilitacaoExame{" +
				"observacao='" + observacao + '\'' +
				", custo=" + custo +
				", id_laboratorio=" + id_laboratorio +
				", tipo_exame_id=" + tipo_exame_id +
				'}';
	}
}
