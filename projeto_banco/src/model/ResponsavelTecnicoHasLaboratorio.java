package model;

public class ResponsavelTecnicoHasLaboratorio extends GenericModel {
    private ResponsavelTecnico responsavel_tecnico_id;
    private Laboratorio laboratorio_id;

    public ResponsavelTecnicoHasLaboratorio(ResponsavelTecnico responsavel_tecnico_id, Laboratorio laboratorio_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
    }

    public ResponsavelTecnicoHasLaboratorio(Long id, ResponsavelTecnico responsavel_tecnico_id, Laboratorio laboratorio_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
        this.laboratorio_id = laboratorio_id;
        super.setId(id);
    }

    public ResponsavelTecnico getResponsavel_tecnico_id() {
        return responsavel_tecnico_id;
    }

    public void setResponsavel_tecnico_id(ResponsavelTecnico responsavel_tecnico_id) {
        this.responsavel_tecnico_id = responsavel_tecnico_id;
    }

    public Laboratorio getLaboratorio_id() {
        return laboratorio_id;
    }

    public void setLaboratorio_id(Laboratorio laboratorio_id) {
        this.laboratorio_id = laboratorio_id;
    }

    @Override
    public String toString() {
        return "ResponsavelTecnicoHasLaboratorio{" +
                "responsavel_tecnico_id=" + responsavel_tecnico_id +
                ", laboratorio_id=" + laboratorio_id +
                '}';
    }
}