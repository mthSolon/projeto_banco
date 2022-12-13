package model;

import java.util.Date;

public class SolicitacaoExame extends GenericModel {
	private String nm_prescrito;
	private Date dt_solicitacao;
	private ConsultaMedica consulta_medica_id;
	private HabilitacaoExame habilitacao_exame_id;
	private Exame exame_id;

	public SolicitacaoExame(String nm_prescrito, Date dt_solicitacao, ConsultaMedica consulta_medica_id, HabilitacaoExame habilitacao_exame_id, Exame exame_id) {
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
		this.consulta_medica_id = consulta_medica_id;
		this.habilitacao_exame_id = habilitacao_exame_id;
		this.exame_id = exame_id;
	}

	public SolicitacaoExame(Long id, String nm_prescrito, Date dt_solicitacao, ConsultaMedica consulta_medica_id, HabilitacaoExame habilitacao_exame_id, Exame exame_id) {
		this.nm_prescrito = nm_prescrito;
		this.dt_solicitacao = dt_solicitacao;
		this.consulta_medica_id = consulta_medica_id;
		this.habilitacao_exame_id = habilitacao_exame_id;
		this.exame_id = exame_id;
		super.setId(id);
	}

	public String getNm_prescrito() {
		return nm_prescrito;
	}

	public void setNm_prescrito(String nm_prescrito) {
		this.nm_prescrito = nm_prescrito;
	}

	public Date getDt_solicitacao() {
		return dt_solicitacao;
	}

	public void setDt_solicitacao(Date dt_solicitacao) {
		this.dt_solicitacao = dt_solicitacao;
	}

	public ConsultaMedica getConsulta_medica_id() {
		return consulta_medica_id;
	}

	public void setConsulta_medica_id(ConsultaMedica consulta_medica_id) {
		this.consulta_medica_id = consulta_medica_id;
	}

	public HabilitacaoExame getHabilitacao_exame_id() {
		return habilitacao_exame_id;
	}

	public void setHabilitacao_exame_id(HabilitacaoExame habilitacao_exame_id) {
		this.habilitacao_exame_id = habilitacao_exame_id;
	}

	public Exame getExame_id() {
		return exame_id;
	}

	public void setExame_id(Exame exame_id) {
		this.exame_id = exame_id;
	}

	@Override
	public String toString() {
		return "SolicitacaoExame{" +
				"nm_prescrito='" + nm_prescrito + '\'' +
				", dt_solicitacao=" + dt_solicitacao +
				", consulta_medica_id=" + consulta_medica_id +
				", habilitacao_exame_id=" + habilitacao_exame_id +
				", exame_id=" + exame_id +
				'}';
	}
}

