package DAO;

import model.MedicoHasEspecialidade;
import servico.ServicoEspecialidade;
import servico.ServicoExame;
import servico.ServicoMedico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoHasEspecialidadeDAO extends ConexaoDB {
    private static ServicoMedico servicoMedico = new ServicoMedico();
    private static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();
    private static final String INSERT_MEDICO_HAS_ESPECIALIDADE_SQL = "INSERT INTO medico_has_especialidade (MEDICO_ID, ESPECIALIDADE_ID) VALUES (?, ?);";
    private static final String SELECT_MEDICO_HAS_ESPECIALIDADE_BY_MEDICO_ID = "SELECT MEDICO_ID, ESPECIALIDADE_ID FROM medico_has_especialidade WHERE medico_id = ?";
    private static final String SELECT_ALL_MEDICO_HAS_ESPECIALIDADE = "SELECT * FROM medico_has_especialidade;";
    private static final String DELETE_MEDICO_HAS_ESPECIALIDADE_SQL = "DELETE FROM medico_has_especialidade WHERE id = ?;";
    private static final String UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL = "UPDATE medico_has_especialidade SET MEDICO_ID = ?, ESPECIALIDADE_ID = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM medico_has_especialidade;";

    public Integer count() {
        Integer count = 0;
        try (PreparedStatement preparedStatement = prepararSQL(TOTAL)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public MedicoHasEspecialidade insert(MedicoHasEspecialidade entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_MEDICO_HAS_ESPECIALIDADE_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, entidade.getMedico_id().getId());
            preparedStatement.setLong(2, entidade.getEspecialidade_id().getId());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                entidade.setId(result.getLong(1));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return entidade;
    }

    public List<MedicoHasEspecialidade> findByMedicoId(long id) {
        List<MedicoHasEspecialidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_MEDICO_HAS_ESPECIALIDADE_BY_MEDICO_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int medico_id = rs.getInt("medico_id");
                int especialidade_id = rs.getInt("especialidade_id");
                entidades.add( new MedicoHasEspecialidade(
                        servicoMedico.buscarPorId(medico_id),
                        servicoEspecialidade.buscarPorId(especialidade_id)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public List<MedicoHasEspecialidade> selectAllMedicoHasEspecialidades() {
        List<MedicoHasEspecialidade> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_MEDICO_HAS_ESPECIALIDADE)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                int medico_id = rs.getInt("medico_id");
                int especialidade_id = rs.getInt("especialidade_id");
                entidades.add( new MedicoHasEspecialidade(
                        id,
                        servicoMedico.buscarPorId(medico_id),
                        servicoEspecialidade.buscarPorId(especialidade_id)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteMedicoHasEspecialidade(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateMedicoHasEspecialidade(MedicoHasEspecialidade entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_MEDICO_HAS_ESPECIALIDADE_SQL)) {
            statement.setLong(1, entidade.getMedico_id().getId());
            statement.setLong(2, entidade.getEspecialidade_id().getId());
            statement.setLong(3, entidade.getId());

            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
