package servico;

import DAO.MedicoHasEspecialidadeDAO;
import model.MedicoHasEspecialidade;

import java.sql.SQLException;
import java.util.List;

public class ServicoMedicoHasEspecialidade {
    private MedicoHasEspecialidadeDAO medicoHasEspecialidadeDAO = new MedicoHasEspecialidadeDAO();

    public MedicoHasEspecialidade salvar(MedicoHasEspecialidade entidade) {
        return medicoHasEspecialidadeDAO.insert(entidade);
    }

    public List<MedicoHasEspecialidade>buscarPorMedicoId(Integer id) {
        return medicoHasEspecialidadeDAO.findByMedicoId(id);
    }

    public void update(MedicoHasEspecialidade medico) throws SQLException {
        medicoHasEspecialidadeDAO.updateMedicoHasEspecialidade(medico);
    }

    public List<MedicoHasEspecialidade> buscarTodos() {
        return medicoHasEspecialidadeDAO.selectAllMedicoHasEspecialidades();
    }

    public void remover(Integer id) throws SQLException {
        medicoHasEspecialidadeDAO.deleteMedicoHasEspecialidade(id);
    }
}
