package model;

public class Composicao extends GenericModel {
	private Exame exame_id;
	private ComposicaoExame composicao_exame_id;
	private ValorReferenciaComposicaoExame valor_referencia_composicao_exame_id;

	public Exame getExame_id() {
		return exame_id;
	}

	public Composicao(Long id, Exame exame_id, ComposicaoExame composicao_exame_id, ValorReferenciaComposicaoExame valor_referencia_composicao_exame_id) {
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
		super.setId(id);
	}


	public Composicao(Exame exame_id, ComposicaoExame composicao_exame_id, ValorReferenciaComposicaoExame valor_referencia_composicao_exame_id) {
		this.exame_id = exame_id;
		this.composicao_exame_id = composicao_exame_id;
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
	}

	public void setExame_id(Exame exame_id) {
		this.exame_id = exame_id;
	}

	public ComposicaoExame getComposicao_exame_id() {
		return composicao_exame_id;
	}

	public void setComposicao_exame_id(ComposicaoExame composicao_exame_id) {
		this.composicao_exame_id = composicao_exame_id;
	}

	public ValorReferenciaComposicaoExame getValor_referencia_composicao_exame_id() {
		return valor_referencia_composicao_exame_id;
	}

	public void setValor_referencia_composicao_exame_id(ValorReferenciaComposicaoExame valor_referencia_composicao_exame_id) {
		this.valor_referencia_composicao_exame_id = valor_referencia_composicao_exame_id;
	}

	@Override
	public String toString() {
		return "Composicao{" +
				"exame_id=" + exame_id +
				", composicao_exame_id=" + composicao_exame_id +
				", valor_referencia_composicao_exame_id=" + valor_referencia_composicao_exame_id +
				'}';
	}
}
