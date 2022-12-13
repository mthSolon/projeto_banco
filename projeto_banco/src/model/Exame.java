package model;

public class Exame extends GenericModel {
	private String descricao;
	private String metodo;
	private MaterialExame material_exame_id;
	private TipoExame tipo_exame_id;

	public Exame(String descricao, String metodo, MaterialExame material_exame_id, TipoExame tipo_exame_id) {
		this.descricao = descricao;
		this.metodo = metodo;
		this.material_exame_id = material_exame_id;
		this.tipo_exame_id = tipo_exame_id;
	}

	public Exame(Long id, String descricao, String metodo, MaterialExame material_exame_id, TipoExame tipo_exame_id) {
		this.descricao = descricao;
		this.metodo = metodo;
		this.material_exame_id = material_exame_id;
		this.tipo_exame_id = tipo_exame_id;
		super.setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public MaterialExame getMaterial_exame_id() {
		return material_exame_id;
	}

	public void setMaterial_exame_id(MaterialExame material_exame_id) {
		this.material_exame_id = material_exame_id;
	}

	public TipoExame getTipo_exame_id() {
		return tipo_exame_id;
	}

	public void setTipo_exame_id(TipoExame tipo_exame_id) {
		this.tipo_exame_id = tipo_exame_id;
	}

	@Override
	public String toString() {
		return "Exame{" +
				"descricao='" + descricao + '\'' +
				", metodo='" + metodo + '\'' +
				", material_exame_id=" + material_exame_id +
				", tipo_exame_id=" + tipo_exame_id +
				'}';
	}
}
