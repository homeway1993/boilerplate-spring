package boilerplate.spring.multiplemongodb.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChannelCatalogItem {

    private String id;
    private String code;
    private List<Category> categories;
    private List<BookingUnit> channelBookingUnits;


    @Data
    public static class BookingUnit {
        private Cbu cbu;
    }

}
