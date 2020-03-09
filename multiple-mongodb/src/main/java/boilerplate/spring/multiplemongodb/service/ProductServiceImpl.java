package boilerplate.spring.multiplemongodb.service;

import boilerplate.spring.multiplemongodb.entity.Cbu;
import boilerplate.spring.multiplemongodb.entity.ChannelCatalogItem;
import boilerplate.spring.multiplemongodb.entity.Inventory;
import boilerplate.spring.multiplemongodb.repository.primary.ChannelCatalogItemRepository;
import boilerplate.spring.multiplemongodb.repository.secondary.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ChannelCatalogItemRepository channelCatalogItemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public List<String> findCodeHasInventory() {
        List<String> modelSeqNbrList = inventoryRepository.findHasQuantityByDepartmentCode("247")
                .stream()
                .map(Inventory::getCbu)
                .map(Cbu::getModelSeqNbr)
                .distinct()
                .collect(Collectors.toList());

        return channelCatalogItemRepository.findOnlineItemByChannelAndModelSeqNbrIn("HKGEMPO", modelSeqNbrList)
                .stream()
                .map(ChannelCatalogItem::getCode)
                .distinct()
                .collect(Collectors.toList());
    }
}
