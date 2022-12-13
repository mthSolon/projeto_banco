package util;

import model.Endereco;
import servico.ServicoEndereco;
import servico.ServicoLaboratorio;

import java.sql.SQLException;

public class TesteEndereco {
    public static ServicoEndereco servicoEndereco = new ServicoEndereco();
    public static ServicoLaboratorio servicoLaboratorio = new ServicoLaboratorio();

    public static void main(String[] args) throws SQLException {
        Endereco endereco = new Endereco(
                "Rua Exemplo",
                "21",
                "A",
                "Conjunto Palmeira",
                "600120-95",
                "Fortaleza",
                servicoLaboratorio.buscarPorId(1));

        servicoEndereco.salvar(endereco);

        System.out.println(servicoEndereco.buscarTodos());

        Endereco endereco1 = servicoEndereco.buscarPorId(1);

        endereco1.setRua("Rua Exemplo Editado");
        servicoEndereco.update(endereco1);

        System.out.println(endereco1);
    }
}
