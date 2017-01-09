package pl.opms.be.service;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.opms.be.entity.RoomEntity;
import pl.opms.be.repository.RoomRepository;

import java.util.List;

/**
 * Created by Piotr Borczyk on 09.01.2017.
 */

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public RoomEntity findOne(Long id) {
        return roomRepository.findOne(id);
    }
}
