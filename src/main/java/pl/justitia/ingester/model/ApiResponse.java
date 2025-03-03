package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApiResponse {
    private List<Link> links;
    private List<Item> items;
}
