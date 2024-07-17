package challege.foro.domain.topicos;

import challege.foro.controller.TopicosController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<Topicos, Long> {
    Page<Topicos> findByStatusTrue(Pageable pageable);
}
