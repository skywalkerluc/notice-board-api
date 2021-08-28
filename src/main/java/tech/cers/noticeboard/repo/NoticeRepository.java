package tech.cers.noticeboard.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.cers.noticeboard.models.Notice;

import java.util.Optional;

public interface NoticeRepository extends JpaRepository<Notice, Long>  {
  Optional<Notice> findNoticeById(Long id);
}
