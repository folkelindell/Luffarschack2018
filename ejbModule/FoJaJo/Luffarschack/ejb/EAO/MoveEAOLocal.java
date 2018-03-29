package FoJaJo.Luffarschack.ejb.EAO;

import java.util.List;

import javax.ejb.Local;

import FoJaJo.Luffarschack.ejb.entities.Game;
import FoJaJo.Luffarschack.ejb.entities.Move;
import FoJaJo.Luffarschack.ejb.entities.Player;

@Local
public interface MoveEAOLocal {

	List<Move> findMovesInGame(Game game);

	List<Move> findMovesInGameByPlayer(Game game, Player player);

	void createMove(Move move);

}
