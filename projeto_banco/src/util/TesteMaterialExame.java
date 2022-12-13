package util;

import model.MaterialExame;
import servico.ServicoMaterialExame;

import java.sql.SQLException;

public class TesteMaterialExame {
    public static ServicoMaterialExame servicoMaterialExame = new ServicoMaterialExame();

    public static void main(String[] args) throws SQLException {
        MaterialExame materialExame = new MaterialExame("Material", "OBS");
        servicoMaterialExame.salvar(materialExame);
        System.out.println(servicoMaterialExame.buscarTodos());

        MaterialExame materialExameOutro = servicoMaterialExame.buscarPorId(1);

        materialExameOutro.setMaterial("Material Tóxico!");
        servicoMaterialExame.update(materialExameOutro);

        System.out.println(materialExameOutro);
    }
}
