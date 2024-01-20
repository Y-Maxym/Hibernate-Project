package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.interfaces.EntityClass;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "country", schema = "movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country implements EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private Long id;

    @Column(name = "country", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<City> cities;

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    private ZonedDateTime lastUpdate;

    @Override
    @SuppressWarnings("all")
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}