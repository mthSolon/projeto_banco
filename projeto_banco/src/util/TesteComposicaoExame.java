package util;

import model.ComposicaoExame;
import servico.ServicoComposicao;
import servico.ServicoComposicaoExame;
import servico.ServicoUnidadeMedida;

import java.sql.SQLException;

public class TesteComposicaoExame {
    public static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();
    public static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();
    public static void main(String[] args) throws SQLException {
        ComposicaoExame composicaoExame = new ComposicaoExame(
                "Descrição exame",
                servicoUnidadeMedida.buscarPorId(1));

        // salvar
        servicoComposicaoExame.salvar(composicaoExame);

        // listar
        System.out.println(servicoComposicaoExame.buscarTodos());

        // buscar
        ComposicaoExame composicaoExame1 = servicoComposicaoExame.buscarPorId(1);

        // editar
        composicaoExame1.setDescricao("descc");
        servicoComposicaoExame.update(composicaoExame1);

        System.out.println(servicoComposicaoExame.buscarPorId(1));

    }
}
