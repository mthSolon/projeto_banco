package util;

import model.Laudo;
import servico.ServicoLaudo;
import servico.ServicoSolicitacaoExame;

import java.sql.SQLException;

public class TesteLaudo {
    public static ServicoLaudo servicoLaudo = new ServicoLaudo();
    public static ServicoSolicitacaoExame servicoSolicitacaoExame = new ServicoSolicitacaoExame();

    public static void main(String[] args) throws SQLException {
        Laudo laudo = new Laudo(
                "Matheus Solon",
                "24/11/2021",
                "41234512",
                servicoSolicitacaoExame.buscarPorId(1));

        servicoLaudo.salvar(laudo);

        System.out.println(servicoLaudo.buscarTodos());

        Laudo laudo1 = servicoLaudo.buscarPorId(1);

        laudo1.setCodigo("CODIGO 3331");
        servicoLaudo.update(laudo1);

        System.out.println(servicoLaudo.buscarPorId(1));
    }
}
