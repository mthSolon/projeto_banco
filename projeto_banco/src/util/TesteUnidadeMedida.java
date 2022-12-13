package util;

import model.UnidadeMedida;
import servico.ServicoUnidadeMedida;

import java.sql.SQLException;

public class TesteUnidadeMedida {
    public static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();

    public static void main(String[] args) throws SQLException {
        UnidadeMedida unidadeMedida = new UnidadeMedida("cm");

        servicoUnidadeMedida.salvar(unidadeMedida);

        System.out.println(servicoUnidadeMedida.buscarTodos());

        UnidadeMedida unidadeMedida1 = servicoUnidadeMedida.buscarPorId(1);

        unidadeMedida1.setDescricao("mm");
        servicoUnidadeMedida.update(unidadeMedida1);

        System.out.println(servicoUnidadeMedida.buscarTodos());
    }
}
