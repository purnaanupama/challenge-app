package projectx.starter_app;
//This class store all challenges information. It defines what are stored inside each challenge
//It also provides getter setter methods to access and change variable values

import jakarta.persistence.*;

@Entity
public class Challenge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "challengeMonth")
    private String month;
    @Column(name = "challengeDescription")
    private String description;

    public Challenge() {
    }

    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getMonth() { return month; }

    public void setMonth(String month) { this.month = month; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
