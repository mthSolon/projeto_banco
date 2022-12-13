package util;

import model.ResultadoExame;
import servico.ServicoComposicao;
import servico.ServicoLaudo;
import servico.ServicoResultadoExame;

import java.sql.SQLException;

public class TesteResultadoExame {
    public static ServicoResultadoExame servicoResultadoExame = new ServicoResultadoExame();
    public static ServicoLaudo servicoLaudo = new ServicoLaudo();
    public static ServicoComposicao servicoComposicao = new ServicoComposicao();

    public static void main(String[] args) throws SQLException {
        long millis = System.currentTimeMillis();

        ResultadoExame resultadoExame = new ResultadoExame(
                new java.sql.Date(millis),
                "20",
                servicoComposicao.buscarPorId(1),
                servicoLaudo.buscarPorId(1)
        );

        servicoResultadoExame.salvar(resultadoExame);

        System.out.println(servicoResultadoExame.buscarTodos());

        ResultadoExame resultadoExame1 = servicoResultadoExame.buscarPorId(1);

        resultadoExame1.setValor("35");
        servicoResultadoExame.update(resultadoExame1);

        System.out.println(servicoResultadoExame.buscarPorId(1));
    }
}
