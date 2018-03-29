package FoJaJo.Luffarschack.ejb.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@NamedQueries({ @NamedQuery(name = "Move.findAllMovesInGame", query = "SELECT m FROM Move m WHERE m.game=:game"),
		@NamedQuery(name = "Move.findAllMovesInGameByPlayer", query = "SELECT m FROM Move m WHERE m.game=:game AND m.player=:player"), })
@Table(name = "Move")
@SequenceGenerator(name = "ID_SEQ", allocationSize = 1)
public class Move implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private Player player;
	private Game game;
	private int xPos;
	private int yPos;
	private Timestamp timeCreated;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "playerUsername", referencedColumnName = "username")
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@ManyToOne
	@JoinColumn(name = "gameId", referencedColumnName = "id")
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Column(name = "xPos")
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	@Column(name = "yPos")
	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	@Column(name = "timeCreated")
	public Timestamp getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

}