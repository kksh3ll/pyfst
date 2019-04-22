package top.jhana.es.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.jhana.es.domain.EsBlog;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
}
