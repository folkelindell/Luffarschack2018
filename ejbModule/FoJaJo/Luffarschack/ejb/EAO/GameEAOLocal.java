package FoJaJo.Luffarschack.ejb.EAO;

import java.util.List;

import javax.ejb.Local;

import FoJaJo.Luffarschack.ejb.entities.Game;

@Local
public interface GameEAOLocal {

	void createGame(Game game);

	Game findGame(long id);

	void updateGame(Game game);

	void deleteGame(long id);

	List<Game> findAllGames();

	List<Game> findAllOpenGames();

}
