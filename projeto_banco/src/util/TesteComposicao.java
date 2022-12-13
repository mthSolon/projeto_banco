package util;

import model.*;
import servico.*;

public class TesteComposicao {
    private static ServicoComposicao servicoComposicao = new ServicoComposicao();
    private static ServicoComposicaoExame servicoComposicaoExame = new ServicoComposicaoExame();
    private static ServicoExame servicoExame = new ServicoExame();
    private static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();
    private static ServicoTipoExame servicoTipoExame = new ServicoTipoExame();
    private static ServicoUnidadeMedida servicoUnidadeMedida = new ServicoUnidadeMedida();

    private static ServicoValorReferenciaComposicaoExame servicoValorReferenciaComposicaoExame = new ServicoValorReferenciaComposicaoExame();

    public static void main(String[] args) {
        MaterialExame matExame = new MaterialExame("Exemplo material", "Observação");
        servicoMaterialExame.salvar(matExame);
        MaterialExame materialExame = servicoMaterialExame.buscarPorId(1);

        TipoExame tipoExame = new TipoExame("Exame de sangue", "observacao");
        tipoExame = servicoTipoExame.buscarPorId(1);

        Exame exame = new Exame("Descrição", "Método", materialExame, tipoExame);
        servicoExame.salvar(exame);

        UnidadeMedida unidadeMedida = new UnidadeMedida("cm");
        servicoUnidadeMedida.salvar(unidadeMedida);


        ComposicaoExame composicaoExame = new ComposicaoExame("Exame", unidadeMedida);
        servicoComposicaoExame.salvar(composicaoExame);

      ValorReferenciaComposicaoExame valorReferenciaComposicaoExame =
              new ValorReferenciaComposicaoExame("min", "max", "lim", "lim_max", servicoUnidadeMedida.buscarPorId(1));
      servicoValorReferenciaComposicaoExame.salvar(valorReferenciaComposicaoExame);


        Composicao composicao = new Composicao(servicoExame.buscarPorId(1), servicoComposicaoExame.buscarPorId(1), servicoValorReferenciaComposicaoExame.buscarPorId(1));

        //salvar
        servicoComposicao.salvar(composicao);

        //listar
        System.out.println(servicoValorReferenciaComposicaoExame.buscarPorId(1));
         System.out.println(servicoComposicao.buscarTodos());

    }
}
