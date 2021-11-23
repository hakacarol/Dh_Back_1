package mesa_de_trabalho.server;

public interface ISerieService {

    public String getSerie(String nome) throws SerieNaoHabilitadaException;
}
