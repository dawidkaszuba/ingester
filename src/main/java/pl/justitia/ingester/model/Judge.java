package pl.justitia.ingester.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Judge {
    private String name;
    private String function;
    private List<String> specialRoles;
}
