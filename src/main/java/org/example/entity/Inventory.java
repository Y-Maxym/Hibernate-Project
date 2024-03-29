package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.interfaces.EntityClass;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "inventory", schema = "movie")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory implements EntityClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false, columnDefinition = "mediumint")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Film film;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Store store;

    @OneToMany(mappedBy = "inventory", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.EXTRA)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<Rental> rentals = new HashSet<>();

    @UpdateTimestamp
    @Column(name = "last_update", nullable = false)
    @EqualsAndHashCode.Exclude
    private ZonedDateTime lastUpdate;
}