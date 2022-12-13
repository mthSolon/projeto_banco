package util;

import model.Exame;
import model.MaterialExame;
import servico.ServicoExame;
import servico.ServicoMaterialExame;
import servico.ServicoTipoExame;

import java.sql.SQLException;

public class TesteExame {
    public static ServicoExame servicoExame = new ServicoExame();
    public static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();
    public static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();

    public static void main(String[] args) throws SQLException {
        Exame exame = new Exame(
                	"Raio-x",
                	"Laboratorial",
                	servicoMaterialExame.buscarPorId(1),
                	servicoTipoExame.buscarPorId(1));

        servicoExame.salvar(exame);

        System.out.println(servicoExame.buscarTodos());

        Exame exame1 = servicoExame.buscarPorId(1);

        exame1.setDescricao("Descrição");
        servicoExame.update(exame1);

        System.out.println(exame1);
    }
}
