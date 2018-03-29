package FoJaJo.Luffarschack.ejb.EAO;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import FoJaJo.Luffarschack.ejb.entities.Game;

/**
 * Session Bean implementation class GameEAO
 */
@Stateless
public class GameEAOImpl implements GameEAOLocal {

	@PersistenceContext(unitName = "Luffarschack")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GameEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createGame(Game game) {
		em.persist(game);
	}

	@Override
	public Game findGame(long id) {
		return em.find(Game.class, id);
	}

	@Override
	public void updateGame(Game game) {
		em.merge(game);
	}

	@Override
	public void deleteGame(long id) {
		Game game = this.findGame(id);
		if (game != null) {
			em.remove(game);
		}
	}

	@Override
	public List<Game> findAllGames() {
		TypedQuery<Game> tq = em.createNamedQuery("Game.findAllGames", Game.class);
		return tq.getResultList();
	}

	@Override
	public List<Game> findAllOpenGames() {
		TypedQuery<Game> tq = em.createNamedQuery("Game.findAllOpenGames", Game.class);
		return tq.getResultList();
	}

}
