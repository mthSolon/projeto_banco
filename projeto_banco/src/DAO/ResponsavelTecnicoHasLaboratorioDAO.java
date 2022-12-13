package DAO;

import model.ResponsavelTecnicoHasLaboratorio;
import servico.ServicoLaboratorio;
import servico.ServicoResponsavelTecnico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsavelTecnicoHasLaboratorioDAO extends ConexaoDB {
    private static ServicoResponsavelTecnico servicoResponsavelTecnico = new ServicoResponsavelTecnico();
    private static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();
    private static final String INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "INSERT INTO responsavel_tecnico_has_laboratorio (responsavel_tecnico_id, laboratorio_id) VALUES (?, ?);";
    private static final String SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_RESPONSAVEL_TECNICO_ID = "SELECT responsavel_tecnico_id, laboratorio_id FROM responsavel_tecnico_has_laboratorio WHERE responsavel_tecnico_id = ?";
    private static final String SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO = "SELECT * FROM responsavel_tecnico_has_laboratorio;";
    private static final String DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "DELETE FROM responsavel_tecnico_has_laboratorio WHERE id = ?;";
    private static final String UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL = "UPDATE responsavel_tecnico_has_laboratorio SET responsavel_tecnico_id = ?, laboratorio_id = ? WHERE id = ?;";
    private static final String TOTAL = "SELECT count(1) FROM responsavel_tecnico_has_laboratorio;";

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

    public ResponsavelTecnicoHasLaboratorio insert(ResponsavelTecnicoHasLaboratorio entidade) {
        try (PreparedStatement preparedStatement = prepararSQL(INSERT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL,
                java.sql.Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setLong(1, entidade.getResponsavel_tecnico_id().getId());
            preparedStatement.setLong(2, entidade.getLaboratorio_id().getId());

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

    public List<ResponsavelTecnicoHasLaboratorio> finByResponsavelTecnicoId(long id) {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_RESPONSAVEL_TECNICO_HAS_LABORATORIO_BY_RESPONSAVEL_TECNICO_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
                int laboratorioId = rs.getInt("laboratorio_id");
                entidades.add(new ResponsavelTecnicoHasLaboratorio(
                        id,
                        servicoResponsavelTecnico.buscarPorId(responsavel_tecnico_id),
                        servicoLaboratorio.buscarPorId(laboratorioId)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public List<ResponsavelTecnicoHasLaboratorio> selectAllResponsavelTecnicoHasLaboratorios() {
        List<ResponsavelTecnicoHasLaboratorio> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_RESPONSAVEL_TECNICO_HAS_LABORATORIO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int responsavel_tecnico_id = rs.getInt("responsavel_tecnico_id");
                int laboratorioId = rs.getInt("laboratorio_id");
                entidades.add(new ResponsavelTecnicoHasLaboratorio(
                        servicoResponsavelTecnico.buscarPorId(responsavel_tecnico_id),
                        servicoLaboratorio.buscarPorId(laboratorioId)));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteResponsavelTecnicoHasLaboratorio(int id) throws SQLException {
        try (PreparedStatement statement = prepararSQL(DELETE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setInt(1, id);

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateResponsavelTecnicoHasLaboratorio(ResponsavelTecnicoHasLaboratorio entidade) throws SQLException {
        try (PreparedStatement statement = prepararSQL(UPDATE_RESPONSAVEL_TECNICO_HAS_LABORATORIO_SQL)) {
            statement.setLong(1, entidade.getResponsavel_tecnico_id().getId());
            statement.setLong(2, entidade.getLaboratorio_id().getId());
            statement.setLong(3, entidade.getId());

            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
