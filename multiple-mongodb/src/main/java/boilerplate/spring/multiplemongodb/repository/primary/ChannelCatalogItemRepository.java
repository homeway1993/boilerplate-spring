package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.ChannelCatalogItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ChannelCatalogItemRepository extends MongoRepository<ChannelCatalogItem, String>, ChannelCatalogItemRepositoryCustom {

    @Query("{" +
            " 'channelBookingUnits.onlineStatus': 'online'," +
            " 'channel': ?0," +
            " 'channelBookingUnits.cbu.modelSeqNbr': { $in: ?1}" +
            "}")
    List<ChannelCatalogItem> findOnlineItemByChannelAndModelSeqNbrIn(String channel, List<String> modelSeqNbrList);
}
