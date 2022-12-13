package model;

public class MedicoHasEspecialidade extends GenericModel{
    private Medico medico_id;
    private Especialidade especialidade_id;

    public MedicoHasEspecialidade(Medico medico_id, Especialidade especialidade_id) {
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
    }

    public MedicoHasEspecialidade(Long id, Medico medico_id, Especialidade especialidade_id) {
        this.medico_id = medico_id;
        this.especialidade_id = especialidade_id;
        super.setId(id);
    }

    public Medico getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Medico medico_id) {
        this.medico_id = medico_id;
    }

    public Especialidade getEspecialidade_id() {
        return especialidade_id;
    }

    public void setEspecialidade_id(Especialidade especialidade_id) {
        this.especialidade_id = especialidade_id;
    }

    @Override
    public String toString() {
        return "MedicoHasEspecialidade{" +
                "medico_id=" + medico_id +
                ", especialidade_id=" + especialidade_id +
                '}';
    }
}

