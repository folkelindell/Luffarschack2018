package FoJaJo.Luffarschack.ejb.EAO;

import java.util.List;

import javax.ejb.Local;

import FoJaJo.Luffarschack.ejb.entities.Player;

@Local
public interface PlayerEAOLocal {

	Player findPlayer(String username);

	void createPlayer(Player player);

	void updatePlayer(Player player);

	void deletePlayer(String username);

	List<Player> getTopPlayers();

}
