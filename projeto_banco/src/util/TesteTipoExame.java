package util;

import model.TipoExame;
import servico.ServicoExame;
import servico.ServicoTipoExame;

import java.sql.SQLException;

public class TesteTipoExame {
    private static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();

    public static void main(String[] args) throws SQLException {
        TipoExame tipoExame = new TipoExame("Raio-x", "OBS");

        servicoTipoExame.salvar(tipoExame);

        System.out.println(servicoTipoExame.buscarTodos());;

        tipoExame = servicoTipoExame.buscarPorId(1);
        tipoExame.setObservacao("qqqqqqq");
        servicoTipoExame.update(tipoExame);

        System.out.println(servicoTipoExame.buscarTodos());;
    }
}
