package top.jhana.es.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import top.jhana.es.domain.EsBlog;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {

    /**
     * 分页查询博客去重博客
     * @param title
     * @param Summary
     * @param Content
     * @param pageable
     * @return
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(
            String title,
            String Summary,
            String Content,
            Pageable pageable);
}
