package mesa_de_trabalho.server.impl;

import mesa_de_trabalho.server.ISerieService;
import mesa_de_trabalho.server.SerieNaoHabilitadaException;

public class SerieProxy implements ISerieService {

    private Integer qtdViews = 0;
    private SerieService serieService = new SerieService();

    @Override
    public String getSerie(String nome) throws SerieNaoHabilitadaException {
        if(qtdViews < 5) {
            qtdViews++;
            return serieService.getSerie(nome);
        } else {
            throw new SerieNaoHabilitadaException("Você excedeu a quantidade de views :(");
        }

    }
}
