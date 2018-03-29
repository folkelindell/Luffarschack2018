package FoJaJo.Luffarschack.ejb.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQueries({
	@NamedQuery(name="Game.findAllGames",
			query="SELECT g FROM Game g"),
	@NamedQuery(name="Game.findAllOpenGames",
	query="SELECT g FROM Game g WHERE g.gameStatus = 'WAITING_FOR_PLAYER'")
})
@Table(name = "Game")
@SequenceGenerator(name = "ID_SEQ", allocationSize = 1)
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private Player firstPlayer;
	private Player secondPlayer;
	private String gameStatus;
	private String startingPiece;
	private Timestamp timeCreated;
	private Set<Move> moves;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "firstPlayerUsername", referencedColumnName = "username")
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	@ManyToOne
	@JoinColumn(name = "secondPlayerUsername", referencedColumnName = "username")
	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(Player secondPlayer) {
		this.secondPlayer = secondPlayer;
	}

	@Column(name = "gameStatus")
	public String getGameStatus() {
		return gameStatus;
	}

	public void setGameStatus(String gameStatus) {
		this.gameStatus = gameStatus;
	}

	@Column(name = "startingPiece")
	public String getStartingPiece() {
		return startingPiece;
	}

	public void setStartingPiece(String startingPiece) {
		this.startingPiece = startingPiece;
	}

	@Column(name = "timeCreated")
	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
	public Set<Move> getMoves() {
		return moves;
	}

	public void setMoves(Set<Move> moves) {
		this.moves = moves;
	}

}