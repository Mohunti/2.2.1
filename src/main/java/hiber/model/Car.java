package hiber.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "cars")
@Component
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "car_id")
    private int id;

    @Column(name= "model")
    private String model;

    @Column(name= "series")
    private int series;

    @OneToOne(mappedBy = "cars")
    private User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}