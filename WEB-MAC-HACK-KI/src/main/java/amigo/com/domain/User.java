package amigo.com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by Naver on 2017. 11. 8..
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private long id;

    @NotEmpty
    @Getter
    private String name;

    @NotEmpty
    @Getter
    private String email;

    private String gender;

    private int age;

    private String nationality;

    private String city;

    @JsonIgnore
    private int creditPoint;

    private String profileImg;

    private String contents;

    @OneToMany
    @JoinColumn(name = "writer_id")
    private Set<Photo> photos;

    @OneToMany
    @JoinColumn(name = "to_id")
    private Set<Review> reviews;

    private boolean emailConfirm = false;

    public boolean isConfirmdUser() {
        return emailConfirm;
    }

//    public void confirmEmail() {
//        emailConfirm = true;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}