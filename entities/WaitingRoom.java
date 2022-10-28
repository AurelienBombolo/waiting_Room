package hassan.essadik.waitingroom.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "waitingroom")
public class WaitingRoom {
	@Id
	private Date date;
	private int visit;
	private int cancel;
	private int done;
}
