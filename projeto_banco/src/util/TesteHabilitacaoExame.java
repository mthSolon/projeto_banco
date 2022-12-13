package util;

import model.HabilitacaoExame;
import servico.ServicoHabilitacaoExame;
import servico.ServicoLaboratorio;
import servico.ServicoTipoExame;

import java.sql.SQLException;

public class TesteHabilitacaoExame {
    public static ServicoHabilitacaoExame servicoHabilitacaoExame = new ServicoHabilitacaoExame();
    public static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();
    private static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();

    public static void main(String[] args) throws SQLException {
        HabilitacaoExame habilitacaoExame = new HabilitacaoExame(
                "",
                10.00,
                servicoLaboratorio.buscarPorId(1),
                servicoTipoExame.buscarPorId(1));

        servicoHabilitacaoExame.salvar(habilitacaoExame);

        System.out.println(servicoHabilitacaoExame.buscarTodos());

        HabilitacaoExame habilitacaoExame1 = servicoHabilitacaoExame.buscarPorId(1);
        habilitacaoExame1.setCusto(40.00);
        servicoHabilitacaoExame.update(habilitacaoExame1);

        System.out.println(servicoHabilitacaoExame.buscarPorId(1));
    }
}
