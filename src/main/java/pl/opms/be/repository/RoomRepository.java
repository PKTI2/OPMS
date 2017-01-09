package pl.opms.be.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import pl.opms.be.entity.RoomEntity;

/**
 * Created by howor on 08.01.2017.
 */
public interface RoomRepository extends PagingAndSortingRepository<RoomEntity, Long>,
        QueryDslPredicateExecutor<RoomEntity> {
}
