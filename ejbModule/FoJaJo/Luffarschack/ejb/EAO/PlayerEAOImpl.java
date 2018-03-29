package FoJaJo.Luffarschack.ejb.EAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import FoJaJo.Luffarschack.ejb.entities.Player;

/**
 * Session Bean implementation class PlayerEAO
 */
@Stateless
public class PlayerEAOImpl implements PlayerEAOLocal {

	@PersistenceContext(unitName = "Luffarschack")
	private EntityManager em;

	public PlayerEAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Player findPlayer(String username) {
		return em.find(Player.class, username);
	}

	@Override
	public void createPlayer(Player player) {
		em.persist(player);
	}

	@Override
	public void updatePlayer(Player player) {
		em.merge(player);
	}

	@Override
	public void deletePlayer(String username) {
		Player p = this.findPlayer(username);
		if (p != null) {
			em.remove(p);
		}
	}

	@Override
	public List<Player> getTopPlayers() {
		// om denna inte fungerar kolla NamedQueryn efter DESC i queryn
		TypedQuery<Player> tq = em.createNamedQuery("Player.getTopPlayers", Player.class);
		tq.setFirstResult(0);
		tq.setMaxResults(5);

		List<Player> list = tq.getResultList();
		return list;
	}

}

