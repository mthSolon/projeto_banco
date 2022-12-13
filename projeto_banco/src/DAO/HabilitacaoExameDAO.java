package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HabilitacaoExame;
import servico.ServicoExame;
import servico.ServicoLaboratorio;
import servico.ServicoTipoExame;

public class HabilitacaoExameDAO extends ConexaoDB {
	private static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();
	private static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();
	private static final String INSERT_HABILITACAO_EXAME_SQL = "INSERT INTO HABILITACAO_EXAME (observacao, custo, id_laboratorio, tipo_exame_id) VALUES (?, ?, ?, ?);";
	private static final String SELECT_HABILITACAO_EXAME_BY_ID = "SELECT id, observacao, custo, id_laboratorio, tipo_exame_id FROM HABILITACAO_EXAME WHERE id = ?";
	private static final String SELECT_ALL_HABILITACAO_EXAME = "SELECT * FROM HABILITACAO_EXAME;";
	private static final String DELETE_HABILITACAO_EXAME_SQL = "DELETE FROM HABILITACAO_EXAME WHERE id = ?;";
	private static final String UPDATE_HABILITACAO_EXAME_SQL = "UPDATE HABILITACAO_EXAME SET observacao = ?, custo = ?, id_laboratorio = ?, tipo_exame_id = ? WHERE id = ?;";
	private static final String TOTAL = "SELECT count(1) FROM HABILITACAO_EXAME;";
    
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
    
    public HabilitacaoExame insert(HabilitacaoExame entidade) {
		try (PreparedStatement preparedStatement = prepararSQL(INSERT_HABILITACAO_EXAME_SQL,
				java.sql.Statement.RETURN_GENERATED_KEYS)) {

			preparedStatement.setString(1, entidade.getObservacao());
			preparedStatement.setDouble(2, entidade.getCusto());
			preparedStatement.setLong(3, entidade.getId_laboratorio().getId());
			preparedStatement.setLong(4, entidade.getTipo_exame_id().getId());
			
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
    
    public HabilitacaoExame findById(long id) {
		HabilitacaoExame entidade = null;
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_HABILITACAO_EXAME_BY_ID)) {
			preparedStatement.setLong(1, id);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String observacao = rs.getString("observacao");
				double custo = rs.getDouble("custo");
				int laboratorioId = rs.getInt("id_laboratorio");
				int tipoExameId = rs.getInt("tipo_exame_id");
				
				entidade = new HabilitacaoExame(
						id,
						observacao,
						custo,
						servicoLaboratorio.buscarPorId(laboratorioId),
						servicoTipoExame.buscarPorId(tipoExameId));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidade;
	}
    
    public List<HabilitacaoExame> selectAllHabilitacaoExames() {
		List<HabilitacaoExame> entidades = new ArrayList<>();
		try (PreparedStatement preparedStatement = prepararSQL(SELECT_ALL_HABILITACAO_EXAME)) {
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				long id = rs.getLong("id");
				String observacao = rs.getString("observacao");
				double custo = rs.getDouble("custo");
				int laboratorioId = rs.getInt("id_laboratorio");
				int tipoExameId = rs.getInt("tipo_exame_id");
				
				entidades.add(new HabilitacaoExame(
						id,
						observacao,
						custo,
						servicoLaboratorio.buscarPorId(laboratorioId),
						servicoTipoExame.buscarPorId(tipoExameId)));
			}
		} catch (SQLException e) {
			printSQLException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return entidades;
	}
    
    public boolean deleteHabilitacaoExame(int id) throws SQLException {
		try (PreparedStatement statement = prepararSQL(DELETE_HABILITACAO_EXAME_SQL)) {
			statement.setInt(1, id);

			return statement.executeUpdate() > 0;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
    
    public void updateHabilitacaoExame(HabilitacaoExame entidade) throws SQLException {
		try (PreparedStatement statement = prepararSQL(UPDATE_HABILITACAO_EXAME_SQL)) {
			statement.setString(1, entidade.getObservacao());
			statement.setDouble(2, entidade.getCusto());
			statement.setLong(3, entidade.getId_laboratorio().getId());
			statement.setLong(4, entidade.getTipo_exame_id().getId());
			statement.setLong(5, entidade.getId());

			statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
