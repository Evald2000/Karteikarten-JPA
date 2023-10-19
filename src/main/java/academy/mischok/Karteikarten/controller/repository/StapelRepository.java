package academy.mischok.Karteikarten.controller.repository;

import academy.mischok.Karteikarten.Stapel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StapelRepository extends JpaRepository<Stapel,Integer> {


}
