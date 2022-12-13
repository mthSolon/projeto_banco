package util;

import model.Especialidade;
import servico.ServicoEspecialidade;

import java.sql.SQLException;

public class TesteEspecialidade {
    public static ServicoEspecialidade servicoEspecialidade = new ServicoEspecialidade();

    public static void main(String[] args) throws SQLException {
        Especialidade especialidade = new Especialidade("Clínico Geral", "O melhor da cidade");

        servicoEspecialidade.salvar(especialidade);

        Especialidade especialidade1 = servicoEspecialidade.buscarPorId(1);

        especialidade1.setObservacao("Teste");
        servicoEspecialidade.update(especialidade1);
        System.out.println(servicoEspecialidade.buscarTodos());
    }
}
