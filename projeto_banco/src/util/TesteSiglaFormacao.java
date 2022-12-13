package util;

import model.SiglaFormacao;
import servico.ServicoSiglaFormacao;

import java.sql.SQLException;

public class TesteSiglaFormacao {
    public static ServicoSiglaFormacao servicoSiglaFormacao = new ServicoSiglaFormacao();

    public static void main(String[] args) throws SQLException {
        SiglaFormacao siglaFormacao = new SiglaFormacao("LDC");

        servicoSiglaFormacao.salvar(siglaFormacao);
        System.out.println(servicoSiglaFormacao.buscarPorId(1));

        SiglaFormacao siglaFormacao1 = servicoSiglaFormacao.buscarPorId(1);
        siglaFormacao1.setSigla("LAA");
        servicoSiglaFormacao.update(siglaFormacao1);

        System.out.println(servicoSiglaFormacao.buscarTodos());
    }
}
