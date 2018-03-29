package FoJaJo.Luffarschack.ejb.EAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import FoJaJo.Luffarschack.ejb.entities.Game;
import FoJaJo.Luffarschack.ejb.entities.Move;
import FoJaJo.Luffarschack.ejb.entities.Player;

/**
 * Session Bean implementation class MoveEAO
 */
@Stateless
public class MoveEAOImpl implements MoveEAOLocal {

	@PersistenceContext(unitName = "Luffarschack")
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public MoveEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Move> findMovesInGame(Game game) {
		TypedQuery<Move> tq = em.createNamedQuery("Move.findAllMovesInGame", Move.class);
		tq.setParameter("game", game);
		return tq.getResultList();
	}

	@Override
	public List<Move> findMovesInGameByPlayer(Game game, Player player) {
		TypedQuery<Move> tq = em.createNamedQuery("Move.findAllMovesInGameByPlayer", Move.class);
		tq.setParameter("game", game);
		tq.setParameter("player", player);
		return tq.getResultList();
	}

	@Override
	public void createMove(Move move) {
		em.persist(move);
	}
}
