package Dao;

import java.util.List;

import model.Evento;

public interface IEventoDAO {

	public void save(Evento e);
	public Evento getById(Long id);
	public void delete(Evento e);
	public void update(Evento e);
	public List<Evento> getAll();
	
}
