package dao;

import java.util.ArrayList;

public interface IDao <T>{
    public void create();
    public T insert (T t);
    public void select(Integer id);
    public ArrayList selectAll ();
    public void update(Integer id, String coluna, String novoValor);
    public void delete(Integer id);
}
