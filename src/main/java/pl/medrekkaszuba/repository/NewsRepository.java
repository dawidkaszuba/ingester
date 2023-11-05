package pl.medrekkaszuba.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.medrekkaszuba.model.NewsItem;

@Repository
public interface NewsRepository extends JpaRepository<NewsItem, Long> {
}
