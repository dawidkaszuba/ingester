package pl.medrekkaszuba.ingester.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.medrekkaszuba.ingester.model.NewsItem;

@Repository
public interface NewsRepository extends JpaRepository<NewsItem, Long> {
}
