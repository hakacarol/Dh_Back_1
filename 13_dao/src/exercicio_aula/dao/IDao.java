package exercicio_aula.dao;

public interface IDao<T>{

    // recebendo e manipulando um objeto
    public T insert (T t);
    public  void delete(Integer id);
    public void select(Integer id);
    public void selectAll();
    public void selectCodigo (String codigo);

}
