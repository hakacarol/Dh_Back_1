package mesa_de_trabalho.server.impl;

import mesa_de_trabalho.server.ISerieService;

public class SerieService implements ISerieService {

    @Override
    public String getSerie(String nome) {
        return "www." + nome + ".com.br";
    }
}
