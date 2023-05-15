package be.webideas.calidom.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(builderMethodName = "heatingProductBuilder")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "heatings")
public class HeatingProduct extends Product {
    private String model;
    private double power;
    private double pressureMax;
    private double temperatureMax;
    private int height;
    private int width;
    private int depth;
}
