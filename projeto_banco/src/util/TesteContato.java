package util;

import model.Contato;
import servico.ServicoContato;
import servico.ServicoLaboratorio;

import java.sql.SQLException;

public class TesteContato {
    public static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();
    public static ServicoContato servicoContato = new ServicoContato();

    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato("8598837493", servicoLaboratorio.buscarPorId(1));
        servicoContato.salvar(contato);

        System.out.println(servicoContato.buscarTodos());

        Contato contato1 = servicoContato.buscarPorId(1);

        contato1.setTelefone("8775482283");
        servicoContato.update(contato1);

        System.out.println(servicoContato.buscarPorId(1));
    }
}
