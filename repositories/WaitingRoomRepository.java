package hassan.essadik.waitingroom.repositories;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import hassan.essadik.waitingroom.entities.WaitingRoom;

public interface WaitingRoomRepository extends JpaRepository<WaitingRoom, Date>{

}
