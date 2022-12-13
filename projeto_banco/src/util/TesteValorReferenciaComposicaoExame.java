package util;

import model.ValorReferenciaComposicaoExame;
import servico.ServicoUnidadeMedida;
import servico.ServicoValorReferenciaComposicaoExame;

import java.sql.SQLException;

public class TesteValorReferenciaComposicaoExame {
    public static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();
    public static ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();

    public static void main(String[] args) throws SQLException {
        ValorReferenciaComposicaoExame valorReferenciaComposicaoExame = new ValorReferenciaComposicaoExame(
                "val_minimo",
                "val_maximo",
                "lim_min",
                "lim_max",
                servicoUnidadeMedida.buscarPorId(1));

        servicoValorReferenciaComposicaoExame.salvar(valorReferenciaComposicaoExame);
        System.out.println(servicoValorReferenciaComposicaoExame.buscarTodos());

        ValorReferenciaComposicaoExame valorReferenciaComposicaoExame1 = servicoValorReferenciaComposicaoExame.buscarPorId(1);

        valorReferenciaComposicaoExame1.setValor_maximo("Maximo editado");
        servicoValorReferenciaComposicaoExame.update(valorReferenciaComposicaoExame1);

        System.out.println(servicoValorReferenciaComposicaoExame.buscarPorId(1));
    }
}
