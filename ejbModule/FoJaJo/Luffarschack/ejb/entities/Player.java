package FoJaJo.Luffarschack.ejb.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Player.getTopPlayers", 
			query="SELECT c FROM Player c ORDER BY c.rating DESC")
})

@Table(name = "Player")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private int rating;
	private Set<Game> firstPlayerGames;
	private Set<Game> secondPlayerGames;
	private Set<Move> moves;

	@Id
	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "rating")
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@OneToMany(mappedBy = "firstPlayer", fetch = FetchType.EAGER)
	public Set<Game> getFirstPlayerGames() {
		return firstPlayerGames;
	}

	public void setFirstPlayerGames(Set<Game> firstPlayerGames) {
		this.firstPlayerGames = firstPlayerGames;
	}

	@OneToMany(mappedBy = "secondPlayer", fetch = FetchType.EAGER)
	public Set<Game> getSecondPlayerGames() {
		return secondPlayerGames;
	}

	public void setSecondPlayerGames(Set<Game> secondPlayerGames) {
		this.secondPlayerGames = secondPlayerGames;
	}

	@OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
	public Set<Move> getMoves() {
		return moves;
	}

	public void setMoves(Set<Move> moves) {
		this.moves = moves;
	}
}
